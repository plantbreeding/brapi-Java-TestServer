package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.List;

import org.brapi.test.BrAPITestServer.model.Call;
import org.springframework.stereotype.Service;

@Service
public class CallsService {
	public List<Call> getAvailableCalls() {
		List<Call> calls = new ArrayList<Call>();
		calls.add(mockCallsCall());
		return calls;
	}
	
	private Call mockCallsCall() {
		Call callsCall = new Call();
		callsCall.setCall("calls");
		callsCall.setDataTypes(new ArrayList<String>());
		callsCall.getDataTypes().add("json");
		callsCall.setMethods(new ArrayList<String>());
		callsCall.getMethods().add("GET");
		return callsCall;
	}
}
