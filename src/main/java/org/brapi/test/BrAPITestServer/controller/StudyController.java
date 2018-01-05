package org.brapi.test.BrAPITestServer.controller;

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
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
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
	public GenericResults<GenericResultsDataList<Season>> getSeasons(
			@RequestParam(required=false) Integer year,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Season> seasons = studyService.getSeasons(year, metaData);
		return GenericResults.withList(seasons).withMetaData(metaData);
	}
	
	//TODO path lowercase
	@RequestMapping(value="studyTypes", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<StudyType>> getStudyTypes(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<StudyType> studyTypes = studyService.getStudyTypes(metaData);
		return GenericResults.withList(studyTypes).withMetaData(metaData);
	}
	
	@RequestMapping(value="studies-search", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<StudySummary>> getStudies(
			@RequestParam(required=false) String studyType,
			@RequestParam(required=false) String programDbId,
			@RequestParam(required=false) String locationDbId,
			@RequestParam(required=false) String seasonDbId,
			@RequestParam(required=false) List<String> germplasmDbIds,
			@RequestParam(required=false) List<String> observationVariableDbIds,
			@RequestParam(required=false) boolean active,
			@RequestParam(defaultValue="studyName") String sortBy,
			@RequestParam(defaultValue="asc") String sortOrder,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<StudySummary> studies = studyService.getStudies(studyType, programDbId, locationDbId, seasonDbId, germplasmDbIds, observationVariableDbIds, active, sortBy, sortOrder, metaData);
		return GenericResults.withList(studies).withMetaData(metaData);
	}	
	
	@RequestMapping(value="studies-search", method= {RequestMethod.POST})
	public GenericResults<GenericResultsDataList<StudySummary>> getStudies(
			@RequestBody StudySearchRequest request) {
		MetaData metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<StudySummary> studies = studyService.getStudies(request, metaData);
		return GenericResults.withList(studies).withMetaData(metaData);
	}

	@RequestMapping(value="studies/{studyDbId}", method= {RequestMethod.GET})
	public GenericResults<Study> getStudy(
			@PathVariable(value="studyDbId") String studyDbId) {
		Study study = studyService.getStudy(studyDbId);
		return GenericResults.withObject(study).withMetaData(generateEmptyMetadata());
	}
	
	@RequestMapping(value="studies/{studyDbId}/observationVariables", method= {RequestMethod.GET})
	public GenericResults<StudyObservationVariable> getStudyObservationVariables(
			@PathVariable(value="studyDbId") String studyDbId) {
		StudyObservationVariable variables = studyService.getStudyObservationVariables(studyDbId);
		return GenericResults.withObject(variables).withMetaData(generateEmptyMetadata());
	}
	
	@RequestMapping(value="studies/{studyDbId}/germplasm", method= {RequestMethod.GET})
	public GenericResults<StudyGermplasm> getStudyGermplasm(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		StudyGermplasm germplasms = studyService.getStudyGermplasm(studyDbId, metaData);
		return GenericResults.withObject(germplasms).withMetaData(generateEmptyMetadata());
	}

	//TODO path lowercase
	@RequestMapping(value="observationLevels", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<String>> getObservationLevels(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<String> levels = studyService.getObservationLevels(metaData);
		return GenericResults.withList(levels).withMetaData(metaData);
	}

	@RequestMapping(value="studies/{studyDbId}/observationunits", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<StudyObservation>> getObservationLevels(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(required=false) String observationLevel,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<StudyObservation> observations = studyService.getStudyObservations(studyDbId, observationLevel, metaData);
		return GenericResults.withList(observations).withMetaData(metaData);
	}
	
	//TODO should be PUT not POST
	@RequestMapping(value="studies/{studyDbId}/observationunits", method= {RequestMethod.POST})
	public void postObservationUnit(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestBody StudyObservationUnitRequest request){
		studyService.saveObservationUnits(request);
	}
	

	@RequestMapping(value="studies/{studyDbId}/table", method= {RequestMethod.GET})
	public GenericResults<StudyObservationUnitTable> getStudyObservationUnitTable(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(required=false) String format){
		StudyObservationUnitTable table = studyService.getStudyObservationUnitTable(studyDbId, format);
		
		return GenericResults.withObject(table).withMetaData(generateEmptyMetadata());
	}
	
	//TODO should be PUT not POST
	@RequestMapping(value="studies/{studyDbId}/table", method= {RequestMethod.POST})
	public void postStudyObservationUnitTable(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestBody GenericResults<StudyObservationUnitTable> request){
		studyService.saveStudyObservationUnitTable(request.getResults());
	}
	
	@RequestMapping(value="studies/{studyDbId}/layout", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<StudyPlotLayout>> getStudyPlotLayouts(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<StudyPlotLayout> layouts = studyService.getStudyPlotLayouts(studyDbId, metaData);
		
		return GenericResults.withList(layouts).withMetaData(metaData);
	}
	
	@RequestMapping(value="studies/{studyDbId}/observations", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<ObservationUnit>> getObservationUnits(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(required=false) List<String> observationVariableDbIds,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {

		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnit> units = studyService.getObservationUnits(studyDbId, observationVariableDbIds, metaData);
		
		return GenericResults.withList(units).withMetaData(metaData);
	}
}
