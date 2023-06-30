package org.brapi.test.BrAPITestServer.auth;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthDetails {

	private String userId;
	private Date expirationTimestamp;
	private List<String> roles;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getExpirationTimestamp() {
		return expirationTimestamp;
	}

	public void setExpirationTimestamp(Date expirationTimestamp) {
		this.expirationTimestamp = expirationTimestamp;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void setExpirationTimestamp(long millis) {
		Date date = new Date();
		date.setTime(millis);
		setExpirationTimestamp(date);
	}

	public void addRole(String role) {
		if(roles == null) {
			roles = new ArrayList<>();
		}
		roles.add(role);
	}

}