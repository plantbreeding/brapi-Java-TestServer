package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Event;
import io.swagger.model.pheno.EventsResponse;
import io.swagger.model.pheno.EventsResponseResult;
import io.swagger.api.pheno.EventsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.pheno.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class EventsApiController extends BrAPIController implements EventsApi {

	private static final Logger log = LoggerFactory.getLogger(EventsApiController.class);

	private final EventService eventService;

	private final HttpServletRequest request;

	@Autowired
	public EventsApiController(EventService eventService, HttpServletRequest request) {
		this.eventService = eventService;
		this.request = request;
	}

	public ResponseEntity<EventsResponse> eventsGet(
			@Valid @RequestParam(value = "eventDbId", required = false) String eventDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@Valid @RequestParam(value = "eventType", required = false) String eventType,
			@Valid @RequestParam(value = "dateRangeStart", required = false) String dateRangeStart,
			@Valid @RequestParam(value = "dateRangeEnd", required = false) String dateRangeEnd,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Event> data = eventService.findEvents(eventDbId, studyDbId, observationUnitDbId, eventType,
				DateUtility.toOffsetDateTime(dateRangeStart), DateUtility.toOffsetDateTime(dateRangeEnd), metadata);
		return responseOK(new EventsResponse(), new EventsResponseResult(), data, metadata);
	}

}
