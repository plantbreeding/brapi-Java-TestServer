package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossingProjectEntity;
import org.brapi.test.BrAPITestServer.repository.germ.CrossingProjectRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.core.ProgramService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.CrossingProject;
import io.swagger.model.germ.CrossingProjectNewRequest;

@Service
public class CrossingProjectService {

	private final CrossingProjectRepository crossingProjectRepository;
	private final ProgramService programService;

	public CrossingProjectService(CrossingProjectRepository crossingProjectRepository, ProgramService programService) {
		this.crossingProjectRepository = crossingProjectRepository;
		this.programService = programService;
	}

	public List<CrossingProject> findCrossingProjects(@Valid String crossingProjectDbId,
			@Valid String externalReferenceID, @Valid String externalReferenceSource, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<CrossingProjectEntity> searchQuery = new SearchQueryBuilder<CrossingProjectEntity>(
				CrossingProjectEntity.class);

		if (crossingProjectDbId != null)
			searchQuery = searchQuery.appendSingle(crossingProjectDbId, "id");
		if (externalReferenceID != null && externalReferenceSource != null)
			searchQuery = searchQuery.withExRefs(Arrays.asList(externalReferenceID),
					Arrays.asList(externalReferenceSource));

		Page<CrossingProjectEntity> page = crossingProjectRepository.findAllBySearch(searchQuery, pageReq);
		List<CrossingProject> crossingProjects = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return crossingProjects;
	}

	public CrossingProject getCrossingProject(String crossingProjectDbId) throws BrAPIServerException {
		return convertFromEntity(getCrossingProjectEntity(crossingProjectDbId, HttpStatus.NOT_FOUND));
	}

	public CrossingProjectEntity getCrossingProjectEntity(String crossingProjectDbId) throws BrAPIServerException {
		return getCrossingProjectEntity(crossingProjectDbId, HttpStatus.BAD_REQUEST);
	}

	public CrossingProjectEntity getCrossingProjectEntity(String crossingProjectDbId, HttpStatus errorStatus) throws BrAPIServerException {
		CrossingProjectEntity crossingProject = null;
		Optional<CrossingProjectEntity> entityOpt = crossingProjectRepository.findById(crossingProjectDbId);
		if (entityOpt.isPresent()) {
			crossingProject = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("crossing project", crossingProjectDbId);
		}
		return crossingProject;
	}

	public List<CrossingProject> saveCrossingProjects(@Valid List<CrossingProjectNewRequest> body)
			throws BrAPIServerException {
		List<CrossingProject> savedValues = new ArrayList<>();

		for (CrossingProjectNewRequest list : body) {

			CrossingProjectEntity entity = new CrossingProjectEntity();
			updateEntity(entity, list);

			CrossingProjectEntity savedEntity = crossingProjectRepository.save(entity);

			savedValues.add(convertFromEntity(savedEntity));
		}

		return savedValues;
	}

	public CrossingProject updateCrossingProject(String crossingProjectDbId, @Valid CrossingProjectNewRequest body)
			throws BrAPIServerException {
		CrossingProjectEntity savedEntity;
		Optional<CrossingProjectEntity> entityOpt = crossingProjectRepository.findById(crossingProjectDbId);
		if (entityOpt.isPresent()) {
			CrossingProjectEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = crossingProjectRepository.save(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("crossing project", crossingProjectDbId);
		}

		return convertFromEntity(savedEntity);
	}

	private CrossingProject convertFromEntity(CrossingProjectEntity entity) {
		CrossingProject project = new CrossingProject();
		project.setAdditionalInfo(entity.getAdditionalInfoMap());
		project.setCrossingProjectDbId(entity.getId());
		project.setCrossingProjectDescription(entity.getDescription());
		project.setCrossingProjectName(entity.getName());
		project.setExternalReferences(entity.getExternalReferencesMap());
		if (entity.getProgram() != null) {
			project.setProgramDbId(entity.getProgram().getId());
			project.setProgramName(entity.getProgram().getName());
			if (entity.getProgram().getCrop() != null) {
				project.setCommonCropName(entity.getProgram().getCrop().getCropName());
			}
		}
		return project;
	}

	private void updateEntity(CrossingProjectEntity entity, CrossingProjectNewRequest project)
			throws BrAPIServerException {
		if (project.getAdditionalInfo() != null)
			entity.setAdditionalInfo(project.getAdditionalInfo());
		if (project.getCrossingProjectDescription() != null)
			entity.setDescription(project.getCrossingProjectDescription());
		if (project.getCrossingProjectName() != null)
			entity.setName(project.getCrossingProjectName());
		if (project.getExternalReferences() != null)
			entity.setExternalReferences(project.getExternalReferences());
		if (project.getProgramDbId() != null) {
			ProgramEntity program = programService.getProgramEntity(project.getProgramDbId());
			entity.setProgram(program);
		}

	}

}
