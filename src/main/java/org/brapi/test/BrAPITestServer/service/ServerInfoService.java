package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.model.common.WSMIMEDataTypes;
import io.swagger.model.core.ServerInfo;
import io.swagger.model.core.Service;
import io.swagger.model.core.Service.MethodsEnum;
import io.swagger.model.core.Service.VersionsEnum;

@org.springframework.stereotype.Service
public class ServerInfoService {

	static List<Service> services;

	static {
		services = new ArrayList<>();
		services.add(buildService("serviceinfo", new MethodsEnum[] { MethodsEnum.GET }));
	}

	public static Service buildService(String servicePath, MethodsEnum[] methods) {
		Service service = new Service();
		service.addDataTypesItem(WSMIMEDataTypes.APPLICATION_JSON);
		service.setMethods(Arrays.asList(methods));
		service.addVersionsItem(VersionsEnum._0);
		service.setService(servicePath);
		return service;
	}

	private List<Service> filterCalls(List<Service> calls, WSMIMEDataTypes dataType) {
		List<Service> filteredCalls;
		if (dataType != null) {
			filteredCalls = calls.stream().filter((call) -> {
				return call.getDataTypes().contains(dataType);
			}).collect(Collectors.toList());
		} else {
			filteredCalls = calls;
		}
		return filteredCalls;
	}

	public ServerInfo getServerInfo(WSMIMEDataTypes dataType) {
		ServerInfo info = new ServerInfo().contactEmail("brapicoordinatorselby@gmail.com")
				.documentationURL("https://brapi.org/specification").location("Ithaca, NY, USA")
				.organizationName("BrAPI Community").organizationURL("https://brapi.org")
				.serverName("BrAPI Community Test Server").serverDescription("BrAPI Community Test Server");

		info.setCalls(filterCalls(ServerInfoService.services, dataType));
		return info;
	}
}
