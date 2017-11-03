package org.brapi.test.BrAPITestServer.controller;

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
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyController  extends BrAPIController{

	private StudyService studyService;
	
	@Autowired
	public StudyController(StudyService studyService) {
		this.studyService = studyService;
	}
	
	@RequestMapping(value="seasons", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<Season>> getSeasons(
			@RequestParam int year,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<Season> seasons = studyService.getSeasons(year, page, pageSize);
		return SearchResults.withList(seasons).withMetaData(mockMetaData(page, pageSize));
	}
	
	//TODO path lowercase
	@RequestMapping(value="studyTypes", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<StudyType>> getStudyTypes(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<StudyType> studyTypes = studyService.getStudyTypes(page, pageSize);
		return SearchResults.withList(studyTypes).withMetaData(mockMetaData(page, pageSize));
	}
	
	@RequestMapping(value="studies-search", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<StudySummary>> getStudies(
			@RequestParam String studyType,
			@RequestParam String programDbId,
			@RequestParam String locationDbId,
			@RequestParam String seasonDbId,
			@RequestParam List<String> germplasmDbIds,
			@RequestParam List<String> observationVariableDbIds,
			@RequestParam boolean active,
			@RequestParam String sortBy,
			@RequestParam String sortOrder,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<StudySummary> studies = studyService.getStudies(studyType, programDbId, locationDbId, seasonDbId, germplasmDbIds, observationVariableDbIds, active, sortBy, sortOrder, page, pageSize);
		return SearchResults.withList(studies).withMetaData(mockMetaData(page, pageSize));
	}	
	
	@RequestMapping(value="studies-search", method= {RequestMethod.POST})
	public SearchResults<SearchResultsList<StudySummary>> getStudies(
			@RequestBody StudySearchRequest request) {
		List<StudySummary> studies = studyService.getStudies(request);
		return SearchResults.withList(studies).withMetaData(mockMetaData(request.getPage(), request.getPageSize()));
	}

	@RequestMapping(value="studies/{studyDbId}", method= {RequestMethod.GET})
	public SearchResults<Study> getStudy(
			@PathVariable(value="studyDbId") String studyDbId) {
		Study study = studyService.getStudy(studyDbId);
		return SearchResults.withObject(study).withMetaData(mockEmptyMetadata());
	}
	
	@RequestMapping(value="studies/{studyDbId}/observationVariables", method= {RequestMethod.GET})
	public SearchResults<StudyObservationVariable> getStudyObservationVariables(
			@PathVariable(value="studyDbId") String studyDbId) {
		StudyObservationVariable variables = studyService.getStudyObservationVariables(studyDbId);
		return SearchResults.withObject(variables).withMetaData(mockEmptyMetadata());
	}
	
	@RequestMapping(value="studies/{studyDbId}/germplasm", method= {RequestMethod.GET})
	public SearchResults<StudyGermplasm> getStudyGermplasm(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		StudyGermplasm germplasms = studyService.getStudyGermplasm(studyDbId, page, pageSize);
		return SearchResults.withObject(germplasms).withMetaData(mockEmptyMetadata());
	}

	//TODO path lowercase
	@RequestMapping(value="observationLevels", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<String>> getObservationLevels(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<String> levels = studyService.getObservationLevels(page, pageSize);
		return SearchResults.withList(levels).withMetaData(mockMetaData(page, pageSize));
	}

	@RequestMapping(value="studies/{studyDbId}/observationunits", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<StudyObservation>> getObservationLevels(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam String observationLevel,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<StudyObservation> observations = studyService.getStudyObservations(studyDbId, observationLevel, page, pageSize);
		return SearchResults.withList(observations).withMetaData(mockMetaData(page, pageSize));
	}
	
	//TODO should be PUT not POST
	@RequestMapping(value="studies/{studyDbId}/observationunits", method= {RequestMethod.POST})
	public void postObservationUnit(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestBody StudyObservationUnitRequest request){
		studyService.saveObservationUnits(request);
	}
	

	@RequestMapping(value="studies/{studyDbId}/table", method= {RequestMethod.GET})
	public SearchResults<StudyObservationUnitTable> getStudyObservationUnitTable(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam String format){
		StudyObservationUnitTable table = studyService.getStudyObservationUnitTable(studyDbId, format);
		
		return SearchResults.withObject(table).withMetaData(mockEmptyMetadata());
	}
	
	//TODO should be PUT not POST
	@RequestMapping(value="studies/{studyDbId}/table", method= {RequestMethod.POST})
	public void postStudyObservationUnitTable(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestBody SearchResults<StudyObservationUnitTable> request){
		studyService.saveStudyObservationUnitTable(request);
	}
	
	@RequestMapping(value="studies/{studyDbId}/layout", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<StudyPlotLayout>> getStudyPlotLayouts(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<StudyPlotLayout> layouts = studyService.getStudyPlotLayouts(studyDbId, page, pageSize);
		
		return SearchResults.withList(layouts).withMetaData(mockMetaData(page, pageSize));
	}
	
	@RequestMapping(value="studies/{studyDbId}/observations", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<ObservationUnit>> getObservationUnits(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam List<String> observationVariableDbIds,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		
		List<ObservationUnit> units = studyService.getObservationUnits(studyDbId, observationVariableDbIds, page, pageSize);
		
		return SearchResults.withList(units).withMetaData(mockMetaData(page, pageSize));
	}
}
