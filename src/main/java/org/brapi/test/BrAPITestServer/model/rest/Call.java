package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class Call {
	private String call;
	private List<String> datatypes;
	private List<String> methods;
	
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public List<String> getDatatypes() {
		return datatypes;
	}
	public void setDatatypes(List<String> dataTypes) {
		this.datatypes = dataTypes;
	}
	public List<String> getMethods() {
		return methods;
	}
	public void setMethods(List<String> methods) {
		this.methods = methods;
	}
	
	
}
