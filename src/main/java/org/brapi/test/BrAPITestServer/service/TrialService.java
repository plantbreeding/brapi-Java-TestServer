package org.brapi.test.BrAPITestServer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.AdditionalInfoEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.repository.TrialRepository;
import org.brapi.test.BrAPITestServer.utility.DateUtility;
import org.brapi.test.BrAPITestServer.utility.PagingUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import io.swagger.model.common.Metadata;
import io.swagger.model.core.Trial;

@Service
public class TrialService {
	private TrialRepository trialRepository;
	private ContactService contactService;

	public TrialService(TrialRepository trialRepository, ContactService contactService) {
		this.trialRepository = trialRepository;
		this.contactService = contactService;
	}

	public List<Trial> getTrialSummaries(String commonCropName, String programDbId, String locationDbId, Boolean active, String sortBy,
			String sortOrder, Metadata metaData) {
		Sort sort = buildSort(sortBy, sortOrder);
		Pageable pageReq = PagingUtility.getPageRequest(metaData, sort);

		boolean applyActiveFilter = true;
		if (active == null) {
			applyActiveFilter = false;
			active = Boolean.TRUE;
		}
		programDbId = null == programDbId ? "" : programDbId;
		locationDbId = null == locationDbId ? "" : locationDbId;
		commonCropName = null == commonCropName ? "" : commonCropName;

		Page<TrialEntity> trialsPage = trialRepository.findBySearch(commonCropName, programDbId, locationDbId, applyActiveFilter,
				active, pageReq);

		List<Trial> summaries = trialsPage.map(this::convertFromEntityToSummary).getContent();

		PagingUtility.calculateMetaData(metaData, trialsPage);
		return summaries;
	}

	private Sort buildSort(String sortBy, String sortOrder) {
		sortOrder = null == sortOrder ? "asc" : sortOrder;
		switch (sortOrder) {
		case "desc":
		case "DESC":
			sortOrder = "desc";
			break;
		case "asc":
		case "ASC":
		default:
			sortOrder = "asc";
			break;
		}

		sortBy = null == sortBy ? "id" : sortBy;
		switch (sortBy) {
		case "startDate":
		case "endDate":
		case "trialName":
		case "active":
			break;
		case "trialDbId":
			sortBy = "id";
			break;
		case "programDbId":
			sortBy = "program.id";
			break;
		case "programName":
			sortBy = "program.name";
			break;
		default:
			sortBy = "id";
			break;
		}

		return Sort.by(Direction.fromString(sortOrder), sortBy);
	}

	public Trial getTrialSummary(String trialDbId) {
		Optional<TrialEntity> entityOption = trialRepository.findById(trialDbId);
		if (entityOption.isPresent()) {
			return convertFromEntity(entityOption.get());
		}
		return null;
	}

	private Trial convertFromEntity(TrialEntity entity) {
		Trial trial = new Trial();
		trial.setActive(entity.isActive());
		trial.setCommonCropName(entity.getProgram().getCrop().getCropName());
		trial.setDocumentationURL(entity.getDocumentationURL());
		trial.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
		trial.setProgramDbId(entity.getProgram().getId());
		trial.setProgramName(entity.getProgram().getName());
		trial.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
		trial.setTrialDbId(entity.getId());
		trial.setTrialName(entity.getTrialName());

//		trial.setDatasetAuthorship(
//				new TrialDatasetAuthorship().datasetPUI(entity.getDatasetPUI()).license(entity.getDatasetLicence()));
//		trial.addDatasetAuthorshipsItem(
//				new TrialDatasetAuthorships().datasetPUI(entity.getDatasetPUI()).license(entity.getDatasetLicence()));
//		trial.addPublicationsItem(new TrialPublications().publicationPUI(entity.getDatasetPUI()).publicationReference(entity.getDocumentationURL()));
		trial.setContacts(
				entity.getContacts().stream().map(this.contactService::convertFromEntity).collect(Collectors.toList()));

//		trial.setStudies(entity.getStudies().stream().map((e) -> {
//			TrialStudies id = new TrialStudies();
//			id.setLocationDbId(e.getLocation().getId());
//			id.setLocationName(e.getLocation().getName());
//			id.setStudyDbId(e.getId());
//			id.setStudyName(e.getStudyName());
//			return id;
//		}).collect(Collectors.toList()));

		trial.setAdditionalInfo(new HashMap<>());
		for (AdditionalInfoEntity e : entity.getAdditionalInfo()) {
			trial.getAdditionalInfo().put(e.getKey(), e.getValue());
		}

		return trial;
	}

	private Trial convertFromEntityToSummary(TrialEntity entity) {
		Trial summary = new Trial();
		summary.setActive(entity.isActive());
		summary.setCommonCropName(entity.getProgram().getCrop().getCropName());
		summary.setDocumentationURL(entity.getDocumentationURL());
		summary.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
		summary.setProgramDbId(entity.getProgram().getId());
		summary.setProgramName(entity.getProgram().getName());
		summary.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
		summary.setTrialDbId(entity.getId());
		summary.setTrialName(entity.getTrialName());

//		summary.setStudies(entity.getStudies().stream().map((e) -> {
//			TrialStudies id = new TrialStudies();
//			id.setLocationDbId(e.getLocation().getId());
//			id.setLocationName(e.getLocation().getName());
//			id.setStudyDbId(e.getId());
//			id.setStudyName(e.getStudyName());
//			return id;
//		}).collect(Collectors.toList()));

		summary.setAdditionalInfo(new HashMap<>());
		entity.getAdditionalInfo().forEach((e) -> {
			summary.getAdditionalInfo().put(e.getKey(), e.getValue());
		});

		return summary;
	}
}
