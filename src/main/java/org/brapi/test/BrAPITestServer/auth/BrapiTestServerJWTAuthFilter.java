package org.brapi.test.BrAPITestServer.auth;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.api.client.util.PemReader;

public class BrapiTestServerJWTAuthFilter extends BasicAuthenticationFilter {
	private static final List<String> USER_IDS = Arrays.asList("dummy", "dummyAdmin", "113212610256718182401");
	private static final List<String> ADMIN_IDS = Arrays.asList("dummyAdmin", "113212610256718182401");
	private static final String OIDC_DISCOVERY_URL = "https://auth.brapi.org/auth/realms/brapi/.well-known/openid-configuration";

	public BrapiTestServerJWTAuthFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader("Authorization");

		if (header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(req, res);
			return;
		}

		try {
			String userId = checkAuthentication(req);
			if (userId != null) {
				List<GrantedAuthority> authorities = getAuthorities(userId);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userId,
						null, authorities);

				SecurityContextHolder.getContext().setAuthentication(authentication);
			} else {
				throw new GeneralSecurityException("Auth Error");
			}
		} catch (GeneralSecurityException e) {
			res.addHeader("WWW-Authenticate", "Basic realm=\"\"");
			res.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
		}
		chain.doFilter(req, res);
	}

	private String checkAuthentication(HttpServletRequest req)
			throws FileNotFoundException, IOException, GeneralSecurityException {
		String userId = checkDummyAuthentication(req);
		if (userId == null) {
			userId = validateOAuthToken(req);
		}
		return userId;
	}

	private List<GrantedAuthority> getAuthorities(String userId) {
		List<GrantedAuthority> auth = new ArrayList<>();
		if (userId != null) {
			if (USER_IDS.contains(userId)) {
				GrantedAuthority user = new SimpleGrantedAuthority("USER");
				auth.add(user);
			}
			if (ADMIN_IDS.contains(userId)) {
				GrantedAuthority admin = new SimpleGrantedAuthority("ADMIN");
				auth.add(admin);
			}
		}
		return auth;
	}

	private String validateOAuthToken(HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization");
			if (token != null) {
				token = token.replaceFirst("Bearer ", "");
				RSAPublicKey pubKey = getPublicKey(OIDC_DISCOVERY_URL);
								
				Algorithm algorithm = Algorithm.RSA256(pubKey, null);
				JWTVerifier verifier = JWT.require(algorithm)
						.withIssuer("https://auth.brapi.org/auth/realms/brapi")
						.build(); 
				DecodedJWT jwt = verifier.verify(token);
				return jwt.getClaim("email").asString();
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	private String checkDummyAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null) {
			if (token.equals("Bearer XXXX")) {
				return "dummy";
			} else if (token.equals("Bearer YYYY")) {
				return "dummyAdmin";
			}
			return null;
		}
		return null;
	}

	private RSAPublicKey getPublicKey(String discoveryURL) {
		try {
			JsonNode discovery = (new ObjectMapper()).readTree(new URL(discoveryURL));
			String jwksURL = discovery.findValue("jwks_uri").asText();
			JsonNode jwks = (new ObjectMapper()).readTree(new URL(jwksURL));
			String keyVal = jwks.findValue("keys").get(0).findValue("x5c").get(0).asText();
			//keyVal = "-----BEGIN CERTIFICATE-----\n" + keyVal + "\n-----END CERTIFICATE-----";
			
//			byte[] encoded = Base64.decodeBase64(keyVal);
//			
//            KeyFactory kf = KeyFactory.getInstance("RSA");
//		    RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(new X509EncodedKeySpec(encoded));
//			
//			return pubKey;		    
			
			String certb64 = keyVal;
			byte[] certder = Base64.decodeBase64(certb64);
			InputStream certstream = new ByteArrayInputStream(certder);
			Certificate cert = CertificateFactory.getInstance("X.509").generateCertificate(certstream);
			RSAPublicKey pubKey = (RSAPublicKey) cert.getPublicKey();
			return pubKey;	
		} catch (IOException e) {
			e.printStackTrace();
			return null;
//		} catch (InvalidKeySpecException e) {
//			e.printStackTrace();
//			return null;
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//			return null;
		} catch (CertificateException e) {
			e.printStackTrace();
			return null;
		}
	}
}
