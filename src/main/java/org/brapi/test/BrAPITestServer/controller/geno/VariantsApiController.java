package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.geno.CallSetResponse1;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.VariantsListResponse;
import io.swagger.model.geno.VariantsSearchRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.geno.VariantsApi;

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
public class VariantsApiController extends BrAPIController implements VariantsApi {

	private static final Logger log = LoggerFactory.getLogger(VariantsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public VariantsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<VariantsListResponse> variantsGet(
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@Valid @RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
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

	public ResponseEntity<CallsListResponse> variantsVariantDbIdCallsGet(
			@PathVariable("variantDbId") String variantDbId,
			@Valid @RequestParam(value = "expandHomozygotes", required = false) Boolean expandHomozygotes,
			@Valid @RequestParam(value = "unknownString", required = false) String unknownString,
			@Valid @RequestParam(value = "sepPhased", required = false) String sepPhased,
			@Valid @RequestParam(value = "sepUnphased", required = false) String sepUnphased,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
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

	public ResponseEntity<CallSetResponse1> variantsVariantDbIdGet(
			@PathVariable("variantDbId") String variantDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CallSetResponse1>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"referenceBases\" : \"TAGGATTGAGCTCTATAT\",\n    \"start\" : 500,\n    \"cipos\" : [ -12000, 1000 ],\n    \"variantType\" : \"DUP\",\n    \"ciend\" : [ -1000, 0 ],\n    \"alternate_bases\" : [ \"TAGGATTGAGCTCTATAT\" ],\n    \"additionalInfo\" : {\n      \"key\" : \"additionalInfo\"\n    },\n    \"variantSetDbId\" : [ \"c8ae400b\", \"ef2c204b\" ],\n    \"filtersFailed\" : [ \"d629a669\", \"3f14f578\" ],\n    \"svlen\" : 1500,\n    \"variantDbId\" : \"628e89c5\",\n    \"variantNames\" : [ \"RefSNP_ID_1\", \"06ea312e\" ],\n    \"end\" : 518,\n    \"filtersApplied\" : true,\n    \"filtersPassed\" : true,\n    \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"referenceName\" : \"chr_20\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CallSetResponse1.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CallSetResponse1>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CallSetResponse1>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VariantsListResponse> searchVariantsPost(
			@Valid @RequestBody VariantsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
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
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
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

}
