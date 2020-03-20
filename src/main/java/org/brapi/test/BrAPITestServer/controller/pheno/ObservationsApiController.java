package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.pheno.ObservationListResponse;
import io.swagger.model.pheno.ObservationNewRequest;
import io.swagger.model.pheno.ObservationSingleResponse;
import io.swagger.model.pheno.ObservationTableResponse;
import org.threeten.bp.OffsetDateTime;
import io.swagger.model.common.WSMIMEDataTypes;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.pheno.ObservationsApi;

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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class ObservationsApiController implements ObservationsApi {

	private static final Logger log = LoggerFactory.getLogger(ObservationsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public ObservationsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<ObservationListResponse> observationsGet(
			@ApiParam(value = "The unique ID of an Observation Unit") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@ApiParam(value = "The unique ID of a germplasm (accession) to filter on") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@ApiParam(value = "The unique ID of an observation variable") @Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@ApiParam(value = "The unique ID of a studies to filter on") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@ApiParam(value = "The unique ID of a location where these observations were collected") @Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@ApiParam(value = "The unique ID of a trial to filter on") @Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@ApiParam(value = "The unique ID of a program to filter on") @Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@ApiParam(value = "The year or Phenotyping campaign of a multi-annual study (trees, grape, ...)") @Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@ApiParam(value = "The Observation Unit Level. Returns only the observation unit of the specified Level. References ObservationUnit->observationUnitPosition->observationLevel->levelName") @Valid @RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@ApiParam(value = "The Observation Unit Level Order Number. Returns only the observation unit of the specified Level. References ObservationUnit->observationUnitPosition->observationLevel->levelOrder") @Valid @RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@ApiParam(value = "The Observation Unit Level Code. This parameter should be used together with `observationUnitLevelName` or `observationUnitLevelOrder`. References ObservationUnit->observationUnitPosition->observationLevel->levelCode") @Valid @RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@ApiParam(value = "Timestamp range start") @Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) OffsetDateTime observationTimeStampRangeStart,
			@ApiParam(value = "Timestamp range end") @Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) OffsetDateTime observationTimeStampRangeEnd,
			@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationSingleResponse> observationsObservationDbIdGet(
			@ApiParam(value = "The unique ID of an observation", required = true) @PathVariable("observationDbId") String observationDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationSingleResponse> observationsObservationDbIdPut(
			@ApiParam(value = "The unique ID of an observation", required = true) @PathVariable("observationDbId") String observationDbId,
			@ApiParam(value = "") @Valid @RequestBody ObservationNewRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationListResponse> observationsPost(
			@ApiParam(value = "") @Valid @RequestBody List<ObservationNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationListResponse> observationsPut(
			@ApiParam(value = "") @Valid @RequestBody Map<String, ObservationNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationTableResponse> observationsTableGet(
			@ApiParam(value = "The requested content type which should be returned by the server", required = true) @RequestHeader(value = "Accept", required = true) WSMIMEDataTypes accept,
			@ApiParam(value = "The unique ID of an Observation Unit") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@ApiParam(value = "The unique ID of a germplasm (accession) to filter on") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@ApiParam(value = "The unique ID of an observation variable") @Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@ApiParam(value = "The unique ID of a studies to filter on") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@ApiParam(value = "The unique ID of a location where these observations were collected") @Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@ApiParam(value = "The unique ID of a trial to filter on") @Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@ApiParam(value = "The unique ID of a program to filter on") @Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@ApiParam(value = "The year or Phenotyping campaign of a multi-annual study (trees, grape, ...)") @Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@ApiParam(value = "The type of the observationUnit. Returns only the observation unit of the specified type; the parent levels ID can be accessed through observationUnitStructure.") @Valid @RequestParam(value = "observationLevel", required = false) String observationLevel,
			@ApiParam(value = "Permanent unique identifier which references the search results") @Valid @RequestParam(value = "searchResultsDbId", required = false) String searchResultsDbId,
			@ApiParam(value = "Timestamp range start") @Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) OffsetDateTime observationTimeStampRangeStart,
			@ApiParam(value = "Timestamp range end") @Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) OffsetDateTime observationTimeStampRangeEnd,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) {

		if (accept != null) {
			try {
				return new ResponseEntity<ObservationTableResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ [ \"2019-09-10T18:13:27.223Z\", \"f3a8a3db\", \"Plant Alpha\", \"0fe3e48b\", \"2017 Plant Study\", \"06307ec0\", \"A0043001\", \"76.50106681\", \"42.44409301\", \"2017\", \"Field_1\", \"Plot_11\", \"SubPlot_111\", \"Plant_1111\", \"Pot_1111\", \"Block_11\", \"Entry_11\", \"Rep_11\", \"25.3\", \"\", \"\", \"\" ], [ \"2019-09-10T18:14:27.223Z\", \"f3a8a3db\", \"Plant Alpha\", \"0fe3e48b\", \"2017 Plant Study\", \"06307ec0\", \"A0043001\", \"76.50106681\", \"42.44409301\", \"2017\", \"Field_1\", \"Plot_11\", \"SubPlot_111\", \"Plant_1111\", \"Pot_1111\", \"Block_11\", \"Entry_11\", \"Rep_11\", \"\", \"3\", \"\", \"\" ], [ \"2019-09-10T18:15:54.868Z\", \"05d1b011\", \"Plant Beta\", \"0fe3e48b\", \"2017 Plant Study\", \"59d435cd\", \"A0043002\", \"76.50106683\", \"42.44409301\", \"2017\", \"Field_1\", \"Plot_11\", \"SubPlot_112\", \"Plant_1122\", \"Pot_1122\", \"Block_11\", \"Entry_11\", \"Rep_12\", \"27.9\", \"\", \"\", \"\" ], [ \"2019-09-10T18:16:54.868Z\", \"05d1b011\", \"Plant Beta\", \"0fe3e48b\", \"2017 Plant Study\", \"59d435cd\", \"A0043002\", \"76.50106683\", \"42.44409301\", \"2017\", \"Field_1\", \"Plot_11\", \"SubPlot_112\", \"Plant_1122\", \"Pot_1122\", \"Block_11\", \"Entry_11\", \"Rep_12\", \"\", \"1\", \"\", \"\" ], [ \"2019-09-10T18:17:34.433Z\", \"67e2d87c\", \"Plant Gamma\", \"0fe3e48b\", \"2017 Plant Study\", \"06307ec0\", \"A0043001\", \"76.50106681\", \"42.44409356\", \"2017\", \"Field_1\", \"Plot_12\", \"SubPlot_123\", \"Plant_1233\", \"Pot_1233\", \"Block_12\", \"Entry_12\", \"Rep_11\", \"\", \"3\", \"\", \"\" ], [ \"2019-09-10T18:18:34.433Z\", \"67e2d87c\", \"Plant Gamma\", \"0fe3e48b\", \"2017 Plant Study\", \"06307ec0\", \"A0043001\", \"76.50106681\", \"42.44409356\", \"2017\", \"Field_1\", \"Plot_12\", \"SubPlot_123\", \"Plant_1233\", \"Pot_1233\", \"Block_12\", \"Entry_12\", \"Rep_11\", \"25.5\", \"\", \"\", \"\" ], [ \"2019-09-10T18:19:15.629Z\", \"d98d0d4c\", \"Plant Epsilon\", \"0fe3e48b\", \"2017 Plant Study\", \"59d435cd\", \"A0043002\", \"76.50106683\", \"42.44409356\", \"2017\", \"Field_1\", \"Plot_12\", \"SubPlot_124\", \"Plant_1244\", \"Pot_1244\", \"Block_12\", \"Entry_12\", \"Rep_12\", \"28.9\", \"\", \"\", \"\" ], [ \"2019-09-10T18:20:15.629Z\", \"d98d0d4c\", \"Plant Epsilon\", \"0fe3e48b\", \"2017 Plant Study\", \"59d435cd\", \"A0043002\", \"76.50106683\", \"42.44409356\", \"2017\", \"Field_1\", \"Plot_12\", \"SubPlot_124\", \"Plant_1244\", \"Pot_1244\", \"Block_12\", \"Entry_12\", \"Rep_12\", \"\", \"0\", \"\", \"\" ] ],\n    \"headerRow\" : [ \"observationTimeStamp\", \"observationUnitDbId\", \"observationUnitName\", \"studyDbId\", \"studyName\", \"germplasmDbId\", \"germplasmName\", \"positionCoordinateX\", \"positionCoordinateY\", \"year\", \"field\", \"plot\", \"sub-plot\", \"plant\", \"pot\", \"block\", \"entry\", \"rep\" ],\n    \"observationVariables\" : [ {\n      \"observationVariableDbId\" : \"367aa1a9\",\n      \"observationVariableName\" : \"Plant height\"\n    }, {\n      \"observationVariableDbId\" : \"2acb934c\",\n      \"observationVariableName\" : \"Carotenoid\"\n    }, {\n      \"observationVariableDbId\" : \"85a21ce1\",\n      \"observationVariableName\" : \"Root color\"\n    }, {\n      \"observationVariableDbId\" : \"46f590e5\",\n      \"observationVariableName\" : \"Virus severity\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationTableResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationTableResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationTableResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
