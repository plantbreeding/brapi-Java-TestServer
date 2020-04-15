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
		services.addAll(buildEntityServicesWithSearch("lists", "listDbId"));
		services.add(buildService("lists/{listDbId}/items", new MethodsEnum[] { MethodsEnum.POST }));
		services.addAll(buildEntityServicesWithSearch("locations", "locationDbId"));
		services.addAll(buildEntityServicesWithSearch("people", "personDbId"));
		services.addAll(buildEntityServicesWithSearch("programs", "programDbId"));
		services.addAll(buildEntityServices("seasons", "seasonDbId"));
		services.addAll(buildEntityServicesWithSearch("studies", "studyDbId"));
		services.add(buildService("studytypes", new MethodsEnum[] { MethodsEnum.GET }));
		services.addAll(buildEntityServicesWithSearch("trials", "trialDbId"));
		services.addAll(buildEntityServicesWithSearch("attributes", "attributeDbId"));
		services.addAll(buildEntityServicesWithSearch("attributevalues", "attributeValueDbId"));
		services.add(buildService("breedingmethods", new MethodsEnum[] { MethodsEnum.GET }));
		services.add(buildService("breedingmethods/{breedingmethodDbId}", new MethodsEnum[] { MethodsEnum.GET }));
		services.add(buildService("crosses", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.POST, MethodsEnum.PUT }));
		services.add(buildService("plannedcrosses", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.POST, MethodsEnum.PUT }));
		services.addAll(buildEntityServices("crossingprojects", "crossingprojectDbId"));
		services.addAll(buildEntityServicesWithSearch("germplasm", "germplasmDbId"));
		services.add(buildService("germplasm/{germplasmDbId}/mcpd", new MethodsEnum[] { MethodsEnum.GET}));
		services.add(buildService("germplasm/{germplasmDbId}/pedigree", new MethodsEnum[] { MethodsEnum.GET}));
		services.add(buildService("germplasm/{germplasmDbId}/progeny", new MethodsEnum[] { MethodsEnum.GET}));
		services.add(buildService("events", new MethodsEnum[] { MethodsEnum.GET}));
		services.addAll(buildEntityServicesWithSearch("images", "imageDbId"));
		services.add(buildService("images/{imageDbId}/imagecontent", new MethodsEnum[] { MethodsEnum.PUT }));
		services.add(buildService("ontologies", new MethodsEnum[] { MethodsEnum.GET}));
		services.addAll(buildEntityServices("traits", "traitDbId"));
		services.addAll(buildEntityServices("methods", "methodDbId"));
		services.addAll(buildEntityServices("scales", "scaleDbId"));
		services.addAll(buildEntityServicesWithSearch("variables", "observationVariableDbId"));
	}

	public static List<Service> buildEntityServicesWithSearch(String entityName, String dbidName) {
		List<Service> entityServices = new ArrayList<>();
		entityServices.add(buildService(entityName, new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.POST }));
		entityServices.add(buildService(entityName + "/{" + dbidName + "}", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.PUT }));
		entityServices.add(buildService("search/" + entityName, new MethodsEnum[] { MethodsEnum.POST }));
		
		return entityServices;
	}

	public static List<Service> buildEntityServices(String entityName, String dbidName) {
		List<Service> entityServices = new ArrayList<>();
		entityServices.add(buildService(entityName, new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.POST }));
		entityServices.add(buildService(entityName + "/{" + dbidName + "}", new MethodsEnum[] { MethodsEnum.GET, MethodsEnum.PUT }));
		
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
