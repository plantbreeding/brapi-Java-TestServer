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
		calls.add("{ \"call\": \"allelematrices\", 								\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"allelematrices-search\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"allelematrix-search\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"attributes\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"attributes/categories\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"breedingmethods\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"breedingmethods/{breedingMethodDbId}\", 		\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.2\" ] }");
		calls.add("{ \"call\": \"calls\", 										\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.2\" ] }");
		calls.add("{ \"call\": \"commonCropNames\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.2\" ] }");
		calls.add("{ \"call\": \"crops\", 										\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm-search\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}\", 					\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}/attributes\", 		\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}/markerprofiles\", 	\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}/pedigree\", 			\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"germplasm/{germplasmDbId}/progeny\", 			\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"locations\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"locations/{locationDbId}\", 					\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"maps\", 										\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"maps/{mapDbId}\", 								\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"maps/{mapDbId}/positions\", 					\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"maps/{mapDbId}/positions/{linkageGroupName}\", \"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markerprofiles\", 								\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markerprofiles/{markerprofileDbId}\", 			\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markers\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markers-search\", 								\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"markers/{markerDbId}\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"observationLevels\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"observationlevels\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"ontologies\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes-search\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes-search/csv\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes-search/table\", 					\"datatypes\": [ \"json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"phenotypes-search/tsv\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"programs\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"programs-search\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"samples\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"PUT\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"samples-search\", 								\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"samples/{sampleDbId}\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"seasons\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies-search\", 								\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/germplasm\", 				\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/layout\", 					\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"PUT\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observationVariables\", 	\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observations\", 			\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"PUT\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observationunits\", 		\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\", \"PUT\" ], 	\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observationunits/zip\", 	\"datatypes\": [ \"json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/observationvariables\", 	\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studies/{studyDbId}/table\", 					\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studyTypes\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"studytypes\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"traits\", 										\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"traits/{traitDbId}\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"trials\", 										\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"trials/{trialDbId}\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"variables\", 									\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"variables-search\", 							\"datatypes\": [ \"json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"variables/datatypes\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"variables/{observationVariableDbId}\", 		\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"vendor/plates\", 								\"datatypes\": [ \"json\" ], \"methods\": [ \"POST\" ], 					\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"vendor/plates-search\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\", \"POST\" ], 			\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"vendor/plates/{vendorPlateDbId}\", 			\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }");
		calls.add("{ \"call\": \"vendor/specifications\", 						\"datatypes\": [ \"json\" ], \"methods\": [ \"GET\" ], 						\"versions\": [ \"1.0\", \"1.1\", \"1.2\" ] }"); 
	}
    
	public List<Call> getAvailableCalls(String datatype, Metadata metadata) {
		List<Call> calls = buildCalls();
		List<Call> response = filterCalls(calls, datatype, metadata.getPagination().getCurrentPage(), metadata.getPagination().getPageSize());
		metadata.getPagination().setTotalPages((int) Math.ceil((double)calls.size() / (double)metadata.getPagination().getPageSize()));
		metadata.getPagination().setPageSize(response.size());
		metadata.getPagination().setTotalCount(calls.size());

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

	private List<Call> filterCalls(List<Call> calls, String datatype, Integer page, Integer pageSize) {
		List<Call> filteredCalls;
		if(datatype != null && !datatype.equals("")) {
			filteredCalls = calls.stream().filter((call) -> {
				return call.getDatatypes().contains(datatype);
			}).collect(Collectors.toList());
		}else {
			filteredCalls = calls;
		}
		
		int fromIndex = page * pageSize;
		int toIndex = fromIndex + pageSize > filteredCalls.size() ? filteredCalls.size() : fromIndex + pageSize;
		return filteredCalls.subList(fromIndex, toIndex);
	}
}
