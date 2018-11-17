package org.brapi.test.BrAPITestServer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Call;
import io.swagger.model.Metadata;

@Service
public class CallsService {
	
	static List<String> calls;
	
	static {
		calls = new ArrayList<>();
		calls.add("{ \"call\": \"allelematrices\", 								\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"allelematrices-search\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"allelematrix-search\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"attributes\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"attributes/categories\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"breedingmethods\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"breedingmethods/{breedingMethodDbId}\", 		\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.2\" ] }");
		calls.add("{ \"call\": \"calls\", 										\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.2\" ] }");
		calls.add("{ \"call\": \"commonCropNames\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.2\" ] }");
		calls.add("{ \"call\": \"crops\", 										\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm-search\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}\", 					\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}/attributes\", 		\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}/markerprofiles\", 	\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}/pedigree\", 			\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}/progeny\", 			\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"locations\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"locations/{locationDbId}\", 					\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"maps\", 										\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"maps/{mapDbId}\", 								\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"maps/{mapDbId}/positions\", 					\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"maps/{mapDbId}/positions/{linkageGroupName}\", \"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markerprofiles\", 								\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markerprofiles/{markerprofileDbId}\", 			\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markers\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markers-search\", 								\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markers/{markerDbId}\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"observationLevels\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"observationlevels\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"ontologies\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes-search\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes-search/csv\", 						\"datatypes\": [ \"text/csv\" ], 		 \"dataTypes\": [ \"text/csv\" ],  		  \"methods\": [ \"POST\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes-search/table\", 					\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes-search/tsv\", 						\"datatypes\": [ \"text/tsv\" ], 		 \"dataTypes\": [ \"text/tsv\" ],  		  \"methods\": [ \"POST\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"programs\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"programs-search\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"samples\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"PUT\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"samples-search\", 								\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"samples/{sampleDbId}\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"seasons\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies-search\", 								\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/germplasm\", 				\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/layout\", 					\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"PUT\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observationVariables\", 	\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observations\", 			\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"PUT\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observationunits\", 		\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\", \"PUT\" ], 	\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observationunits/zip\", 	\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observationvariables\", 	\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/table\", 					\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studyTypes\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studytypes\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"traits\", 										\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"traits/{traitDbId}\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"trials\", 										\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"trials/{trialDbId}\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"variables\", 									\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"variables-search\", 							\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"variables/datatypes\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"variables/{observationVariableDbId}\", 		\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"vendor/plates\", 								\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"vendor/plates-search\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"vendor/plates/{vendorPlateDbId}\", 			\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"vendor/specifications\", 						\"datatypes\": [ \"application/json\" ], \"dataTypes\": [ \"application/json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }"); 
	}
    
	public List<Call> getAvailableCalls(String datatype, Metadata metadata) {
		List<Call> calls = buildCalls();
		List<Call> filtered = filterCalls(calls, datatype);
		List<Call> response = paginateCalls(filtered, metadata.getPagination().getCurrentPage(), metadata.getPagination().getPageSize());
		
		metadata.getPagination().setTotalPages((int) Math.ceil((double)filtered.size() / (double)metadata.getPagination().getPageSize()));
		metadata.getPagination().setTotalCount(filtered.size());

		return response;
	}

	private List<Call> buildCalls() {
		List<Call> calls = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		for(String callStr: CallsService.calls) {
			try {
				calls.add(mapper.readValue(callStr, Call.class));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return calls;
	}

	private List<Call> filterCalls(List<Call> calls, String datatype) {
		List<Call> filteredCalls;
		if(datatype != null && !datatype.equals("")) {
			filteredCalls = calls.stream().filter((call) -> {
				return call.getDatatypes().contains(datatype);
			}).collect(Collectors.toList());
		}else {
			filteredCalls = calls;
		}
		return filteredCalls;
	}
	

	private List<Call> paginateCalls(List<Call> calls, Integer page, Integer pageSize) {
		int fromIndex = 0, toIndex = 0;
		if(page * pageSize < calls.size()) {
			fromIndex = page * pageSize;
			toIndex = fromIndex + pageSize > calls.size() ? calls.size() : fromIndex + pageSize;
		}
		return calls.subList(fromIndex, toIndex);
	}
}
