package org.brapi.test.BrAPITestServer.service.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.model.WSMIMEDataTypes;
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
		services.add(buildService("commoncropnames", new MethodsEnum[] { MethodsEnum.GET }));
		services.addAll(buildEntityServices("lists", "listDbId"));
		services.add(buildService("lists/{listDbId}/items", new MethodsEnum[] { MethodsEnum.POST }));
		services.addAll(buildEntityServices("locations", "locationDbId"));
		services.addAll(buildEntityServices("people", "personDbId"));
		services.addAll(buildEntityServices("programs", "programDbId"));
		services.add(buildService("seasons", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.POST }));
		services.add(buildService("seasons/{seasonDbId}", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.PUT }));
		services.addAll(buildEntityServices("studies", "studyDbId"));
		services.add(buildService("studytypes", new MethodsEnum[] { MethodsEnum.GET }));
		services.addAll(buildEntityServices("trials", "trialDbId"));
		services.addAll(buildEntityServices("attributes", "attributeDbId"));
		services.addAll(buildEntityServices("attributevalues", "attributeValueDbId"));
		services.add(buildService("breedingmethods", new MethodsEnum[] { MethodsEnum.GET }));
		services.add(buildService("breedingmethods/{breedingmethodDbId}", new MethodsEnum[] { MethodsEnum.GET }));
		services.add(buildService("crosses", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.POST, MethodsEnum.PUT }));
		services.add(buildService("crossingprojects", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.POST }));
		services.add(buildService("crossingprojects/{crossingprojectDbId}", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.PUT }));
		services.addAll(buildEntityServices("germplasm", "germplasmDbId"));
		services.add(buildService("germplasm/{germplasmDbId}/mcpd", new MethodsEnum[] { MethodsEnum.GET}));
		services.add(buildService("germplasm/{germplasmDbId}/pedigree", new MethodsEnum[] { MethodsEnum.GET}));
		services.add(buildService("germplasm/{germplasmDbId}/progeny", new MethodsEnum[] { MethodsEnum.GET}));
		services.add(buildService("events", new MethodsEnum[] { MethodsEnum.GET}));
		services.addAll(buildEntityServices("images", "imageDbId"));
		services.add(buildService("images/{imageDbId}/imagecontent", new MethodsEnum[] { MethodsEnum.PUT }));
		services.add(buildService("ontologies", new MethodsEnum[] { MethodsEnum.GET}));
	}

	public static List<Service> buildEntityServices(String entityName, String dbidName) {
		List<Service> entityServices = new ArrayList<>();
		entityServices.add(buildService(entityName, new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.POST }));
		entityServices.add(buildService(entityName + "/{" + dbidName + "}", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.PUT }));
		entityServices.add(buildService("search/" + entityName, new MethodsEnum[] { MethodsEnum.POST }));
		
		return entityServices;
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
