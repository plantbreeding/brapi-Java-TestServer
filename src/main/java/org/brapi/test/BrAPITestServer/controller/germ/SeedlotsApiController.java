package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.germ.Body;
import io.swagger.model.germ.SeedLotListResponse;
import io.swagger.model.germ.SeedLotNewRequest;
import io.swagger.model.germ.SeedLotSingleResponse;
import io.swagger.model.germ.SeedLotTransactionListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.germ.SeedlotsApi;

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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class SeedlotsApiController implements SeedlotsApi {

	private static final Logger log = LoggerFactory.getLogger(SeedlotsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public SeedlotsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<SeedLotListResponse> seedlotsGet(
			@Valid @RequestParam(value = "seedLotDbId", required = false) String seedLotDbId,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SeedLotListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SeedLotListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SeedLotListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SeedLotListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SeedLotListResponse> seedlotsPost(
			@Valid @RequestBody List<SeedLotNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SeedLotListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SeedLotListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SeedLotListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SeedLotListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SeedLotSingleResponse> seedlotsSeedLotDbIdGet(
			@PathVariable("seedLotDbId") String seedLotDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SeedLotSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SeedLotSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SeedLotSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SeedLotSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SeedLotSingleResponse> seedlotsSeedLotDbIdPut(
			@PathVariable("seedLotDbId") String seedLotDbId,
			@Valid @RequestBody SeedLotNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SeedLotSingleResponse>(objectMapper.readValue(
						"{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SeedLotSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SeedLotSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SeedLotSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SeedLotTransactionListResponse> seedlotsSeedLotDbIdTransactionsGet(
			@PathVariable("seedLotDbId") String seedLotDbId,
			@Valid @RequestParam(value = "transactionDbId", required = false) String transactionDbId,
			@Valid @RequestParam(value = "transactionDirection", required = false) String transactionDirection,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SeedLotTransactionListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SeedLotTransactionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SeedLotTransactionListResponse> seedlotsTransactionsGet(
			@Valid @RequestParam(value = "transactionDbId", required = false) String transactionDbId,
			@Valid @RequestParam(value = "seedLotDbId", required = false) String seedLotDbId,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SeedLotTransactionListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SeedLotTransactionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SeedLotTransactionListResponse> seedlotsTransactionsPost(
			@Valid @RequestBody Body body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SeedLotTransactionListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						SeedLotTransactionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
