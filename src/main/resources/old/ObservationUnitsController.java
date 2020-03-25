package org.brapi.test.BrAPITestServer.controller.old;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PhenotypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.ObservationunitsApi;
import io.swagger.model.Metadata;
import io.swagger.model.ObservationUnitPhenotype;
import io.swagger.model.ObservationUnitsResponse;
import io.swagger.model.ObservationUnitsResponseResult;

@RestController
public class ObservationUnitsController extends BrAPIController implements ObservationunitsApi {

	private PhenotypeService phenotypeService;
	
	@Autowired
	public ObservationUnitsController(PhenotypeService phenotypeService) {
		this.phenotypeService = phenotypeService;
	}

	@Override
	public ResponseEntity<ObservationUnitsResponse> observationunitsGet(
			@Valid String germplasmDbId,
			@Valid String observationVariableDbId, 
			@Valid String studyDbId, 
			@Valid String locationDbId,
			@Valid String trialDbId, 
			@Valid String programDbId, 
			@Valid String seasonDbId,
			@Valid String observationLevel,
			@Valid String observationTimeStampRangeStart,
			@Valid String observationTimeStampRangeEnd, 
			@Valid Integer page, 
			@Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnitPhenotype> data = phenotypeService.getPhenotypes(germplasmDbId, observationVariableDbId,
				studyDbId, locationDbId, trialDbId, programDbId, seasonDbId, observationLevel,
				DateUtility.toDate(observationTimeStampRangeStart), 
				DateUtility.toDate(observationTimeStampRangeEnd), metaData);

		ObservationUnitsResponseResult result = new ObservationUnitsResponseResult();
		result.setData(data);
		ObservationUnitsResponse response = new ObservationUnitsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationUnitsResponse>(response, HttpStatus.OK);
	}


}
