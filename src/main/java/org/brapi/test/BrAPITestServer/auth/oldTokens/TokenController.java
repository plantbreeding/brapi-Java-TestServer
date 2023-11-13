package org.brapi.test.BrAPITestServer.auth.oldTokens;

import io.swagger.model.core.ServerInfoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class TokenController extends BrAPIController {

	private static final Logger log = LoggerFactory.getLogger(TokenController.class);

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public TokenController(HttpServletRequest request) {
		this.request = request;
	}

	@ApiOperation(value = "Get the list of implemented Calls", nickname = "tokenPost", response = ServerInfoResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Server Info", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ServerInfoResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/token", produces = { "application/json" }, method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<TokenResponse> tokenPost(@RequestBody TokenRequest body)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		
		return new ResponseEntity<TokenResponse>(new TokenResponse(), HttpStatus.OK);
	}

	private class TokenResponse{
		@JsonProperty("access_token")
		private final String accessToken = "YYYY";
	}
}
