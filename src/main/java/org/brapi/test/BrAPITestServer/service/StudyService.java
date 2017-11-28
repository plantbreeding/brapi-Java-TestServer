package org.brapi.test.BrAPITestServer.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyAddtionalInfoEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.brapi.test.BrAPITestServer.model.rest.DataLink;
import org.brapi.test.BrAPITestServer.model.rest.ObservationUnit;
import org.brapi.test.BrAPITestServer.model.rest.ObservationVariable;
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
import org.brapi.test.BrAPITestServer.model.rest.Update;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.ObservationVariableRepository;
import org.brapi.test.BrAPITestServer.repository.SeasonRepository;
import org.brapi.test.BrAPITestServer.repository.StudyRepository;
import org.brapi.test.BrAPITestServer.repository.StudyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class StudyService {
	private SeasonRepository seasonRepository;
	private StudyTypeRepository studyTypeRepository;
	private StudyRepository studyRepository;
	private ObservationVariableService observationVariableService;
	private LocationService locationService;
	private ContactService contactService;

	@Autowired
	public StudyService(SeasonRepository seasonRepository, StudyTypeRepository studyTypeRepository,
			StudyRepository studyRepository, ObservationVariableService observationVariableService, LocationService locationService, ContactService contactService) {
		this.seasonRepository = seasonRepository;
		this.studyTypeRepository = studyTypeRepository;
		this.studyRepository = studyRepository;
		this.observationVariableService = observationVariableService;
		
		this.locationService = locationService;
		this.contactService = contactService;
	}

	public List<Season> getSeasons(int year, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<Season> seasons = seasonRepository.findAllByYear(year, pageReq).map((entity) -> {
			Season season = new Season();
			season.setSeason(entity.getSeason());
			season.setSeasonDbId(entity.getId());
			season.setYear(entity.getYear());
			return season;
		}).getContent();
		metaData.getPagination().setTotalCount((int) seasonRepository.countByYear(year));
		PagingUtility.calculateMetaData(metaData);
		return seasons;
	}

	public List<StudyType> getStudyTypes(MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<StudyType> studyTypes = studyTypeRepository.findAll(pageReq).map((entity) -> {
			StudyType studyType = new StudyType();
			studyType.setDescription(entity.getDescription());
			studyType.setName(entity.getName());
			return studyType;
		}).getContent();
		metaData.getPagination().setTotalCount((int) studyTypeRepository.count());
		PagingUtility.calculateMetaData(metaData);
		return studyTypes;
	}

	public List<StudySummary> getStudies(String studyType, String programDbId, String locationDbId, String seasonDbId,
			List<String> germplasmDbIds, List<String> observationVariableDbIds, boolean active, String sortBy,
			String sortOrder, MetaData metaData) {

		return searchStudies(buildSearchParam(studyType), 
				buildSearchParam(programDbId), 
				buildSearchParam(null), 
				buildSearchParam(null),
				buildSearchParam(null), 
				buildSearchParam(locationDbId), 
				buildSearchParam(seasonDbId),
				buildSearchParamList(germplasmDbIds), 
				buildSearchParamList(observationVariableDbIds), 
				active, sortBy,	sortOrder, metaData);
	}

	private List<String> buildSearchParam(String param) {
		List<String> paramList = new ArrayList<>();
		if (param == null) {
			paramList.add("");
		} else {
			paramList.add(param);
		}
		return paramList;
	}

	private List<String> buildSearchParamList(List<String> params) {
		List<String> paramList = new ArrayList<>();
		if (params == null || params.isEmpty()) {
			paramList.add("");
		} else {
			paramList = params;
		}
		return paramList;
	}

	public List<StudySummary> getStudies(StudySearchRequest request, MetaData metaData) {
		return searchStudies(buildSearchParam(request.getStudyType()), 
				buildSearchParamList(null), 
				buildSearchParamList(request.getProgramNames()), 
				buildSearchParamList(request.getStudyNames()),
				buildSearchParamList(request.getStudyLocations()), 
				buildSearchParamList(null), 
				buildSearchParamList(null),
				buildSearchParamList(request.getGermplasmDbIds()), 
				buildSearchParamList(request.getObservationVariableDbIds()),
				request.isActive(), request.getSortBy(), request.getSortOrder(), metaData);
	}

	private List<StudySummary> searchStudies(List<String> studyTypes, List<String> programDbIds, List<String> programNames,
			List<String> studyNames, List<String> studyLocations, List<String> locationDbIds, List<String> seasonDbIds,
			List<String> germplasmDbIds, List<String> observationVariableDbIds, boolean active, String sortBy,
			String sortOrder, MetaData metaData) {
		Sort sort = Sort.by(Direction.fromString(sortOrder), sortBy);
		Pageable pageReq = PagingUtility.getPageRequest(metaData, sort);
		List<StudySummary> summaries = studyRepository.findBySearch(studyTypes, programDbIds, programNames, studyNames,
				studyLocations, locationDbIds, seasonDbIds, germplasmDbIds, observationVariableDbIds, active, pageReq)
				.map((entity) -> {
					StudySummary sum = new StudySummary();
					sum.setActive(entity.isActive());
					sum.setEndDate(entity.getEndDate());
					sum.setLocationDbId(entity.getLocation().getId());
					sum.setLocationName(entity.getLocation().getName());
					sum.setName(entity.getStudyName());
					sum.setProgramDbId(entity.getTrial().getProgram().getId());
					sum.setProgramName(entity.getTrial().getProgram().getName());
					sum.setStartDate(entity.getStartDate());
					sum.setStudyDbId(entity.getId());
					sum.setStudyType(entity.getStudyType().getName());
					sum.setTrialDbId(entity.getTrial().getId());
					sum.setTrialName(entity.getTrial().getTrialName());
					
					sum.setSeasons(entity.getSeasons().stream().map( e -> { return e.getSeason() + " " + e.getYear();}).collect(Collectors.toList()));
					
					sum.setAdditionalInfo(new HashMap<>());
					for(StudyAddtionalInfoEntity e : entity.getAdditionalInfo()) {
						sum.getAdditionalInfo().put(e.getKey(), e.getValue());
					}
					
					return sum;
				}).getContent();
		return summaries;
	}

	public Study getStudy(String studyDbId) {
		Optional<StudyEntity> entityOption = studyRepository.findById(studyDbId);
		Study study = null;
		if(entityOption.isPresent()) {
			StudyEntity entity = entityOption.get();
			study = new Study();
			
			study.setActive(entity.isActive());
			study.setEndDate(entity.getEndDate());
			study.setStartDate(entity.getStartDate());
			study.setStudyDbId(entity.getId());
			study.setStudyType(entity.getStudyType().getName());
			study.setTrialDbId(entity.getTrial().getId());
			study.setTrialName(entity.getTrial().getTrialName());
			study.setLicense(entity.getLicense());
			study.setLocation(locationService.convertFromEntity(entity.getLocation()));
			study.setStudyDescription(entity.getStudyDescription());
			study.setStudyName(entity.getStudyName());

			study.setLastUpdate(new Update());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			study.getLastUpdate().setTimestamp(sdf.format(entity.getTimestamp()));
			study.getLastUpdate().setVersion(entity.getVersion());
			
			study.setContacts(entity.getContacts().stream().map(this.contactService::convertFromEntity).collect(Collectors.toList()));
			
			study.setDataLinks(entity.getDataLinks().stream().map(e -> {
				DataLink dataLink = new DataLink();
				dataLink.setName(e.getName());
				dataLink.setType(e.getType());
				dataLink.setUrl(e.getUrl());
				return dataLink;
			}).collect(Collectors.toList()));
			
			study.setSeasons(entity.getSeasons().stream().map( e -> { return e.getSeason() + " " + e.getYear();}).collect(Collectors.toList()));
			
			study.setAdditionalInfo(new HashMap<>());
			for(StudyAddtionalInfoEntity e : entity.getAdditionalInfo()) {
				study.getAdditionalInfo().put(e.getKey(), e.getValue());
			}
		}
		return study;
	}

	public StudyObservationVariable getStudyObservationVariables(String studyDbId) {
		StudyObservationVariable wrapper = new StudyObservationVariable();
		wrapper.setData(observationVariableService.getVariablesForStudy(studyDbId));
		Study study = getStudy(studyDbId);
		wrapper.setStudyDbId(study.getStudyDbId());
		wrapper.setTrialName(study.getTrialName());
		return wrapper;
	}

	public StudyGermplasm getStudyGermplasm(String studyDbId, MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getObservationLevels(MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudyObservation> getStudyObservations(String studyDbId, String observationLevel, MetaData metaData) {
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

	public List<StudyPlotLayout> getStudyPlotLayouts(String studyDbId, MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ObservationUnit> getObservationUnits(String studyDbId, List<String> observationVariableDbIds,
			MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

}
