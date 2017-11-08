package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.ObservationUnit;
import org.brapi.test.BrAPITestServer.model.rest.Season;
import org.brapi.test.BrAPITestServer.model.rest.Study;
import org.brapi.test.BrAPITestServer.model.rest.StudyGermplasm;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservation;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservationUnitRequest;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservationUnitTable;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservationVariable;
import org.brapi.test.BrAPITestServer.model.rest.StudyPlotLayout;
import org.brapi.test.BrAPITestServer.model.rest.StudySearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.StudySummary;
import org.brapi.test.BrAPITestServer.model.rest.StudyType;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.springframework.stereotype.Service;

@Service
public class StudyService {

	public List<Season> getSeasons(int year, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudyType> getStudyTypes(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudySummary> getStudies(String studyType, String programDbId, String locationDbId, String seasonDbId,
			List<String> germplasmDbIds, List<String> observationVariableDbIds, boolean active, String sortBy,
			String sortOrder, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudySummary> getStudies(StudySearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public Study getStudy(String studyDbId) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudyObservationVariable getStudyObservationVariables(String studyDbId) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudyGermplasm getStudyGermplasm(String studyDbId, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getObservationLevels(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudyObservation> getStudyObservations(String studyDbId, String observationLevel, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveObservationUnits(StudyObservationUnitRequest request) {
		// TODO Auto-generated method stub
		
	}

	public StudyObservationUnitTable getStudyObservationUnitTable(String studyDbId, String format) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveStudyObservationUnitTable(GenericResults<StudyObservationUnitTable> request) {
		// TODO Auto-generated method stub
		
	}

	public List<StudyPlotLayout> getStudyPlotLayouts(String studyDbId, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ObservationUnit> getObservationUnits(String studyDbId, List<String> observationVariableDbIds, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
