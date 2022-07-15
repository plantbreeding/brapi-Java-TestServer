package org.brapi.test.BrAPITestServer.auth;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.brapi.test.BrAPITestServer.BrapiExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

public class BrapiTestServerJWTAuthFilter extends BasicAuthenticationFilter {
	private static final Logger log = LoggerFactory.getLogger(BrapiTestServerJWTAuthFilter.class);
	private static final List<String> ADMIN_IDS = Arrays.asList("dummyAdmin", "ps664@cornell.edu");

	private String oidcDiscoveryUrl;

	public BrapiTestServerJWTAuthFilter(AuthenticationManager authManager, String oidcDiscoveryUrl) {
		super(authManager);
		this.oidcDiscoveryUrl = oidcDiscoveryUrl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader("Authorization");

		// Anonymous User
		if (header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(req, res);
			return;
		}

		// Token Available
		try {
			String token = header.replaceFirst("Bearer ", "");
			AuthDetails userDetails = validateToken(token);

			if (userDetails != null) {
				List<GrantedAuthority> authorities = getAuthorities(userDetails);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails.getUserId(), null, authorities);
				authentication.setDetails(userDetails);

				SecurityContextHolder.getContext().setAuthentication(authentication);
			} else {
				throw new GeneralSecurityException("Auth Error");
			}

			chain.doFilter(req, res);

		} catch (GeneralSecurityException e) {
			String msg = determineExceptionCause(e);
			log.error(msg);
			res.addHeader("WWW-Authenticate", "Basic realm=\"\"");
			res.setStatus(HttpStatus.UNAUTHORIZED.value());
			res.getWriter().print(msg);
			res.getWriter().flush();
//			res.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase() + " - " + msg);
		}
	}

	private String determineExceptionCause(GeneralSecurityException e) {
		String msg = HttpStatus.UNAUTHORIZED.toString() + " - ";
		Throwable exception = e;
		msg += exception.getMessage();
		while (exception.getCause() != null){
			exception = exception.getCause();
			msg +=  " - " + exception.getMessage();
		} 
		msg += "\nPlease go to https://brapi.org/oauth and login to generate a fresh token, or use the dummy token 'XXXX'";
		return msg;
	}

	private AuthDetails validateToken(String token)
			throws FileNotFoundException, IOException, GeneralSecurityException {

		AuthDetails userDetails = null;
		if (token.equals("XXXX") || token.equals("YYYY")) {
			userDetails = validateDummyToken(token);
		} else {
			userDetails = validateOAuthToken(token);
		}
		return userDetails;
	}

	private AuthDetails validateDummyToken(String token) {
		AuthDetails details = null;
		if (token.equals("XXXX")) {
			details = new AuthDetails();
			details.setUserId("dummy");
			details.setExpirationTimestamp(Long.MAX_VALUE);
		} else if (token.equals("YYYY")) {
			details = new AuthDetails();
			details.setUserId("dummyAdmin");
			details.setExpirationTimestamp(Long.MAX_VALUE);
		}
		return details;
	}

	private AuthDetails validateOAuthToken(String token) throws GeneralSecurityException {
		try {
			token = token.replaceFirst("Bearer ", "");
			RSAPublicKey pubKey = getPublicKey(oidcDiscoveryUrl);

			Algorithm algorithm = Algorithm.RSA256(pubKey, null);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer("https://auth.brapi.org/auth/realms/brapi")
					.build();
			DecodedJWT jwt = verifier.verify(token);

			AuthDetails details = new AuthDetails();
			details.setUserId(jwt.getClaim("email").asString());
			details.setExpirationTimestamp(jwt.getExpiresAt());
			return details;
		} catch (JWTVerificationException e) {
			throw new GeneralSecurityException("Invalid JWT", e);
		} catch (Exception e) {
			throw new GeneralSecurityException("JWT Verification Process Failed", e);
		}
	}

	private RSAPublicKey getPublicKey(String discoveryURL) {
		try {
			JsonNode discovery = (new ObjectMapper()).readTree(new URL(discoveryURL));
			String jwksURL = discovery.findValue("jwks_uri").asText();
			JsonNode jwks = (new ObjectMapper()).readTree(new URL(jwksURL));
			String keyVal = jwks.findValue("keys").get(0).findValue("x5c").get(0).asText();

			String certb64 = keyVal;
			byte[] certder = Base64.decodeBase64(certb64);
			InputStream certstream = new ByteArrayInputStream(certder);
			Certificate cert = CertificateFactory.getInstance("X.509").generateCertificate(certstream);
			RSAPublicKey pubKey = (RSAPublicKey) cert.getPublicKey();
			return pubKey;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (CertificateException e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<GrantedAuthority> getAuthorities(AuthDetails userDetails) {
		List<GrantedAuthority> auth = new ArrayList<>();
		if (userDetails != null) {
			GrantedAuthority user = new SimpleGrantedAuthority("ROLE_USER");
			auth.add(user);
			userDetails.addRole("ROLE_USER");
			if (ADMIN_IDS.contains(userDetails.getUserId())) {
				GrantedAuthority admin = new SimpleGrantedAuthority("ROLE_ADMIN");
				auth.add(admin);
				userDetails.addRole("ROLE_ADMIN");
			}
		}
		return auth;
	}
}
