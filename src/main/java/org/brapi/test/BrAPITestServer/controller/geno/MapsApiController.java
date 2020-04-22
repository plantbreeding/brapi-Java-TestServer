package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.geno.GenomeMapListResponse;
import io.swagger.model.geno.GenomeMapSingleResponse;
import io.swagger.model.geno.LinkageGroupListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.geno.MapsApi;

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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class MapsApiController extends BrAPIController implements MapsApi {

	private static final Logger log = LoggerFactory.getLogger(MapsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public MapsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<GenomeMapListResponse> mapsGet(
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "mapPUI", required = false) String mapPUI,
			@Valid @RequestParam(value = "scientificName", required = false) String scientificName,
			@Valid @RequestParam(value = "type", required = false) String type,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<GenomeMapListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"commonCropName\" : \"Paw Paw\",\n      \"documentationURL\" : \"https://brapi.org\",\n      \"mapDbId\" : \"142cffd5\",\n      \"comments\" : \"Comments about this map\",\n      \"mapPUI\" : \"doi:10.3207/2959859860\",\n      \"scientificName\" : \"Zea mays\",\n      \"type\" : \"Genetic\",\n      \"unit\" : \"cM\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"markerCount\" : 1100,\n      \"mapName\" : \"Genome Map 1\",\n      \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"linkageGroupCount\" : 5\n    }, {\n      \"commonCropName\" : \"Paw Paw\",\n      \"documentationURL\" : \"https://brapi.org\",\n      \"mapDbId\" : \"142cffd5\",\n      \"comments\" : \"Comments about this map\",\n      \"mapPUI\" : \"doi:10.3207/2959859860\",\n      \"scientificName\" : \"Zea mays\",\n      \"type\" : \"Genetic\",\n      \"unit\" : \"cM\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"markerCount\" : 1100,\n      \"mapName\" : \"Genome Map 1\",\n      \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"linkageGroupCount\" : 5\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						GenomeMapListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<GenomeMapListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<GenomeMapListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<GenomeMapSingleResponse> mapsMapDbIdGet(
			@PathVariable("mapDbId") String mapDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<GenomeMapSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"commonCropName\" : \"Paw Paw\",\n    \"documentationURL\" : \"https://brapi.org\",\n    \"mapDbId\" : \"142cffd5\",\n    \"comments\" : \"Comments about this map\",\n    \"mapPUI\" : \"doi:10.3207/2959859860\",\n    \"scientificName\" : \"Zea mays\",\n    \"type\" : \"Genetic\",\n    \"unit\" : \"cM\",\n    \"additionalInfo\" : {\n      \"key\" : \"additionalInfo\"\n    },\n    \"markerCount\" : 1100,\n    \"mapName\" : \"Genome Map 1\",\n    \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"linkageGroupCount\" : 5\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						GenomeMapSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<GenomeMapSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<GenomeMapSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<LinkageGroupListResponse> mapsMapDbIdLinkagegroupsGet(
			@PathVariable("mapDbId") String mapDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<LinkageGroupListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"linkageGroupName\" : \"Chromosome 3\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"markerCount\" : 150,\n      \"maxPosition\" : 2500\n    }, {\n      \"linkageGroupName\" : \"Chromosome 3\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"markerCount\" : 150,\n      \"maxPosition\" : 2500\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						LinkageGroupListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<LinkageGroupListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<LinkageGroupListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
