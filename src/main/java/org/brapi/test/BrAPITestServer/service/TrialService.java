package org.brapi.test.BrAPITestServer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.model.entity.TrialAdditionalInfoEntity;
import org.brapi.test.BrAPITestServer.model.entity.TrialEntity;
import org.brapi.test.BrAPITestServer.repository.TrialRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.Metadata;
import io.swagger.model.Trial;
import io.swagger.model.TrialDatasetAuthorship;
import io.swagger.model.TrialStudies;
import io.swagger.model.TrialSummary;

@Service
public class TrialService {
	private TrialRepository trialRepository;
	private ContactService contactService;

	public TrialService(TrialRepository trialRepository, ContactService contactService) {
		this.trialRepository = trialRepository;
		this.contactService = contactService;
	}

	public List<TrialSummary> getTrialSummaries(String programDbId, String locationDbId, Boolean active, String sortBy,
			String sortOrder, Metadata metaData) {
		Sort sort = buildSort(sortBy, sortOrder);
		Pageable pageReq = PagingUtility.getPageRequest(metaData, sort);

		boolean applyActiveFilter = true;
		if(active == null) {
			applyActiveFilter = false;
			active = Boolean.TRUE;
		}
		programDbId = null == programDbId ? "" : programDbId;
		locationDbId = null == locationDbId ? "" : locationDbId;
		
		Page<TrialEntity> trialsPage = trialRepository.findBySearch(programDbId, locationDbId, applyActiveFilter, active, pageReq);

		List<TrialSummary> summaries = trialsPage.map(this::convertFromEntity).getContent();

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
			TrialEntity entity = entityOption.get();
			// TODO should use the same return object and convertFromEntity()

			Trial summary = new Trial();
			summary.setActive(entity.isActive());
			summary.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
			summary.setProgramDbId(entity.getProgram().getId());
			summary.setProgramName(entity.getProgram().getName());
			summary.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
			summary.setTrialDbId(entity.getId());
			summary.setTrialName(entity.getTrialName());

			summary.setDatasetAuthorship(new TrialDatasetAuthorship());
			summary.getDatasetAuthorship().setDatasetPUI(entity.getDatasetPUI());
			summary.getDatasetAuthorship().setLicense(entity.getDatasetLicence());

			summary.setContacts(entity.getContacts().stream().map(this.contactService::convertFromEntity)
					.collect(Collectors.toList()));

			summary.setStudies(entity.getStudies().stream().map((e) -> {
				TrialStudies id = new TrialStudies();
				id.setLocationDbId(e.getLocation().getId());
				id.setLocationName(e.getLocation().getName());
				id.setStudyDbId(e.getId());
				id.setStudyName(e.getStudyName());
				return id;
			}).collect(Collectors.toList()));

			summary.setAdditionalInfo(new HashMap<>());
			for (TrialAdditionalInfoEntity e : entity.getAdditionalInfo()) {
				summary.getAdditionalInfo().put(e.getKey(), e.getValue());
			}

			return summary;
		}
		return null;
	}

	private TrialSummary convertFromEntity(TrialEntity entity) {
		TrialSummary summary = new TrialSummary();
		summary.setActive(entity.isActive());
		summary.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
		summary.setProgramDbId(entity.getProgram().getId());
		summary.setProgramName(entity.getProgram().getName());
		summary.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
		summary.setTrialDbId(entity.getId());
		summary.setTrialName(entity.getTrialName());

		summary.setStudies(entity.getStudies().stream().map((e) -> {
			TrialStudies id = new TrialStudies();
			id.setLocationDbId(e.getLocation().getId());
			id.setLocationName(e.getLocation().getName());
			id.setStudyDbId(e.getId());
			id.setStudyName(e.getStudyName());
			return id;
		}).collect(Collectors.toList()));

		summary.setAdditionalInfo(new HashMap<>());
		entity.getAdditionalInfo().forEach((e) -> {
			summary.getAdditionalInfo().put(e.getKey(), e.getValue());
		});

		return summary;
	}
}
