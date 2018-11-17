package org.brapi.test.BrAPITestServer.controller;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;

import io.swagger.api.ObservationunitsApi;
import io.swagger.model.ObservationUnitsResponse;

@RestController
public class ObservationUnitsController extends BrAPIController implements ObservationunitsApi {

	@Autowired
	public ObservationUnitsController() {
	}

	@Override
	public ResponseEntity<ObservationUnitsResponse> observationunitsGet(@Valid String germplasmDbId,
			@Valid String observationVariableDbId, @Valid String studyDbId, @Valid String locationDbId,
			@Valid String trialDbId, @Valid String programDbId, @Valid String seasonDbId,
			@Valid String observationLevel, @Valid String observationTimeStampRangeStart,
			@Valid String observationTimeStampRangeEnd, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}


}
