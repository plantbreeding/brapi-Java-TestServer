package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.geno.CallSetsListResponse;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.VariantSetResponse;
import io.swagger.model.geno.VariantSetsExtractRequest;
import io.swagger.model.geno.VariantSetsListResponse;
import io.swagger.model.geno.VariantSetsSearchRequest;
import io.swagger.model.geno.VariantsListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.geno.VariantsetsApi;

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
public class VariantsetsApiController extends BrAPIController implements VariantsetsApi {

	private static final Logger log = LoggerFactory.getLogger(VariantsetsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public VariantsetsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<VariantSetResponse> variantsetsExtractPost(
			@Valid @RequestBody VariantSetsExtractRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VariantSetResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"availableFormats\" : [ {\n      \"dataFormat\" : \"VCF\",\n      \"fileFormat\" : \"application/excel\",\n      \"fileURL\" : \"https://brapi.org/example/VCF_1.xlsx\"\n    }, {\n      \"dataFormat\" : \"VCF\",\n      \"fileFormat\" : \"text/csv\",\n      \"fileURL\" : \"https://brapi.org/example/VCF_2.csv\"\n    } ],\n    \"additionalInfo\" : {\n      \"key\" : \"additionalInfo\"\n    },\n    \"variantSetDbId\" : \"87a6ac1e\",\n    \"callSetCount\" : 341,\n    \"referenceSetDbId\" : \"57eae639\",\n    \"variantSetName\" : \"Maize QC DataSet 002334\",\n    \"analysis\" : [ {\n      \"software\" : [ \"https://github.com/genotyping/QC\" ],\n      \"analysisDbId\" : \"6191a6bd\",\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n      \"type\" : \"QC\",\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"analysisName\" : \"Standard QC\"\n    }, {\n      \"software\" : [ \"https://github.com/genotyping/QC\" ],\n      \"analysisDbId\" : \"6191a6bd\",\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n      \"type\" : \"QC\",\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"analysisName\" : \"Standard QC\"\n    } ],\n    \"studyDbId\" : \"2fc3b034\",\n    \"variantCount\" : 250\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VariantSetResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VariantSetResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VariantSetResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VariantSetsListResponse> variantsetsGet(
			@Valid @RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@Valid @RequestParam(value = "callSetDbId", required = false) String callSetDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "studyName", required = false) String studyName,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
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

	public ResponseEntity<CallsListResponse> variantsetsVariantSetDbIdCallsGet(
			@PathVariable("variantSetDbId") String variantSetDbId,
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

	public ResponseEntity<CallSetsListResponse> variantsetsVariantSetDbIdCallsetsGet(
			@PathVariable("variantSetDbId") String variantSetDbId,
			@Valid @RequestParam(value = "callSetDbId", required = false) String callSetDbId,
			@Valid @RequestParam(value = "callSetName", required = false) String callSetName,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
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

	public ResponseEntity<VariantSetResponse> variantsetsVariantSetDbIdGet(
			@PathVariable("variantSetDbId") String variantSetDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VariantSetResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"availableFormats\" : [ {\n      \"dataFormat\" : \"VCF\",\n      \"fileFormat\" : \"application/excel\",\n      \"fileURL\" : \"https://brapi.org/example/VCF_1.xlsx\"\n    }, {\n      \"dataFormat\" : \"VCF\",\n      \"fileFormat\" : \"text/csv\",\n      \"fileURL\" : \"https://brapi.org/example/VCF_2.csv\"\n    } ],\n    \"additionalInfo\" : {\n      \"key\" : \"additionalInfo\"\n    },\n    \"variantSetDbId\" : \"87a6ac1e\",\n    \"callSetCount\" : 341,\n    \"referenceSetDbId\" : \"57eae639\",\n    \"variantSetName\" : \"Maize QC DataSet 002334\",\n    \"analysis\" : [ {\n      \"software\" : [ \"https://github.com/genotyping/QC\" ],\n      \"analysisDbId\" : \"6191a6bd\",\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n      \"type\" : \"QC\",\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"analysisName\" : \"Standard QC\"\n    }, {\n      \"software\" : [ \"https://github.com/genotyping/QC\" ],\n      \"analysisDbId\" : \"6191a6bd\",\n      \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"description\" : \"This is a formal description of a QC methodology. Blah blah blah ...\",\n      \"type\" : \"QC\",\n      \"updated\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"analysisName\" : \"Standard QC\"\n    } ],\n    \"studyDbId\" : \"2fc3b034\",\n    \"variantCount\" : 250\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VariantSetResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VariantSetResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VariantSetResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VariantsListResponse> variantsetsVariantSetDbIdVariantsGet(
			@PathVariable("variantSetDbId") String variantSetDbId,
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
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

	public ResponseEntity<VariantSetsListResponse> searchVariantsetsPost(
			@Valid @RequestBody VariantSetsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
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
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
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
