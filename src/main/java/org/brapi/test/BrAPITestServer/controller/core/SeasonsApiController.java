package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.Metadata;
import io.swagger.model.core.Season;
import io.swagger.model.core.SeasonListResponse;
import io.swagger.model.core.SeasonListResponseResult;
import io.swagger.model.core.SeasonSingleResponse;
import io.swagger.api.core.SeasonsApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.core.SeasonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class SeasonsApiController extends BrAPIController implements SeasonsApi {

	private static final Logger log = LoggerFactory.getLogger(SeasonsApiController.class);

	private final HttpServletRequest request;
	private final SeasonService seasonService;

	@org.springframework.beans.factory.annotation.Autowired
	public SeasonsApiController(SeasonService seasonService, HttpServletRequest request) {
		this.seasonService = seasonService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeasonListResponse> seasonsGet(
			@Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@Valid @RequestParam(value = "season", required = false) String season,
			@Valid @RequestParam(value = "year", required = false) Integer year,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Season> data = seasonService.findSeasons(seasonDbId, season, year, metadata);
		return responseOK(new SeasonListResponse(), new SeasonListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeasonListResponse> seasonsPost(@Valid @RequestBody List<Season> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Season> data = seasonService.saveSeasons(body);
		return responseOK(new SeasonListResponse(), new SeasonListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeasonSingleResponse> seasonsSeasonDbIdGet(
			@PathVariable("seasonDbId") String seasonDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Season data = seasonService.getSeason(seasonDbId);
		return responseOK(new SeasonSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeasonSingleResponse> seasonsSeasonDbIdPut(
			@PathVariable("seasonDbId") String seasonDbId,
			@Valid @RequestBody Season body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Season data = seasonService.updateSeason(seasonDbId, body);
		return responseOK(new SeasonSingleResponse(), data);
	}

}
