package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.geno.VendorOrderListResponse;
import io.swagger.model.geno.VendorOrderStatusResponse;
import io.swagger.model.geno.VendorOrderSubmissionRequest;
import io.swagger.model.geno.VendorOrderSubmissionSingleResponse;
import io.swagger.model.geno.VendorPlateListResponse;
import io.swagger.model.geno.VendorPlateSubmissionIdSingleResponse;
import io.swagger.model.geno.VendorPlateSubmissionRequest;
import io.swagger.model.geno.VendorPlateSubmissionSingleResponse;
import io.swagger.model.geno.VendorResultFileListResponse;
import io.swagger.model.geno.VendorSpecificationSingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.geno.VendorApi;

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
public class VendorApiController extends BrAPIController implements VendorApi {

	private static final Logger log = LoggerFactory.getLogger(VendorApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public VendorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<VendorOrderListResponse> vendorOrdersGet(
			@Valid @RequestParam(value = "orderId", required = false) String orderId,
			@Valid @RequestParam(value = "submissionId", required = false) String submissionId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VendorOrderListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"serviceIds\" : [ \"e8f60f64\", \"05bd925a\", \"b698fb5e\" ],\n      \"clientId\" : \"7b51ad15\",\n      \"orderId\" : \"96ba0ca3\",\n      \"requiredServiceInfo\" : {\n        \"extractDNA\" : \"true\",\n        \"genus\" : \"Zea\",\n        \"species\" : \"mays\",\n        \"volumePerWell\" : \"2.3 ml\"\n      },\n      \"numberOfSamples\" : 180\n    }, {\n      \"serviceIds\" : [ \"e8f60f64\", \"05bd925a\", \"b698fb5e\" ],\n      \"clientId\" : \"7b51ad15\",\n      \"orderId\" : \"96ba0ca3\",\n      \"requiredServiceInfo\" : {\n        \"extractDNA\" : \"true\",\n        \"genus\" : \"Zea\",\n        \"species\" : \"mays\",\n        \"volumePerWell\" : \"2.3 ml\"\n      },\n      \"numberOfSamples\" : 180\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VendorOrderListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VendorOrderListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VendorOrderListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VendorPlateListResponse> vendorOrdersOrderIdPlatesGet(@PathVariable("orderId") String orderId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VendorPlateListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"clientPlateBarcode\" : \"31dd5787\",\n      \"sampleSubmissionFormat\" : \"PLATE_96\",\n      \"clientPlateId\" : \"0ad6c0ef\",\n      \"samples\" : [ {\n        \"comments\" : \"This is my favorite sample, please be extra careful with it.\",\n        \"column\" : 6,\n        \"concentration\" : {\n          \"units\" : \"ng/ul\",\n          \"value\" : 2.3\n        },\n        \"clientSampleBarCode\" : \"7c07e527\",\n        \"speciesName\" : \"Aspergillus fructus\",\n        \"taxonomyOntologyReference\" : {\n          \"ontologyDbId\" : \"6b071868\",\n          \"ontologyName\" : \"The Crop Ontology\",\n          \"documentationLinks\" : [ {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          }, {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          } ],\n          \"version\" : \"7.2.3\"\n        },\n        \"tissueType\" : \"Root\",\n        \"organismName\" : \"Aspergillus fructus\",\n        \"well\" : \"B6\",\n        \"row\" : \"B\",\n        \"clientSampleId\" : \"bd96bd69\"\n      }, {\n        \"comments\" : \"This is my favorite sample, please be extra careful with it.\",\n        \"column\" : 6,\n        \"concentration\" : {\n          \"units\" : \"ng/ul\",\n          \"value\" : 2.3\n        },\n        \"clientSampleBarCode\" : \"7c07e527\",\n        \"speciesName\" : \"Aspergillus fructus\",\n        \"taxonomyOntologyReference\" : {\n          \"ontologyDbId\" : \"6b071868\",\n          \"ontologyName\" : \"The Crop Ontology\",\n          \"documentationLinks\" : [ {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          }, {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          } ],\n          \"version\" : \"7.2.3\"\n        },\n        \"tissueType\" : \"Root\",\n        \"organismName\" : \"Aspergillus fructus\",\n        \"well\" : \"B6\",\n        \"row\" : \"B\",\n        \"clientSampleId\" : \"bd96bd69\"\n      } ]\n    }, {\n      \"clientPlateBarcode\" : \"31dd5787\",\n      \"sampleSubmissionFormat\" : \"PLATE_96\",\n      \"clientPlateId\" : \"0ad6c0ef\",\n      \"samples\" : [ {\n        \"comments\" : \"This is my favorite sample, please be extra careful with it.\",\n        \"column\" : 6,\n        \"concentration\" : {\n          \"units\" : \"ng/ul\",\n          \"value\" : 2.3\n        },\n        \"clientSampleBarCode\" : \"7c07e527\",\n        \"speciesName\" : \"Aspergillus fructus\",\n        \"taxonomyOntologyReference\" : {\n          \"ontologyDbId\" : \"6b071868\",\n          \"ontologyName\" : \"The Crop Ontology\",\n          \"documentationLinks\" : [ {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          }, {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          } ],\n          \"version\" : \"7.2.3\"\n        },\n        \"tissueType\" : \"Root\",\n        \"organismName\" : \"Aspergillus fructus\",\n        \"well\" : \"B6\",\n        \"row\" : \"B\",\n        \"clientSampleId\" : \"bd96bd69\"\n      }, {\n        \"comments\" : \"This is my favorite sample, please be extra careful with it.\",\n        \"column\" : 6,\n        \"concentration\" : {\n          \"units\" : \"ng/ul\",\n          \"value\" : 2.3\n        },\n        \"clientSampleBarCode\" : \"7c07e527\",\n        \"speciesName\" : \"Aspergillus fructus\",\n        \"taxonomyOntologyReference\" : {\n          \"ontologyDbId\" : \"6b071868\",\n          \"ontologyName\" : \"The Crop Ontology\",\n          \"documentationLinks\" : [ {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          }, {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          } ],\n          \"version\" : \"7.2.3\"\n        },\n        \"tissueType\" : \"Root\",\n        \"organismName\" : \"Aspergillus fructus\",\n        \"well\" : \"B6\",\n        \"row\" : \"B\",\n        \"clientSampleId\" : \"bd96bd69\"\n      } ]\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VendorPlateListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VendorPlateListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VendorPlateListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VendorResultFileListResponse> vendorOrdersOrderIdResultsGet(
			@PathVariable("orderId") String orderId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VendorResultFileListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ {\n      \"fileName\" : \"sequence_data_ce640bd3.csv\",\n      \"md5sum\" : \"c2365e900c81a89cf74d83dab60df146\",\n      \"clientSampleIds\" : [ \"3968733e\", \"e0de6391\", \"66854172\" ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"fileURL\" : \"https://vendor.org/data/sequence_data_ce640bd3.csv\",\n      \"fileType\" : \"text/csv\"\n    }, {\n      \"fileName\" : \"sequence_data_ce640bd3.csv\",\n      \"md5sum\" : \"c2365e900c81a89cf74d83dab60df146\",\n      \"clientSampleIds\" : [ \"3968733e\", \"e0de6391\", \"66854172\" ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"fileURL\" : \"https://vendor.org/data/sequence_data_ce640bd3.csv\",\n      \"fileType\" : \"text/csv\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VendorResultFileListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VendorResultFileListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VendorResultFileListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VendorOrderStatusResponse> vendorOrdersOrderIdStatusGet(
			@PathVariable("orderId") String orderId,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VendorOrderStatusResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"status\" : \"registered\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VendorOrderStatusResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VendorOrderStatusResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VendorOrderStatusResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VendorOrderSubmissionSingleResponse> vendorOrdersPost(
			@Valid @RequestBody VendorOrderSubmissionRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VendorOrderSubmissionSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"orderId\" : \"b5144468\",\n    \"shipmentForms\" : [ {\n      \"fileDescription\" : \"This is a shipment manifest form\",\n      \"fileName\" : \"Shipment Manifest\",\n      \"fileURL\" : \"https://vendor.org/forms/manifest.pdf\"\n    }, {\n      \"fileDescription\" : \"This is a shipment manifest form\",\n      \"fileName\" : \"Shipment Manifest\",\n      \"fileURL\" : \"https://vendor.org/forms/manifest.pdf\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VendorOrderSubmissionSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VendorOrderSubmissionSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VendorOrderSubmissionSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VendorPlateSubmissionIdSingleResponse> vendorPlatesPost(
			@Valid @RequestBody VendorPlateSubmissionRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VendorPlateSubmissionIdSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"submissionId\" : \"f8f409e0\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VendorPlateSubmissionIdSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VendorPlateSubmissionIdSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VendorPlateSubmissionIdSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VendorPlateSubmissionSingleResponse> vendorPlatesSubmissionIdGet(
			@PathVariable("submissionId") String submissionId,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VendorPlateSubmissionSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"clientId\" : \"e470ae0d\",\n    \"plates\" : [ {\n      \"clientPlateBarcode\" : \"bfb33593\",\n      \"sampleSubmissionFormat\" : \"PLATE_96\",\n      \"clientPlateId\" : \"dae8f49d\",\n      \"samples\" : [ {\n        \"comments\" : \"This is my favorite sample, please be extra careful with it.\",\n        \"column\" : 6,\n        \"concentration\" : {\n          \"units\" : \"ng/ul\",\n          \"value\" : 2.3\n        },\n        \"clientSampleBarCode\" : \"7c07e527\",\n        \"speciesName\" : \"Aspergillus fructus\",\n        \"taxonomyOntologyReference\" : {\n          \"ontologyDbId\" : \"6b071868\",\n          \"ontologyName\" : \"The Crop Ontology\",\n          \"documentationLinks\" : [ {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          }, {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          } ],\n          \"version\" : \"7.2.3\"\n        },\n        \"tissueType\" : \"Root\",\n        \"organismName\" : \"Aspergillus fructus\",\n        \"well\" : \"B6\",\n        \"row\" : \"B\",\n        \"clientSampleId\" : \"bd96bd69\"\n      }, {\n        \"comments\" : \"This is my favorite sample, please be extra careful with it.\",\n        \"column\" : 6,\n        \"concentration\" : {\n          \"units\" : \"ng/ul\",\n          \"value\" : 2.3\n        },\n        \"clientSampleBarCode\" : \"7c07e527\",\n        \"speciesName\" : \"Aspergillus fructus\",\n        \"taxonomyOntologyReference\" : {\n          \"ontologyDbId\" : \"6b071868\",\n          \"ontologyName\" : \"The Crop Ontology\",\n          \"documentationLinks\" : [ {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          }, {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          } ],\n          \"version\" : \"7.2.3\"\n        },\n        \"tissueType\" : \"Root\",\n        \"organismName\" : \"Aspergillus fructus\",\n        \"well\" : \"B6\",\n        \"row\" : \"B\",\n        \"clientSampleId\" : \"bd96bd69\"\n      } ]\n    }, {\n      \"clientPlateBarcode\" : \"bfb33593\",\n      \"sampleSubmissionFormat\" : \"PLATE_96\",\n      \"clientPlateId\" : \"dae8f49d\",\n      \"samples\" : [ {\n        \"comments\" : \"This is my favorite sample, please be extra careful with it.\",\n        \"column\" : 6,\n        \"concentration\" : {\n          \"units\" : \"ng/ul\",\n          \"value\" : 2.3\n        },\n        \"clientSampleBarCode\" : \"7c07e527\",\n        \"speciesName\" : \"Aspergillus fructus\",\n        \"taxonomyOntologyReference\" : {\n          \"ontologyDbId\" : \"6b071868\",\n          \"ontologyName\" : \"The Crop Ontology\",\n          \"documentationLinks\" : [ {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          }, {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          } ],\n          \"version\" : \"7.2.3\"\n        },\n        \"tissueType\" : \"Root\",\n        \"organismName\" : \"Aspergillus fructus\",\n        \"well\" : \"B6\",\n        \"row\" : \"B\",\n        \"clientSampleId\" : \"bd96bd69\"\n      }, {\n        \"comments\" : \"This is my favorite sample, please be extra careful with it.\",\n        \"column\" : 6,\n        \"concentration\" : {\n          \"units\" : \"ng/ul\",\n          \"value\" : 2.3\n        },\n        \"clientSampleBarCode\" : \"7c07e527\",\n        \"speciesName\" : \"Aspergillus fructus\",\n        \"taxonomyOntologyReference\" : {\n          \"ontologyDbId\" : \"6b071868\",\n          \"ontologyName\" : \"The Crop Ontology\",\n          \"documentationLinks\" : [ {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          }, {\n            \"type\" : \"OBO\",\n            \"URL\" : \"http://purl.obolibrary.org/obo/ro.owl\"\n          } ],\n          \"version\" : \"7.2.3\"\n        },\n        \"tissueType\" : \"Root\",\n        \"organismName\" : \"Aspergillus fructus\",\n        \"well\" : \"B6\",\n        \"row\" : \"B\",\n        \"clientSampleId\" : \"bd96bd69\"\n      } ]\n    } ],\n    \"numberOfSamples\" : 180\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VendorPlateSubmissionSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VendorPlateSubmissionSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VendorPlateSubmissionSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<VendorSpecificationSingleResponse> vendorSpecificationsGet(
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<VendorSpecificationSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"additionalInfo\" : {\n      \"key\" : { }\n    },\n    \"vendorContact\" : {\n      \"vendorURL\" : \"https://sequencing.org/vendor\",\n      \"vendorPhone\" : \"+1-800-555-5555\",\n      \"vendorContactName\" : \"Bob Robertson\",\n      \"vendorEmail\" : \"bob@bob.org\",\n      \"vendorCity\" : \"Townsville\",\n      \"vendorDescription\" : \"This is a sequencing vendor. Sequencing happens here.\",\n      \"vendorCountry\" : \"USA\",\n      \"vendorName\" : \"The Example Vendor Lab\",\n      \"vendorAddress\" : \"123 Main Street\"\n    },\n    \"services\" : [ {\n      \"servicePlatformMarkerType\" : \"FIXED\",\n      \"serviceDescription\" : \"A combined DNA extract and Sequencing process using technology and science. Lots of automated pipet machines.\",\n      \"serviceId\" : \"085d298f\",\n      \"serviceName\" : \"The Deluxe Service\",\n      \"specificRequirements\" : [ {\n        \"description\" : \"The genus of the samples\",\n        \"key\" : \"genus\"\n      }, {\n        \"description\" : \"The species of the samples\",\n        \"key\" : \"species\"\n      }, {\n        \"description\" : \"Approximate volume of each sample (ex 2.3 ml)\",\n        \"key\" : \"volumePerWell\"\n      }, {\n        \"description\" : \"Does DNA extraction need to happen before sequencing (ex true)\",\n        \"key\" : \"extractDNA\"\n      } ],\n      \"servicePlatformName\" : \"RNA-seq\"\n    }, {\n      \"servicePlatformMarkerType\" : \"FIXED\",\n      \"serviceDescription\" : \"A combined DNA extract and Sequencing process using technology and science. Lots of automated pipet machines.\",\n      \"serviceId\" : \"085d298f\",\n      \"serviceName\" : \"The Deluxe Service\",\n      \"specificRequirements\" : [ {\n        \"description\" : \"The genus of the samples\",\n        \"key\" : \"genus\"\n      }, {\n        \"description\" : \"The species of the samples\",\n        \"key\" : \"species\"\n      }, {\n        \"description\" : \"Approximate volume of each sample (ex 2.3 ml)\",\n        \"key\" : \"volumePerWell\"\n      }, {\n        \"description\" : \"Does DNA extraction need to happen before sequencing (ex true)\",\n        \"key\" : \"extractDNA\"\n      } ],\n      \"servicePlatformName\" : \"RNA-seq\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						VendorSpecificationSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<VendorSpecificationSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<VendorSpecificationSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
