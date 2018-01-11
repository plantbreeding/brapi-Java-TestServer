package org.brapi.test.BrAPITestServer.auth;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.auth.openidconnect.IdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

public class BrapiTestServerJWTAuthFilter extends BasicAuthenticationFilter {
	private static final JsonFactory jacksonFactory = new JacksonFactory();

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
			}
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		chain.doFilter(req, res);
	}

	private List<GrantedAuthority> getAuthorities(String userId) {
		List<GrantedAuthority> auth = new ArrayList<>();
		if (userId != null) {
			GrantedAuthority user = new SimpleGrantedAuthority("USER");
			auth.add(user);
			if (userId.equals("113212610256718182401")) {
				GrantedAuthority admin = new SimpleGrantedAuthority("ADMIN");
				auth.add(admin);
			}
		}
		return auth;
	}

	private String checkAuthentication(HttpServletRequest request)
			throws FileNotFoundException, IOException, GeneralSecurityException {
		String token = request.getHeader("Authorization");
		if (token != null) {
			HttpTransport transport = new ApacheHttpTransport();
			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
					.setAudience(Collections
							.singletonList("408930718026-1m4t6slfmp8c0vu0a4s0sp4ujvv3vqfa.apps.googleusercontent.com"))
					// Or, if multiple clients access the backend:
					// .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
					.build();

			GoogleIdToken idToken = verifier.verify(token.replace("Bearer ", ""));
			if (idToken != null) {
				Payload payload = idToken.getPayload();

				// Print user identifier
				String userId = payload.getSubject();
				System.out.println("User ID: " + userId);
				return userId;
			}
			return null;
		}
		return null;
	}
}
