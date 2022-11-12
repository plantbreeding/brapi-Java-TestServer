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
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
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
	private final CrossParentService crossParentService;

	public CrossingProjectService(CrossingProjectRepository crossingProjectRepository, ProgramService programService,
			CrossParentService crossParentService) {
		this.crossingProjectRepository = crossingProjectRepository;
		this.programService = programService;
		this.crossParentService = crossParentService;
	}

	public List<CrossingProject> findCrossingProjects(String crossingProjectDbId, String crossingProjectName,
			Boolean includePotentialParents, String commonCropName, String programDbId, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);

		SearchQueryBuilder<CrossingProjectEntity> searchQuery = new SearchQueryBuilder<CrossingProjectEntity>(
				CrossingProjectEntity.class);

		if (crossingProjectDbId != null)
			searchQuery = searchQuery.appendSingle(crossingProjectDbId, "id");
		if (crossingProjectName != null)
			searchQuery = searchQuery.appendSingle(crossingProjectName, "name");
		if (commonCropName != null)
			searchQuery = searchQuery.appendSingle(commonCropName, "crop.crop_name");
		if (programDbId != null)
			searchQuery = searchQuery.appendSingle(programDbId, "program.id");
		if (externalReferenceID != null && externalReferenceSource != null)
			searchQuery = searchQuery.withExRefs(Arrays.asList(externalReferenceID),
					Arrays.asList(externalReferenceSource));

		Page<CrossingProjectEntity> page = crossingProjectRepository.findAllBySearch(searchQuery, pageReq);
		List<CrossingProject> crossingProjects = new ArrayList<>();
		for (CrossingProjectEntity entity : page) {
			crossingProjects.add(convertFromEntity(entity, includePotentialParents));
		}
		PagingUtility.calculateMetaData(metadata, page);
		return crossingProjects;
	}

	public CrossingProject getCrossingProject(String crossingProjectDbId) throws BrAPIServerException {
		return convertFromEntity(getCrossingProjectEntity(crossingProjectDbId, HttpStatus.NOT_FOUND));
	}

	public CrossingProjectEntity getCrossingProjectEntity(String crossingProjectDbId) throws BrAPIServerException {
		return getCrossingProjectEntity(crossingProjectDbId, HttpStatus.BAD_REQUEST);
	}

	public CrossingProjectEntity getCrossingProjectEntity(String crossingProjectDbId, HttpStatus errorStatus)
			throws BrAPIServerException {
		CrossingProjectEntity crossingProject = null;
		Optional<CrossingProjectEntity> entityOpt = crossingProjectRepository.findById(crossingProjectDbId);
		if (entityOpt.isPresent()) {
			crossingProject = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("crossing project", crossingProjectDbId, errorStatus);
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

	public CrossingProject updateCrossingProject(String crossingProjectDbId, CrossingProjectNewRequest body)
			throws BrAPIServerException {
		CrossingProjectEntity entity = getCrossingProjectEntity(crossingProjectDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, body);
		CrossingProjectEntity savedEntity = crossingProjectRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	private CrossingProject convertFromEntity(CrossingProjectEntity entity) {
		return convertFromEntity(entity, true);
	}

	private CrossingProject convertFromEntity(CrossingProjectEntity entity, Boolean includePotentialParents) {
		CrossingProject project = new CrossingProject();
		UpdateUtility.convertFromEntity(entity, project);

		project.setCrossingProjectDbId(entity.getId());
		project.setCrossingProjectDescription(entity.getDescription());
		project.setCrossingProjectName(entity.getName());
		if (entity.getProgram() != null) {
			project.setProgramDbId(entity.getProgram().getId());
			project.setProgramName(entity.getProgram().getName());
			if (entity.getProgram().getCrop() != null) {
				project.setCommonCropName(entity.getProgram().getCrop().getCropName());
			}
		}
		if (includePotentialParents == null || includePotentialParents) {
			crossParentService.convertParentsFromEntity(entity, project);
		}

		return project;
	}

	private void updateEntity(CrossingProjectEntity entity, CrossingProjectNewRequest project)
			throws BrAPIServerException {
		UpdateUtility.updateEntity(project, entity);
		if (project.getCrossingProjectDescription() != null)
			entity.setDescription(project.getCrossingProjectDescription());
		if (project.getCrossingProjectName() != null)
			entity.setName(project.getCrossingProjectName());
		if (project.getProgramDbId() != null) {
			ProgramEntity program = programService.getProgramEntity(project.getProgramDbId());
			entity.setProgram(program);
		}

		crossParentService.convertParentsToEntity(entity, project);

	}

}
