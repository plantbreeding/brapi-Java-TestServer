package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.pheno.ObservationUnitListResponse;
import io.swagger.model.pheno.ObservationUnitNewRequest;
import io.swagger.model.pheno.ObservationUnitSearchRequest;
import io.swagger.model.pheno.ObservationUnitSingleResponse;
import io.swagger.model.pheno.ObservationUnitTableResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.pheno.ObservationunitsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
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
public class ObservationunitsApiController extends BrAPIController implements ObservationunitsApi {

	private static final Logger log = LoggerFactory.getLogger(ObservationunitsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public ObservationunitsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<ObservationUnitListResponse> observationunitsGet(
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@Valid @RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@Valid @RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@Valid @RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@Valid @RequestParam(value = "includeObservations", required = false) Boolean includeObservations,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationUnitListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationUnitListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationUnitSingleResponse> observationunitsObservationUnitDbIdGet(
			@PathVariable("observationUnitDbId") String observationUnitDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationUnitSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationUnitSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationUnitSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationUnitSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationUnitSingleResponse> observationunitsObservationUnitDbIdPut(
			@PathVariable("observationUnitDbId") String observationUnitDbId,
			@Valid @RequestBody ObservationUnitNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationUnitSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationUnitSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationUnitSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationUnitSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationUnitListResponse> observationunitsPost(
			@Valid @RequestBody List<ObservationUnitNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationUnitListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationUnitListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationUnitListResponse> observationunitsPut(
			@Valid @RequestBody Map<String, ObservationUnitNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationUnitListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationUnitListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationUnitTableResponse> observationunitsTableGet(
			@RequestHeader(value = "Accept", required = true) WSMIMEDataTypes accept,
			@Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@Valid @RequestParam(value = "observationLevel", required = false) String observationLevel,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		if (accept != null) {
			try {
				return new ResponseEntity<ObservationUnitTableResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ [ \"f3a8a3db\", \"Plant Alpha\", \"0fe3e48b\", \"2017 Plant Study\", \"06307ec0\", \"A0043001\", \"76.50106681\", \"42.44409301\", \"2017\", \"Field_1\", \"Plot_11\", \"SubPlot_111\", \"Plant_1111\", \"Pot_1111\", \"Block_11\", \"Entry_11\", \"Rep_11\", \"25.3\", \"3\", \"50.75\" ], [ \"05d1b011\", \"Plant Beta\", \"0fe3e48b\", \"2017 Plant Study\", \"59d435cd\", \"A0043002\", \"76.50106683\", \"42.44409301\", \"2017\", \"Field_1\", \"Plot_11\", \"SubPlot_112\", \"Plant_1122\", \"Pot_1122\", \"Block_11\", \"Entry_11\", \"Rep_12\", \"27.9\", \"1\", \"45.345\" ], [ \"67e2d87c\", \"Plant Gamma\", \"0fe3e48b\", \"2017 Plant Study\", \"06307ec0\", \"A0043001\", \"76.50106681\", \"42.44409356\", \"2017\", \"Field_1\", \"Plot_12\", \"SubPlot_123\", \"Plant_1233\", \"Pot_1233\", \"Block_12\", \"Entry_12\", \"Rep_11\", \"25.5\", \"3\", \"50.76\" ], [ \"d98d0d4c\", \"Plant Epsilon\", \"0fe3e48b\", \"2017 Plant Study\", \"59d435cd\", \"A0043002\", \"76.50106683\", \"42.44409356\", \"2017\", \"Field_1\", \"Plot_12\", \"SubPlot_124\", \"Plant_1244\", \"Pot_1244\", \"Block_12\", \"Entry_12\", \"Rep_12\", \"28.9\", \"0\", \"46.5\" ] ],\n    \"headerRow\" : [ \"observationUnitDbId\", \"observationUnitName\", \"studyDbId\", \"studyName\", \"germplasmDbId\", \"germplasmName\", \"positionCoordinateX\", \"positionCoordinateY\", \"year\", \"field\", \"plot\", \"sub-plot\", \"plant\", \"pot\", \"block\", \"entry\", \"rep\" ],\n    \"observationVariables\" : [ {\n      \"observationVariableDbId\" : \"367aa1a9\",\n      \"observationVariableName\" : \"Plant height\"\n    }, {\n      \"observationVariableDbId\" : \"2acb934c\",\n      \"observationVariableName\" : \"Carotenoid\"\n    }, {\n      \"observationVariableDbId\" : \"85a21ce1\",\n      \"observationVariableName\" : \"Root color\"\n    }, {\n      \"observationVariableDbId\" : \"46f590e5\",\n      \"observationVariableName\" : \"Virus severity\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationUnitTableResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationUnitTableResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationUnitTableResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationUnitListResponse> searchObservationunitsPost(
			@Valid @RequestBody ObservationUnitSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationUnitListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationUnitListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ObservationUnitListResponse> searchObservationunitsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<ObservationUnitListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						ObservationUnitListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ObservationUnitListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
