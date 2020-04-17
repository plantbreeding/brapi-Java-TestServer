package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.List;
import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationEntity;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.springframework.stereotype.Service;

import io.swagger.model.pheno.Observation;
import io.swagger.model.pheno.ObservationNewRequest;

@Service
public class ObservationService {

	public ObservationEntity getObservationEntity(String observationDbId) {
		// TODO Auto-generated method stub
		return null;
	}


	public Observation convertFromEntity(ObservationEntity entity) {
		Observation unit = new Observation();
		unit.setGermplasmDbId(entity.getObservationUnit().getGermplasm().getId());
		unit.setGermplasmName(entity.getObservationUnit().getGermplasm().getGermplasmName());
		unit.setObservationDbId(entity.getId());
//		unit.setObservationLevel(entity.getObservationUnit().getObservationLevel());
		unit.setObservationTimeStamp(DateUtility.toOffsetDateTime(entity.getObservationTimeStamp()));
		unit.setObservationUnitDbId(entity.getObservationUnit().getId());
		unit.setObservationUnitName(entity.getObservationUnit().getObservationUnitName());
		if (entity.getObservationVariable() != null) {
			unit.setObservationVariableDbId(entity.getObservationVariable().getId());
			unit.setObservationVariableName(entity.getObservationVariable().getName());
		}
//		unit.setOperator(entity.getObservationUnit().getOperator());
		unit.setStudyDbId(entity.getObservationUnit().getStudy().getId());
//		unit.setSeason(convertFromEntity(entity.getSeason()));
		unit.setValue(entity.getValue());

		return unit;
	}

	public Observation saveObservations(String studyDbId, @Valid List<ObservationNewRequest> newObservations) {
		//TODO
		return null;
	}

	private void updateEntity(ObservationEntity entity, ObservationNewRequest obs) {
//		entity.setCollector(obs.getCollector());
//		entity.setObservationTimeStamp(DateUtility.toDate(obs.getObservationTimeStamp()));
//		entity.setValue(obs.getValue());
//
//		if (entity.getObservationVariable() == null
//				|| entity.getObservationVariable().getId() != obs.getObservationVariableDbId()) {
//			ObservationVariableEntity observationVariable = observationVariableService
//					.getVariableEntity(obs.getObservationVariableDbId());
//			entity.setObservationVariable(observationVariable);
//		}
//
//		entity.setSeason(seasonRepository.findById("1").get());

	}
}
