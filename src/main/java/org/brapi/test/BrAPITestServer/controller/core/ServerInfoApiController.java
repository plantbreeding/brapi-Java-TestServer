package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.core.ServerInfoResponse;
import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.core.ServerInfo;
import io.swagger.api.core.ServerInfoApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.core.ServerInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class ServerInfoApiController extends BrAPIController implements ServerInfoApi {

	private static final Logger log = LoggerFactory.getLogger(ServerInfoApiController.class);

	private final ServerInfoService serverInfoService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public ServerInfoApiController(ServerInfoService serverInfoService, HttpServletRequest request) {
		this.serverInfoService = serverInfoService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ServerInfoResponse> serverinfoGet(
			@Valid @RequestParam(value = "dataType", required = false) WSMIMEDataTypes dataType,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ServerInfo data = serverInfoService.getServerInfo(dataType);
		return responseOK(new ServerInfoResponse(), data);
	}

}
