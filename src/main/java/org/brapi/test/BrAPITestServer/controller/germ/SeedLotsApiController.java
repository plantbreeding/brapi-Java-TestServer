package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.Metadata;
import io.swagger.model.germ.SeedLot;
import io.swagger.model.germ.SeedLotListResponse;
import io.swagger.model.germ.SeedLotListResponseResult;
import io.swagger.model.germ.SeedLotNewRequest;
import io.swagger.model.germ.SeedLotNewTransactionRequest;
import io.swagger.model.germ.SeedLotSingleResponse;
import io.swagger.model.germ.SeedLotTransaction;
import io.swagger.model.germ.SeedLotTransactionListResponse;
import io.swagger.model.germ.SeedLotTransactionListResponseResult;
import io.swagger.api.germ.SeedLotsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.germ.SeedLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class SeedLotsApiController extends BrAPIController implements SeedLotsApi {

	private static final Logger log = LoggerFactory.getLogger(SeedLotsApiController.class);

	private final SeedLotService seedLotService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public SeedLotsApiController(SeedLotService seedLotService, HttpServletRequest request) {
		this.seedLotService = seedLotService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeedLotListResponse> seedlotsGet(
			@RequestParam(value = "seedLotDbId", required = false) String seedLotDbId,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "germplasmName", required = false) String germplasmName,
			@RequestParam(value = "crossDbId", required = false) String crossDbId,
			@RequestParam(value = "crossName", required = false) String crossName,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<SeedLot> data = seedLotService.findSeedLots(seedLotDbId, germplasmDbId, germplasmName, crossDbId,
				crossName, commonCropName, programDbId, externalReferenceId, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new SeedLotListResponse(), new SeedLotListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeedLotListResponse> seedlotsPost(@RequestBody List<SeedLotNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<SeedLot> data = seedLotService.saveSeedLots(body);
		return responseOK(new SeedLotListResponse(), new SeedLotListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeedLotSingleResponse> seedlotsSeedLotDbIdGet(@PathVariable("seedLotDbId") String seedLotDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		SeedLot data = seedLotService.getSeedLot(seedLotDbId);
		return responseOK(new SeedLotSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeedLotSingleResponse> seedlotsSeedLotDbIdPut(@PathVariable("seedLotDbId") String seedLotDbId,
			@RequestBody SeedLotNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		SeedLot data = seedLotService.updateSeedLot(seedLotDbId, body);
		return responseOK(new SeedLotSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeedLotTransactionListResponse> seedlotsSeedLotDbIdTransactionsGet(
			@PathVariable("seedLotDbId") String seedLotDbId,
			@RequestParam(value = "transactionDbId", required = false) String transactionDbId,
			@RequestParam(value = "transactionDirection", required = false) String transactionDirection,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<SeedLotTransaction> data = seedLotService.findSeedLotTransactions(seedLotDbId, transactionDbId,
				transactionDirection, metadata);
		return responseOK(new SeedLotTransactionListResponse(), new SeedLotTransactionListResponseResult(), data,
				metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeedLotTransactionListResponse> seedlotsTransactionsGet(
			@RequestParam(value = "transactionDbId", required = false) String transactionDbId,
			@RequestParam(value = "seedLotDbId", required = false) String seedLotDbId,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "germplasmName", required = false) String germplasmName,
			@RequestParam(value = "crossDbId", required = false) String crossDbId,
			@RequestParam(value = "crossName", required = false) String crossName,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<SeedLotTransaction> data = seedLotService.findSeedLotTransactions(transactionDbId, seedLotDbId,
				germplasmDbId, germplasmName, crossDbId, crossName, commonCropName, programDbId, externalReferenceId,
				externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new SeedLotTransactionListResponse(), new SeedLotTransactionListResponseResult(), data,
				metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeedLotTransactionListResponse> seedlotsTransactionsPost(
			@RequestBody List<SeedLotNewTransactionRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<SeedLotTransaction> data = seedLotService.saveSeedLotTransactions(body);
		return responseOK(new SeedLotTransactionListResponse(), new SeedLotTransactionListResponseResult(), data);
	}

}
