package org.brapi.test.BrAPITestServer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.common.Metadata;
import io.swagger.model.common.WSMIMEDataTypes;
import io.swagger.model.core.Service;

@org.springframework.stereotype.Service
public class CallsService {
	
	static List<String> calls;
	
	static {
		calls = new ArrayList<>();
		calls.add("{'call': 'allelematrices', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'allelematrices-search', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.2', '1.3']}");
		calls.add("{'call': 'allelematrix-search', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1']}");
		calls.add("{'call': 'attributes', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'attributes/categories', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'breedingmethods', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.2', '1.3']}");
		calls.add("{'call': 'breedingmethods/{breedingMethodDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.2', '1.3']}");
		calls.add("{'call': 'calls', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'commoncropnames', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.2', '1.3']}");
		calls.add("{'call': 'crops', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1']}");
		calls.add("{'call': 'germplasm', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'germplasm-search', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2']}");
		calls.add("{'call': 'germplasm/{germplasmDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'germplasm/{germplasmDbId}/attributes', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'germplasm/{germplasmDbId}/markerprofiles', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'germplasm/{germplasmDbId}/mcpd', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'germplasm/{germplasmDbId}/pedigree', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'germplasm/{germplasmDbId}/progeny', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.2', '1.3']}");
		calls.add("{'call': 'images', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'images/{imageDbId}', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'images/{imageDbId}/imagecontent', 'methods': ['PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'lists', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'lists/{listDbId}', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'lists/{listDbId}/items', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'locations', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'locations/{locationDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'maps', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'maps/{mapDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'maps/{mapDbId}/positions', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'maps/{mapDbId}/positions/{linkageGroupName}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'markerprofiles', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'markerprofiles/{markerProfileDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': [1.0, 1.1, 1.2, 1.3]}");
		calls.add("{'call': 'markers', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.3']}");
		calls.add("{'call': 'markers-search', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.1', '1.2']}");
		calls.add("{'call': 'markers/{markerDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'methods', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'methods/{methodDbId}', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'observationLevels', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0']}");
		calls.add("{'call': 'observationlevels', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.1', '1.2', '1.3']}");
		calls.add("{'call': 'observationunits', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'ontologies', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'people', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'people/{personDbId}', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'phenotypes', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'phenotypes-search', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2']}");
		calls.add("{'call': 'phenotypes-search/csv', 'methods': ['POST'], 'datatypes': ['text/csv'], 'dataTypes': ['text/csv'], 'versions': ['1.2']}");
		calls.add("{'call': 'phenotypes-search/table', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.2']}");
		calls.add("{'call': 'phenotypes-search/tsv', 'methods': ['POST'], 'datatypes': ['text/tsv'], 'dataTypes': ['text/tsv'], 'versions': ['1.2']}");
		calls.add("{'call': 'programs', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'programs-search', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2']}");
		calls.add("{'call': 'samples', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'samples-search', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.1', '1.2']}");
		calls.add("{'call': 'samples/{sampleDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'scales', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'scales/{scaleDbId}', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/germplasm', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/germplasm/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/images', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/images/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/markers', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/markers/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/observationtables', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/observationtables/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json', 'text/csv', 'text/tsv'], 'dataTypes': ['application/json', 'text/csv', 'text/tsv'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/observationunits', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/observationunits/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': [1.3]}");
		calls.add("{'call': 'search/programs', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/programs/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/samples', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/samples/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/studies', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/studies/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/variables', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'search/variables/{searchResultsDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'seasons', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'studies', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'studies-search', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2']}");
		calls.add("{'call': 'studies/{studyDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'studies/{studyDbId}/germplasm', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'studies/{studyDbId}/layout', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2']}");
		calls.add("{'call': 'studies/{studyDbId}/layouts', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'studies/{studyDbId}/observationVariables', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0']}");
		calls.add("{'call': 'studies/{studyDbId}/observations', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'studies/{studyDbId}/observationunits', 'methods': ['GET', 'POST', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'studies/{studyDbId}/observationunits/zip', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.1', '1.2', '1.3']}");
		calls.add("{'call': 'studies/{studyDbId}/observationvariables', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.1', '1.2', '1.3']}");
		calls.add("{'call': 'studies/{studyDbId}/table', 'methods': ['GET', 'POST'], 'datatypes': ['application/json', 'text/csv', 'text/tsv'], 'dataTypes': ['application/json', 'text/csv', 'text/tsv'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'studyTypes', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0']}");
		calls.add("{'call': 'studytypes', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.1', '1.2', '1.3']}");
		calls.add("{'call': 'traits', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'traits/{traitDbId}', 'methods': ['GET', 'PUT'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'trials', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'trials/{trialDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'variables', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'variables-search', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2']}");
		calls.add("{'call': 'variables/datatypes', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2']}");
		calls.add("{'call': 'variables/{observationVariableDbId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.0', '1.1', '1.2', '1.3']}");
		calls.add("{'call': 'vendor/orders', 'methods': ['GET', 'POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'vendor/orders/{orderId}/plates', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'vendor/orders/{orderId}/results', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'vendor/orders/{orderId}/status', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'vendor/plates', 'methods': ['POST'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.2', '1.3']}");
		calls.add("{'call': 'vendor/plates/{submissionId}', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.3']}");
		calls.add("{'call': 'vendor/specifications', 'methods': ['GET'], 'datatypes': ['application/json'], 'dataTypes': ['application/json'], 'versions': ['1.1', '1.2', '1.3']}");
			}
    
	public List<Service> getAvailableCalls(WSMIMEDataTypes datatype, Metadata metadata) {
		List<Service> calls = buildCalls();
		List<Service> filtered = filterCalls(calls, datatype);
		List<Service> response = paginateCalls(filtered, metadata.getPagination().getCurrentPage(), metadata.getPagination().getPageSize());
		
		metadata.getPagination().setTotalPages((int) Math.ceil((double)filtered.size() / (double)metadata.getPagination().getPageSize()));
		metadata.getPagination().setTotalCount(filtered.size());

		return response;
	}

	private List<Service> buildCalls() {
		List<Service> calls = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		for(String callStr: CallsService.calls) {
			try {
				String callStrClean = callStr.replace("'", "\"");
				calls.add(mapper.readValue(callStrClean, Service.class));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return calls;
	}

	private List<Service> filterCalls(List<Service> calls, WSMIMEDataTypes datatype) {
		List<Service> filteredCalls;
		if(datatype != null) {
			filteredCalls = calls.stream().filter((call) -> {
				return call.getDataTypes().contains(datatype);
			}).collect(Collectors.toList());
		}else {
			filteredCalls = calls;
		}
		return filteredCalls;
	}
	

	private List<Service> paginateCalls(List<Service> calls, Integer page, Integer pageSize) {
		int fromIndex = 0, toIndex = 0;
		if(page * pageSize < calls.size()) {
			fromIndex = page * pageSize;
			toIndex = fromIndex + pageSize > calls.size() ? calls.size() : fromIndex + pageSize;
		}
		return calls.subList(fromIndex, toIndex);
	}
}
