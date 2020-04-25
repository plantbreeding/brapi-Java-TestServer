package org.brapi.test.BrAPITestServer.service.core;

import java.util.List;
import java.util.stream.Collectors;

import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.core.ServerInfo;
import io.swagger.model.core.Service;

@org.springframework.stereotype.Service
public class ServerInfoService {

	static List<Service> services;

	static {
		services = new ServiceBuilder()
				//CORE
				.setBase("serviceinfo").GET().build()
				.setBase("commoncropnames").GET().build()
				.setBase("lists").GET().POST().addPath("{listDbId}").GET().PUT().addPath("items").POST().withSearch()
				.setBase("locations").GET().POST().addPath("{locationDbId}").GET().PUT().withSearch()
				.setBase("people").GET().POST().addPath("{personDbId}").GET().PUT().withSearch()
				.setBase("programs").GET().POST().addPath("{programDbId}").GET().PUT().withSearch()
				.setBase("seasons").GET().POST().addPath("{seasonDbId}").GET().PUT().build()
				.setBase("studies").GET().POST().addPath("{studyDbId}").GET().PUT().withSearch()
				.setBase("studytypes").GET().build()
				.setBase("trials").GET().POST().addPath("{trialDbId}").GET().PUT().withSearch()
				//GERMPLASM
				.setBase("attributes").GET().POST().addPath("{attributeDbId}").GET().PUT().withSearch()
				.setBase("attributevalues").GET().POST().addPath("{attributeValueDbId}").GET().PUT().withSearch()
				.setBase("breedingmethods").GET().addPath("{breedingmethodDbId}").GET().build()
				.setBase("crosses").GET().POST().PUT().build()
				.setBase("plannedcrosses").GET().POST().PUT().build()
				.setBase("crossingprojects").GET().POST().addPath("{crossingprojectDbId}").GET().PUT().build()
				.setBase("germplasm").GET().POST().addPath("{germplasmDbId}").GET().PUT()
				  .setPath("mcpd").GET().setPath("pedigree").GET().setPath("progeny").GET().withSearch()
				//PHENOTYPING
				.setBase("events").GET().build()
				.setBase("images").GET().POST().addPath("{imageDbId}").GET().PUT().addPath("imagecontent").PUT().withSearch()
				.setBase("ontologies").GET().build()
				.setBase("traits").GET().POST().addPath("{traitDbId}").GET().PUT().build()
				.setBase("methods").GET().POST().addPath("{methodDbId}").GET().PUT().build()
				.setBase("scales").GET().POST().addPath("{scaleDbId}").GET().PUT().build()
				.setBase("variables").GET().POST().addPath("{observationVariableDbId}").GET().PUT().withSearch()
				.setBase("observationunits").GET().POST().PUT().addPath("{observationUnitDbId}").GET().PUT().setPath("table").GET().withSearch()
				.setBase("observations").GET().POST().PUT().addPath("{observationDbId}").GET().PUT().setPath("table").GET().withSearch()
				.setBase("observationlevels").GET().build()
				//GENOTYPING
				.setBase("calls").GET().withSearch()
				.setBase("callsets").GET().addPath("{callSetDbId}").GET().addPath("calls").GET().withSearch()
				.setBase("maps").GET().addPath("{mapDbId}").GET().addPath("linkagegroups").GET().build()
				.setBase("markerpositions").GET().withSearch()
				.setBase("references").GET().addPath("{referenceDbId}").GET().addPath("bases").withSearch()
				.setBase("referencesets").GET().addPath("{referenceSetDbId}").GET().withSearch()
				.setBase("samples").GET().POST().addPath("{sampleDbId}").GET().PUT().withSearch()
				.setBase("variants").GET().addPath("{variantDbId}").GET().addPath("calls").GET().withSearch()
				.setBase("variantsets").GET().addPath("extract").POST().setPath("{variantSetDbId}").GET()
				  .addPath("calls").GET().setPath("callsets").GET().setPath("variants").GET().withSearch()
				
				;
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
