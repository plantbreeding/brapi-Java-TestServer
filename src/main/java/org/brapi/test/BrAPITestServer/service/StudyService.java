package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.ObservationUnit;
import org.brapi.test.BrAPITestServer.model.Season;
import org.brapi.test.BrAPITestServer.model.Study;
import org.brapi.test.BrAPITestServer.model.StudyGermplasm;
import org.brapi.test.BrAPITestServer.model.StudyObservation;
import org.brapi.test.BrAPITestServer.model.StudyObservationUnitRequest;
import org.brapi.test.BrAPITestServer.model.StudyObservationUnitTable;
import org.brapi.test.BrAPITestServer.model.StudyObservationVariable;
import org.brapi.test.BrAPITestServer.model.StudyPlotLayout;
import org.brapi.test.BrAPITestServer.model.StudySummary;
import org.brapi.test.BrAPITestServer.model.StudySearchRequest;
import org.brapi.test.BrAPITestServer.model.StudyType;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
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

	public void saveStudyObservationUnitTable(SearchResults<StudyObservationUnitTable> request) {
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
