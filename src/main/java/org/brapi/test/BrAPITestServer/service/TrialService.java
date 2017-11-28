package org.brapi.test.BrAPITestServer.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.TrialAdditionalInfoEntity;
import org.brapi.test.BrAPITestServer.model.entity.TrialEntity;
import org.brapi.test.BrAPITestServer.model.rest.Contact;
import org.brapi.test.BrAPITestServer.model.rest.DatasetAuthorship;
import org.brapi.test.BrAPITestServer.model.rest.StudyIDWrapper;
import org.brapi.test.BrAPITestServer.model.rest.TrialSummary;
import org.brapi.test.BrAPITestServer.model.rest.TrialSummaryWithContact;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.TrialRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrialService {
	private TrialRepository trialRepository;
	private ContactService contactService;

	public TrialService(TrialRepository trialRepository, ContactService contactService) {
		this.trialRepository = trialRepository;
		this.contactService = contactService;
	}

	public List<TrialSummary> getTrialSummaries(MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<TrialSummary> summaries = trialRepository.findAll(pageReq).map(this::convertFromEntity).getContent();
		metaData.getPagination().setTotalCount((int) trialRepository.count());
		return summaries;
	}

	public TrialSummaryWithContact getTrialSummary(String trialDbId) {
		TrialEntity entity = trialRepository.findById(trialDbId).get();
		// TODO should use the same return object and convertFromEntity()

		TrialSummaryWithContact summary = null;
		if (entity != null) {
			summary = new TrialSummaryWithContact();
			summary.setActive(entity.isActive());
			summary.setEndDate(entity.getEndDate());
			summary.setProgramDbId(entity.getProgram().getId());
			summary.setProgramName(entity.getProgram().getName());
			summary.setStartDate(entity.getStartDate());
			summary.setTrialDbId(entity.getId());
			summary.setTrialName(entity.getTrialName());

			summary.setDatasetAuthorship(new DatasetAuthorship());
			summary.getDatasetAuthorship().setDatasetPUI(entity.getDatasetPUI());
			summary.getDatasetAuthorship().setLicense(entity.getDatasetLicense());

			summary.setContacts(entity.getContacts().stream().map(this.contactService::convertFromEntity).collect(Collectors.toList()));

			summary.setStudies(entity.getStudies().stream().map((e) -> {
				StudyIDWrapper id = new StudyIDWrapper();
				id.setLocationDbId(e.getLocation().getId());
				id.setLocationName(e.getLocation().getName());
				id.setStudyDbId(e.getId());
				id.setStudyName(e.getStudyName());
				return id;
			}).collect(Collectors.toList()));

			summary.setAdditionalInfo(new HashMap<>());
			for(TrialAdditionalInfoEntity e : entity.getAdditionalInfo()) {
				summary.getAdditionalInfo().put(e.getKey(), e.getValue());
			}
		}
		return summary;
	}

	private TrialSummary convertFromEntity(TrialEntity entity) {
		TrialSummary summary = new TrialSummary();
		summary.setActive(entity.isActive());
		summary.setEndDate(entity.getEndDate());
		summary.setProgramDbId(entity.getProgram().getId());
		summary.setProgramName(entity.getProgram().getName());
		summary.setStartDate(entity.getStartDate());
		summary.setTrialDbId(entity.getId());
		summary.setTrialName(entity.getTrialName());

		summary.setStudies(entity.getStudies().stream().map((e) -> {
			StudyIDWrapper id = new StudyIDWrapper();
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
