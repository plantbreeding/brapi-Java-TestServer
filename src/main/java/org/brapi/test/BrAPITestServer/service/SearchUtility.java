package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.List;

public class SearchUtility {
	public static List<String> buildSearchParam(String param) {
		List<String> paramList = new ArrayList<>();
		if (param == null) {
			paramList.add("");
		} else {
			paramList.add(param);
		}
		return paramList;
	}

	public static List<String> buildSearchParam(List<String> params) {
		List<String> paramList = new ArrayList<>();
		if (params == null || params.isEmpty()) {
			paramList.add("");
		} else {
			paramList = params;
		}
		return paramList;
	}
}
