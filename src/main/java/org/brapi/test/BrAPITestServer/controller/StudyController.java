package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.ObservationUnit;
import org.brapi.test.BrAPITestServer.model.rest.ObservationUnitDbIdListWrapper;
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
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaDataStatus;
import org.brapi.test.BrAPITestServer.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin
	@RequestMapping(value="seasons", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<Season>> getSeasons(
			@RequestParam(required=false) Integer year,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Season> seasons = studyService.getSeasons(year, metaData);
		return GenericResults.withList(seasons).withMetaData(metaData);
	}
	
	//Deprecated
	@CrossOrigin
	@RequestMapping(value="studyTypes", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<StudyType>> getStudyTypes_dep(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<StudyType> studyTypes = studyService.getStudyTypes(metaData);
		return GenericResults.withList(studyTypes).withMetaData(metaData);
	}
	
	@CrossOrigin
	@RequestMapping(value="studytypes", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<StudyType>> getStudyTypes(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<StudyType> studyTypes = studyService.getStudyTypes(metaData);
		return GenericResults.withList(studyTypes).withMetaData(metaData);
	}
	
	@CrossOrigin
	@RequestMapping(value="studies-search", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<StudySummary>> getStudies(
			@RequestParam(required=false) String studyType,
			@RequestParam(required=false) String programDbId,
			@RequestParam(required=false) String trialDbId,
			@RequestParam(required=false) String locationDbId,
			@RequestParam(required=false) String seasonDbId,
			@RequestParam(required=false) List<String> germplasmDbIds,
			@RequestParam(required=false) List<String> observationVariableDbIds,
			@RequestParam(required=false, defaultValue="true") boolean active,
			@RequestParam(defaultValue="studyName") String sortBy,
			@RequestParam(defaultValue="asc") String sortOrder,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<StudySummary> studies = studyService.getStudies(studyType, programDbId, trialDbId, locationDbId, seasonDbId, germplasmDbIds, observationVariableDbIds, active, sortBy, sortOrder, metaData);
		return GenericResults.withList(studies).withMetaData(metaData);
	}	
	
	@CrossOrigin
	@RequestMapping(value="studies-search", method= {RequestMethod.POST})
	public GenericResults<GenericResultsDataList<StudySummary>> getStudies(
			@RequestBody StudySearchRequest request) {
		MetaData metaData = generateMetaDataTemplate(request);
		List<StudySummary> studies = studyService.getStudies(request, metaData);
		return GenericResults.withList(studies).withMetaData(metaData);
	}

	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}", method= {RequestMethod.GET})
	public GenericResults<Study> getStudy(
			@PathVariable(value="studyDbId") String studyDbId) {
		Study study = studyService.getStudy(studyDbId);
		return GenericResults.withObject(study).withMetaData(generateEmptyMetadata());
	}

	//Deprecated
	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/observationVariables", method= {RequestMethod.GET})
	public GenericResults<StudyObservationVariable> getStudyObservationVariables_dep(
			@PathVariable(value="studyDbId") String studyDbId) {
		StudyObservationVariable variables = studyService.getStudyObservationVariables(studyDbId);
		return GenericResults.withObject(variables).withMetaData(generateEmptyMetadata());
	}
	
	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/observationvariables", method= {RequestMethod.GET})
	public GenericResults<StudyObservationVariable> getStudyObservationVariables(
			@PathVariable(value="studyDbId") String studyDbId) {
		StudyObservationVariable variables = studyService.getStudyObservationVariables(studyDbId);
		return GenericResults.withObject(variables).withMetaData(generateEmptyMetadata());
	}
	
	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/germplasm", method= {RequestMethod.GET})
	public GenericResults<StudyGermplasm> getStudyGermplasm(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		StudyGermplasm germplasms = studyService.getStudyGermplasm(studyDbId, metaData);
		return GenericResults.withObject(germplasms).withMetaData(generateEmptyMetadata());
	}

	//Deprecated
	@CrossOrigin
	@RequestMapping(value="observationLevels", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<String>> getObservationLevels_dep(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<String> levels = studyService.getObservationLevels(metaData);
		return GenericResults.withList(levels).withMetaData(metaData);
	}
	
	@CrossOrigin
	@RequestMapping(value="observationlevels", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<String>> getObservationLevels(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<String> levels = studyService.getObservationLevels(metaData);
		return GenericResults.withList(levels).withMetaData(metaData);
	}

	@CrossOrigin
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

	//Deprecated
	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/observationunits", method= {RequestMethod.POST})
	@PreAuthorize("hasAuthority('ADMIN')")
	public void postObservationUnit_dep(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestBody StudyObservationUnitRequest request){
		studyService.saveObservationUnits(request);
	}

	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/observationunits", method= {RequestMethod.PUT})
	@PreAuthorize("hasAuthority('ADMIN')")
	public GenericResults<ObservationUnitDbIdListWrapper> postObservationUnit(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestBody StudyObservationUnitRequest request){
		ObservationUnitDbIdListWrapper storedUnits = studyService.saveObservationUnits(request);
		MetaData metadata = generateEmptyMetadata();
		metadata.getStatus().add(new MetaDataStatus("200", "Upload Successful"));
		return GenericResults.withObject(storedUnits).withMetaData(metadata);
	}
	
	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/observationunits/zip", method= {RequestMethod.PUT})
	@PreAuthorize("hasAuthority('ADMIN')")
	public GenericResults<ObservationUnitDbIdListWrapper> postObservationUnitZip(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestBody StudyObservationUnitRequest request){
		//TODO read Zip file data
		ObservationUnitDbIdListWrapper storedUnits = studyService.saveObservationUnits(request);
		MetaData metadata = generateEmptyMetadata();
		metadata.getStatus().add(new MetaDataStatus("200", "Upload Successful"));
		return GenericResults.withObject(storedUnits).withMetaData(metadata);
	}
	

	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/table", method= {RequestMethod.GET})
	public GenericResults<StudyObservationUnitTable> getStudyObservationUnitTable(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(required=false) String format){
		StudyObservationUnitTable table = studyService.getStudyObservationUnitTable(studyDbId, format);
		
		return GenericResults.withObject(table).withMetaData(generateEmptyMetadata());
	}
	
	//TODO should be PUT not POST
	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/table", method= {RequestMethod.POST})
	@PreAuthorize("hasAuthority('ADMIN')")
	public void postStudyObservationUnitTable(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestBody GenericResults<StudyObservationUnitTable> request){
		studyService.saveStudyObservationUnitTable(request.getResult());
	}
	
	@CrossOrigin
	@RequestMapping(value="studies/{studyDbId}/layout", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<StudyPlotLayout>> getStudyPlotLayouts(
			@PathVariable(value="studyDbId") String studyDbId,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<StudyPlotLayout> layouts = studyService.getStudyPlotLayouts(studyDbId, metaData);
		
		return GenericResults.withList(layouts).withMetaData(metaData);
	}
	
	@CrossOrigin
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
