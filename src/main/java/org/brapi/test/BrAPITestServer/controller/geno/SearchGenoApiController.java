package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.geno.CallSetsListResponse;
import io.swagger.model.geno.CallSetsSearchRequest;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.CallsSearchRequest;
import io.swagger.model.geno.MarkerPositionListResponse;
import io.swagger.model.geno.MarkerPositionSearchRequest;
import io.swagger.model.geno.ReferenceSetsListResponse;
import io.swagger.model.geno.ReferenceSetsSearchRequest;
import io.swagger.model.geno.ReferencesListResponse;
import io.swagger.model.geno.ReferencesSearchRequest;
import io.swagger.model.geno.SampleListResponse;
import io.swagger.model.geno.SampleSearchRequest;
import io.swagger.model.geno.VariantSetsListResponse;
import io.swagger.model.geno.VariantSetsSearchRequest;
import io.swagger.model.geno.VariantsListResponse;
import io.swagger.model.geno.VariantsSearchRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.geno.SearchGenoApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class SearchGenoApiController implements SearchGenoApi {

	private static final Logger log = LoggerFactory.getLogger(SearchGenoApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public SearchGenoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<CallsListResponse> searchCallsPost(
			@ApiParam(value = "Study Search request") @Valid @RequestBody CallsSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CallsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"genotype_likelihood\" : [ 1 ],\n      \"phaseSet\" : \"6410afc5\",\n      \"callSetName\" : \"Sample_123_DNA_Run_456\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"callSetDbId\" : \"16466f55\",\n      \"variantDbId\" : \"538c8ecf\",\n      \"variantName\" : \"Marker A\",\n      \"genotype\" : {\n        \"values\" : [ \"AA\" ]\n      }\n    }, {\n      \"genotype_likelihood\" : [ 1 ],\n      \"phaseSet\" : \"6410afc5\",\n      \"callSetName\" : \"Sample_123_DNA_Run_456\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"callSetDbId\" : \"16466f55\",\n      \"variantDbId\" : \"538c8ecf\",\n      \"variantName\" : \"Marker A\",\n      \"genotype\" : {\n        \"values\" : [ \"AA\" ]\n      }\n    } ],\n    \"unknownString\" : \"-\",\n    \"expandHomozygotes\" : true,\n    \"sepPhased\" : \"~\",\n    \"sepUnphased\" : \"|\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CallsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CallsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CallsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<CallsListResponse> searchCallsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  Tokenized pages are for large data sets which can not be efficiently broken into indexed pages. Use the nextPageToken and prevPageToken from a prior response to construct a query and move to the next or previous page respectively. ") @Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CallsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"genotype_likelihood\" : [ 1 ],\n      \"phaseSet\" : \"6410afc5\",\n      \"callSetName\" : \"Sample_123_DNA_Run_456\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"callSetDbId\" : \"16466f55\",\n      \"variantDbId\" : \"538c8ecf\",\n      \"variantName\" : \"Marker A\",\n      \"genotype\" : {\n        \"values\" : [ \"AA\" ]\n      }\n    }, {\n      \"genotype_likelihood\" : [ 1 ],\n      \"phaseSet\" : \"6410afc5\",\n      \"callSetName\" : \"Sample_123_DNA_Run_456\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"callSetDbId\" : \"16466f55\",\n      \"variantDbId\" : \"538c8ecf\",\n      \"variantName\" : \"Marker A\",\n      \"genotype\" : {\n        \"values\" : [ \"AA\" ]\n      }\n    } ],\n    \"unknownString\" : \"-\",\n    \"expandHomozygotes\" : true,\n    \"sepPhased\" : \"~\",\n    \"sepUnphased\" : \"|\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CallsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CallsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CallsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<CallSetsListResponse> searchCallsetsPost(
			@ApiParam(value = "Study Search request") @Valid @RequestBody CallSetsSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CallSetsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"sampleDbId\" : \"5e50e11d\",\n      \"callSetName\" : \"Sample_123_DNA_Run_456\",\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"callSetDbId\" : \"eb2bfd3d\",\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"variantSetIds\" : [ \"cfd3d60f\", \"a4e8bfe9\" ],\n      \"studyDbId\" : \"708149c1\"\n    }, {\n      \"sampleDbId\" : \"5e50e11d\",\n      \"callSetName\" : \"Sample_123_DNA_Run_456\",\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"callSetDbId\" : \"eb2bfd3d\",\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"variantSetIds\" : [ \"cfd3d60f\", \"a4e8bfe9\" ],\n      \"studyDbId\" : \"708149c1\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CallSetsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CallSetsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CallSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<CallSetsListResponse> searchCallsetsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CallSetsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"sampleDbId\" : \"5e50e11d\",\n      \"callSetName\" : \"Sample_123_DNA_Run_456\",\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"callSetDbId\" : \"eb2bfd3d\",\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"variantSetIds\" : [ \"cfd3d60f\", \"a4e8bfe9\" ],\n      \"studyDbId\" : \"708149c1\"\n    }, {\n      \"sampleDbId\" : \"5e50e11d\",\n      \"callSetName\" : \"Sample_123_DNA_Run_456\",\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"callSetDbId\" : \"eb2bfd3d\",\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"variantSetIds\" : [ \"cfd3d60f\", \"a4e8bfe9\" ],\n      \"studyDbId\" : \"708149c1\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CallSetsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CallSetsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CallSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<MarkerPositionListResponse> searchMarkerpositionsPost(
			@ApiParam(value = "") @Valid @RequestBody MarkerPositionSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<MarkerPositionListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"mapDbId\" : \"3d52bdf3\",\n      \"linkageGroupName\" : \"Chromosome 3\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantDbId\" : \"a1eb250a\",\n      \"mapName\" : \"Genome Map 1\",\n      \"position\" : 2390,\n      \"variantName\" : \"Marker_2390\"\n    }, {\n      \"mapDbId\" : \"3d52bdf3\",\n      \"linkageGroupName\" : \"Chromosome 3\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantDbId\" : \"a1eb250a\",\n      \"mapName\" : \"Genome Map 1\",\n      \"position\" : 2390,\n      \"variantName\" : \"Marker_2390\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						MarkerPositionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<MarkerPositionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MarkerPositionListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<MarkerPositionListResponse> searchMarkerpositionsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<MarkerPositionListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"mapDbId\" : \"3d52bdf3\",\n      \"linkageGroupName\" : \"Chromosome 3\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantDbId\" : \"a1eb250a\",\n      \"mapName\" : \"Genome Map 1\",\n      \"position\" : 2390,\n      \"variantName\" : \"Marker_2390\"\n    }, {\n      \"mapDbId\" : \"3d52bdf3\",\n      \"linkageGroupName\" : \"Chromosome 3\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantDbId\" : \"a1eb250a\",\n      \"mapName\" : \"Genome Map 1\",\n      \"position\" : 2390,\n      \"variantName\" : \"Marker_2390\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						MarkerPositionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<MarkerPositionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MarkerPositionListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ReferencesListResponse> searchReferencesPost(
			@ApiParam(value = "References Search request") @Valid @RequestBody ReferencesSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ReferencesListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"referenceDbId\" : \"referenceDbId\",\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"length\" : 0,\n      \"sourceDivergence\" : 6.0274563,\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ],\n      \"referenceName\" : \"referenceName\"\n    }, {\n      \"referenceDbId\" : \"referenceDbId\",\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"length\" : 0,\n      \"sourceDivergence\" : 6.0274563,\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ],\n      \"referenceName\" : \"referenceName\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ReferencesListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ReferencesListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ReferencesListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ReferencesListResponse> searchReferencesSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ReferencesListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"referenceDbId\" : \"referenceDbId\",\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"length\" : 0,\n      \"sourceDivergence\" : 6.0274563,\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ],\n      \"referenceName\" : \"referenceName\"\n    }, {\n      \"referenceDbId\" : \"referenceDbId\",\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"length\" : 0,\n      \"sourceDivergence\" : 6.0274563,\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ],\n      \"referenceName\" : \"referenceName\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ReferencesListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ReferencesListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ReferencesListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ReferenceSetsListResponse> searchReferencesetsPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody ReferenceSetsSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ReferenceSetsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"assemblyPUI\" : \"assemblyPUI\",\n      \"description\" : \"description\",\n      \"referenceSetDbId\" : \"referenceSetDbId\",\n      \"referenceSetName\" : \"referenceSetName\",\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ]\n    }, {\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"assemblyPUI\" : \"assemblyPUI\",\n      \"description\" : \"description\",\n      \"referenceSetDbId\" : \"referenceSetDbId\",\n      \"referenceSetName\" : \"referenceSetName\",\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ]\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ReferenceSetsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ReferenceSetsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ReferenceSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ReferenceSetsListResponse> searchReferencesetsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ReferenceSetsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"assemblyPUI\" : \"assemblyPUI\",\n      \"description\" : \"description\",\n      \"referenceSetDbId\" : \"referenceSetDbId\",\n      \"referenceSetName\" : \"referenceSetName\",\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ]\n    }, {\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"assemblyPUI\" : \"assemblyPUI\",\n      \"description\" : \"description\",\n      \"referenceSetDbId\" : \"referenceSetDbId\",\n      \"referenceSetName\" : \"referenceSetName\",\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ]\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ReferenceSetsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ReferenceSetsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ReferenceSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SampleListResponse> searchSamplesPost(
			@ApiParam(value = "") @Valid @RequestBody SampleSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SampleListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SampleListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SampleListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SampleListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SampleListResponse> searchSamplesSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SampleListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SampleListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SampleListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SampleListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VariantsListResponse> searchVariantsPost(
			@ApiParam(value = "Study Search request") @Valid @RequestBody VariantsSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VariantsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"referenceBases\" : \"TAGGATTGAGCTCTATAT\",\n      \"start\" : 500,\n      \"cipos\" : [ -12000, 1000 ],\n      \"variantType\" : \"DUP\",\n      \"ciend\" : [ -1000, 0 ],\n      \"alternate_bases\" : [ \"TAGGATTGAGCTCTATAT\" ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantSetDbId\" : [ \"c8ae400b\", \"ef2c204b\" ],\n      \"filtersFailed\" : [ \"d629a669\", \"3f14f578\" ],\n      \"svlen\" : 1500,\n      \"variantDbId\" : \"628e89c5\",\n      \"variantNames\" : [ \"RefSNP_ID_1\", \"06ea312e\" ],\n      \"end\" : 518,\n      \"filtersApplied\" : true,\n      \"filtersPassed\" : true,\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"referenceName\" : \"chr_20\"\n    }, {\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"referenceBases\" : \"TAGGATTGAGCTCTATAT\",\n      \"start\" : 500,\n      \"cipos\" : [ -12000, 1000 ],\n      \"variantType\" : \"DUP\",\n      \"ciend\" : [ -1000, 0 ],\n      \"alternate_bases\" : [ \"TAGGATTGAGCTCTATAT\" ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantSetDbId\" : [ \"c8ae400b\", \"ef2c204b\" ],\n      \"filtersFailed\" : [ \"d629a669\", \"3f14f578\" ],\n      \"svlen\" : 1500,\n      \"variantDbId\" : \"628e89c5\",\n      \"variantNames\" : [ \"RefSNP_ID_1\", \"06ea312e\" ],\n      \"end\" : 518,\n      \"filtersApplied\" : true,\n      \"filtersPassed\" : true,\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"referenceName\" : \"chr_20\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VariantsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VariantsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VariantsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VariantsListResponse> searchVariantsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  Tokenized pages are for large data sets which can not be efficiently broken into indexed pages. Use the nextPageToken and prevPageToken from a prior response to construct a query and move to the next or previous page respectively. ") @Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VariantsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"referenceBases\" : \"TAGGATTGAGCTCTATAT\",\n      \"start\" : 500,\n      \"cipos\" : [ -12000, 1000 ],\n      \"variantType\" : \"DUP\",\n      \"ciend\" : [ -1000, 0 ],\n      \"alternate_bases\" : [ \"TAGGATTGAGCTCTATAT\" ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantSetDbId\" : [ \"c8ae400b\", \"ef2c204b\" ],\n      \"filtersFailed\" : [ \"d629a669\", \"3f14f578\" ],\n      \"svlen\" : 1500,\n      \"variantDbId\" : \"628e89c5\",\n      \"variantNames\" : [ \"RefSNP_ID_1\", \"06ea312e\" ],\n      \"end\" : 518,\n      \"filtersApplied\" : true,\n      \"filtersPassed\" : true,\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"referenceName\" : \"chr_20\"\n    }, {\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"referenceBases\" : \"TAGGATTGAGCTCTATAT\",\n      \"start\" : 500,\n      \"cipos\" : [ -12000, 1000 ],\n      \"variantType\" : \"DUP\",\n      \"ciend\" : [ -1000, 0 ],\n      \"alternate_bases\" : [ \"TAGGATTGAGCTCTATAT\" ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantSetDbId\" : [ \"c8ae400b\", \"ef2c204b\" ],\n      \"filtersFailed\" : [ \"d629a669\", \"3f14f578\" ],\n      \"svlen\" : 1500,\n      \"variantDbId\" : \"628e89c5\",\n      \"variantNames\" : [ \"RefSNP_ID_1\", \"06ea312e\" ],\n      \"end\" : 518,\n      \"filtersApplied\" : true,\n      \"filtersPassed\" : true,\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"referenceName\" : \"chr_20\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VariantsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VariantsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VariantsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VariantSetsListResponse> searchVariantsetsPost(
			@ApiParam(value = "Study Search request") @Valid @RequestBody VariantSetsSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VariantSetsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"availableFormats\" : [ {\n        \"dataFormat\" : \"VCF\",\n        \"fileFormat\" : \"application/excel\",\n        \"fileURL\" : \"https://brapi.org/example/VCF_1.xlsx\"\n      }, {\n        \"dataFormat\" : \"VCF\",\n        \"fileFormat\" : \"text/csv\",\n        \"fileURL\" : \"https://brapi.org/example/VCF_2.csv\"\n      } ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantSetDbId\" : \"87a6ac1e\",\n      \"callSetCount\" : 341,\n      \"referenceSetDbId\" : \"57eae639\",\n      \"variantSetName\" : \"Maize QC DataSet 002334\",\n      \"analysis\" : [ {\n        \"software\" : [ \"https://github.com/genotyping/QC\" ],\n        \"analysisDbId\" : \"6191a6bd\",\n        \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n        \"type\" : \"QC\",\n        \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"analysisName\" : \"Standard QC\"\n      }, {\n        \"software\" : [ \"https://github.com/genotyping/QC\" ],\n        \"analysisDbId\" : \"6191a6bd\",\n        \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n        \"type\" : \"QC\",\n        \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"analysisName\" : \"Standard QC\"\n      } ],\n      \"studyDbId\" : \"2fc3b034\",\n      \"variantCount\" : 250\n    }, {\n      \"availableFormats\" : [ {\n        \"dataFormat\" : \"VCF\",\n        \"fileFormat\" : \"application/excel\",\n        \"fileURL\" : \"https://brapi.org/example/VCF_1.xlsx\"\n      }, {\n        \"dataFormat\" : \"VCF\",\n        \"fileFormat\" : \"text/csv\",\n        \"fileURL\" : \"https://brapi.org/example/VCF_2.csv\"\n      } ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantSetDbId\" : \"87a6ac1e\",\n      \"callSetCount\" : 341,\n      \"referenceSetDbId\" : \"57eae639\",\n      \"variantSetName\" : \"Maize QC DataSet 002334\",\n      \"analysis\" : [ {\n        \"software\" : [ \"https://github.com/genotyping/QC\" ],\n        \"analysisDbId\" : \"6191a6bd\",\n        \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n        \"type\" : \"QC\",\n        \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"analysisName\" : \"Standard QC\"\n      }, {\n        \"software\" : [ \"https://github.com/genotyping/QC\" ],\n        \"analysisDbId\" : \"6191a6bd\",\n        \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n        \"type\" : \"QC\",\n        \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"analysisName\" : \"Standard QC\"\n      } ],\n      \"studyDbId\" : \"2fc3b034\",\n      \"variantCount\" : 250\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VariantSetsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VariantSetsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VariantSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VariantSetsListResponse> searchVariantsetsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VariantSetsListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"availableFormats\" : [ {\n        \"dataFormat\" : \"VCF\",\n        \"fileFormat\" : \"application/excel\",\n        \"fileURL\" : \"https://brapi.org/example/VCF_1.xlsx\"\n      }, {\n        \"dataFormat\" : \"VCF\",\n        \"fileFormat\" : \"text/csv\",\n        \"fileURL\" : \"https://brapi.org/example/VCF_2.csv\"\n      } ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantSetDbId\" : \"87a6ac1e\",\n      \"callSetCount\" : 341,\n      \"referenceSetDbId\" : \"57eae639\",\n      \"variantSetName\" : \"Maize QC DataSet 002334\",\n      \"analysis\" : [ {\n        \"software\" : [ \"https://github.com/genotyping/QC\" ],\n        \"analysisDbId\" : \"6191a6bd\",\n        \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n        \"type\" : \"QC\",\n        \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"analysisName\" : \"Standard QC\"\n      }, {\n        \"software\" : [ \"https://github.com/genotyping/QC\" ],\n        \"analysisDbId\" : \"6191a6bd\",\n        \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n        \"type\" : \"QC\",\n        \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"analysisName\" : \"Standard QC\"\n      } ],\n      \"studyDbId\" : \"2fc3b034\",\n      \"variantCount\" : 250\n    }, {\n      \"availableFormats\" : [ {\n        \"dataFormat\" : \"VCF\",\n        \"fileFormat\" : \"application/excel\",\n        \"fileURL\" : \"https://brapi.org/example/VCF_1.xlsx\"\n      }, {\n        \"dataFormat\" : \"VCF\",\n        \"fileFormat\" : \"text/csv\",\n        \"fileURL\" : \"https://brapi.org/example/VCF_2.csv\"\n      } ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantSetDbId\" : \"87a6ac1e\",\n      \"callSetCount\" : 341,\n      \"referenceSetDbId\" : \"57eae639\",\n      \"variantSetName\" : \"Maize QC DataSet 002334\",\n      \"analysis\" : [ {\n        \"software\" : [ \"https://github.com/genotyping/QC\" ],\n        \"analysisDbId\" : \"6191a6bd\",\n        \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n        \"type\" : \"QC\",\n        \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"analysisName\" : \"Standard QC\"\n      }, {\n        \"software\" : [ \"https://github.com/genotyping/QC\" ],\n        \"analysisDbId\" : \"6191a6bd\",\n        \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n        \"type\" : \"QC\",\n        \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"analysisName\" : \"Standard QC\"\n      } ],\n      \"studyDbId\" : \"2fc3b034\",\n      \"variantCount\" : 250\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VariantSetsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VariantSetsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VariantSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
