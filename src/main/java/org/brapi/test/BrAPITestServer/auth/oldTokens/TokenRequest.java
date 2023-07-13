package org.brapi.test.BrAPITestServer.auth.oldTokens;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenRequest {
	@JsonProperty("username")
	private Optional<String> username = null;

	@JsonProperty("password")
	private Optional<String> password = null;

	public TokenRequest() {
		// TODO Auto-generated constructor stub
	}

	public Optional<String> getUsername() {
		return username;
	}

	public void setUsername(Optional<String> username) {
		this.username = username;
	}

	public Optional<String> getPassword() {
		return password;
	}

	public void setPassword(Optional<String> password) {
		this.password = password;
	}
}
