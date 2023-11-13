package org.brapi.test.BrAPITestServer.service.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.DatasetAuthorshipEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.PersonEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.PublicationEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.repository.core.TrialRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import io.swagger.model.Metadata;
import io.swagger.model.core.Contact;
import io.swagger.model.core.SortBy;
import io.swagger.model.core.SortOrder;
import io.swagger.model.core.Trial;
import io.swagger.model.core.TrialNewRequest;
import io.swagger.model.core.TrialNewRequestDatasetAuthorships;
import io.swagger.model.core.TrialNewRequestPublications;
import io.swagger.model.core.TrialSearchRequest;

@Service
public class TrialService {
	private final TrialRepository trialRepository;
	private final PeopleService peopleService;
	private final ProgramService programService;
	private final CropService cropService;

	public TrialService(TrialRepository trialRepository, PeopleService peopleService, ProgramService programService,
			CropService cropService) {
		this.trialRepository = trialRepository;
		this.peopleService = peopleService;
		this.programService = programService;
		this.cropService = cropService;
	}

	public List<Trial> findTrials(@Valid String commonCropName, @Valid String contactDbId, @Valid String programDbId,
			@Valid String locationDbId, @Valid LocalDate searchDateRangeStart, @Valid LocalDate searchDateRangeEnd,
			@Valid String studyDbId, @Valid String trialDbId, @Valid String trialName, @Valid String trialPUI,
			@Valid String externalReferenceId, @Valid String externalReferenceID, @Valid String externalReferenceSource,
			@Valid Boolean active, @Valid String sortBy, @Valid String sortOrder, Metadata metadata) {

		TrialSearchRequest request = new TrialSearchRequest();
		if (active != null)
			request.setActive(active);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (contactDbId != null)
			request.addContactDbIdsItem(contactDbId);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (locationDbId != null)
			request.addLocationDbIdsItem(locationDbId);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (trialName != null)
			request.addTrialNamesItem(trialName);
		if (trialPUI != null)
			request.addTrialPUIsItem(trialPUI);
		if (searchDateRangeStart != null)
			request.setSearchDateRangeStart(searchDateRangeStart);
		if (searchDateRangeEnd != null)
			request.setSearchDateRangeEnd(searchDateRangeEnd);
		if (sortBy != null && SortBy.fromValue(sortBy) != null)
			request.setSortBy(SortBy.fromValue(sortBy));
		if (sortOrder != null && SortOrder.fromValue(sortOrder) != null)
			request.setSortOrder(SortOrder.fromValue(sortOrder));

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);
		return findTrials(request, metadata);
	}

	public List<Trial> findTrials(@Valid TrialSearchRequest request, Metadata metadata) {

		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<TrialEntity> searchQuery = new SearchQueryBuilder<TrialEntity>(TrialEntity.class);

		if (request.getContactDbIds() != null) {
			searchQuery = searchQuery.join("contacts", "contact");
		}
		if (request.getStudyDbIds() != null || request.getStudyNames() != null) {
			searchQuery = searchQuery.join("studies", "study");
		}

		searchQuery = searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getCommonCropNames(), "crop.cropName")
				.appendList(request.getContactDbIds(), "*contact.id")
				.appendList(request.getLocationDbIds(), "*study.location.id")
				.appendList(request.getLocationNames(), "*study.location.locationName")
				.appendList(request.getProgramDbIds(), "program.id")
				.appendList(request.getProgramNames(), "program.name").appendList(request.getStudyDbIds(), "*study.id")
				.appendList(request.getStudyNames(), "*study.studyName").appendList(request.getTrialDbIds(), "id")
				.appendList(request.getTrialNames(), "trialName")
				.appendDateRange(request.getSearchDateRangeStart(), request.getSearchDateRangeEnd(), "startDate")
				.withSort(getSortByField(request.getSortBy()), request.getSortOrder());

		Page<TrialEntity> trialsPage = trialRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, trialsPage);

		List<Trial> trials = trialsPage.map(this::convertFromEntity).getContent();
		return trials;
	}

	public Trial getTrial(String trialDbId) throws BrAPIServerException {
		return convertFromEntity(getTrialEntity(trialDbId, HttpStatus.NOT_FOUND));
	}

	public TrialEntity getTrialEntity(String trialDbId) throws BrAPIServerException {
		return getTrialEntity(trialDbId, HttpStatus.BAD_REQUEST);
	}

	public TrialEntity getTrialEntity(String trialDbId, HttpStatus errorStatus) throws BrAPIServerException {
		Optional<TrialEntity> entityOption = trialRepository.findById(trialDbId);
		TrialEntity entity = null;
		if (entityOption.isPresent()) {
			entity = entityOption.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("trial", trialDbId, errorStatus);
		}
		return entity;
	}

	public List<Trial> saveTrials(@Valid List<TrialNewRequest> body) throws BrAPIServerException {
		List<Trial> savedTrials = new ArrayList<>();

		for (TrialNewRequest trial : body) {

			TrialEntity entity = new TrialEntity();
			updateEntity(entity, trial);

			TrialEntity savedEntity = trialRepository.save(entity);

			savedTrials.add(convertFromEntity(savedEntity));
		}

		return savedTrials;
	}

	public Trial updateTrial(String trialDbId, TrialNewRequest body) throws BrAPIServerException {
		TrialEntity entity = getTrialEntity(trialDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, body);
		TrialEntity savedEntity = trialRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	private Trial convertFromEntity(TrialEntity entity) {
		Trial trial = new Trial();
		trial.setActive(entity.isActive());
		trial.setAdditionalInfo(entity.getAdditionalInfo());
		trial.setDocumentationURL(entity.getDocumentationURL());
		trial.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
		trial.setExternalReferences(entity.getExternalReferencesMap());
		trial.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
		trial.setTrialDbId(entity.getId());
		trial.setTrialDescription(entity.getTrialDescription());
		trial.setTrialName(entity.getTrialName());
		trial.setTrialPUI(entity.getTrialPUI());

		if (entity.getContacts() != null) {
			trial.setContacts(entity.getContacts().stream().map(this.peopleService::convertToContact)
					.collect(Collectors.toList()));
		}
		if (entity.getDatasetAuthorships() != null) {
			trial.setDatasetAuthorships(
					entity.getDatasetAuthorships().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		}

		if (entity.getPublications() != null) {
			trial.setPublications(
					entity.getPublications().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		}

		if (entity.getProgram() != null) {
			trial.setProgramDbId(entity.getProgram().getId());
			trial.setProgramName(entity.getProgram().getName());
			if (entity.getProgram().getCrop() != null) {
				trial.setCommonCropName(entity.getProgram().getCrop().getCropName());
			}
		}
		if (entity.getCrop() != null) {
			trial.setCommonCropName(entity.getCrop().getCropName());
		}

		return trial;
	}

	private void updateEntity(TrialEntity entity, TrialNewRequest body) throws BrAPIServerException {
		if (body.isActive() != null)
			entity.setActive(body.isActive());
		if (body.getAdditionalInfo() != null)
			entity.setAdditionalInfo(body.getAdditionalInfo());
		if (body.getContacts() != null) {
			entity.setContacts(new ArrayList<>());
			for (Contact contact : body.getContacts()) {
				PersonEntity contactEntity;
				if (contact.getContactDbId() == null) {
					contactEntity = peopleService.saveContact(contact);
				} else {
					try {
						contactEntity = peopleService.getPersonEntity(contact.getContactDbId());
					} catch (BrAPIServerException e) {
						contactEntity = peopleService.saveContact(contact);
					}
				}
				entity.getContacts().add(contactEntity);
			}
		}
		if (body.getDatasetAuthorships() != null) {
			if (entity.getDatasetAuthorships() != null) {
				for (DatasetAuthorshipEntity auth : entity.getDatasetAuthorships()) {
					auth.setTrial(null);
				}
			}
			entity.setDatasetAuthorships(
					body.getDatasetAuthorships().stream().map(this::convertToEntity).collect(Collectors.toList()));
		}
		if (body.getDocumentationURL() != null)
			entity.setDocumentationURL(body.getDocumentationURL());
		if (body.getEndDate() != null)
			entity.setEndDate(DateUtility.toDate(body.getEndDate()));
		if (body.getExternalReferences() != null)
			entity.setExternalReferences(body.getExternalReferences());
		if (body.getPublications() != null) {
			if (entity.getPublications() != null) {
				for (PublicationEntity pub : entity.getPublications()) {
					pub.setTrial(null);
				}
			}
			entity.setPublications(
					body.getPublications().stream().map(this::convertToEntity).collect(Collectors.toList()));
		}
		if (body.getStartDate() != null)
			entity.setStartDate(DateUtility.toDate(body.getStartDate()));
		if (body.getTrialDescription() != null)
			entity.setTrialDescription(body.getTrialDescription());
		if (body.getTrialName() != null)
			entity.setTrialName(body.getTrialName());
		if (body.getTrialPUI() != null)
			entity.setTrialPUI(body.getTrialPUI());

		if (body.getProgramDbId() != null) {
			ProgramEntity program = programService.getProgramEntity(body.getProgramDbId());
			entity.setProgram(program);
		} else if (body.getCommonCropName() != null) {
			CropEntity crop = cropService.getCropEntity(body.getCommonCropName());
			entity.setCrop(crop);
		}

	}

	private TrialNewRequestDatasetAuthorships convertFromEntity(DatasetAuthorshipEntity entity) {
		TrialNewRequestDatasetAuthorships authorship = new TrialNewRequestDatasetAuthorships();
		authorship.setDatasetPUI(entity.getDatasetPUI());
		authorship.setLicense(entity.getLicense());
		authorship.setPublicReleaseDate(DateUtility.toLocalDate(entity.getPublicReleaseDate()));
		authorship.setSubmissionDate(DateUtility.toLocalDate(entity.getSubmissionDate()));
		return authorship;

	}

	private DatasetAuthorshipEntity convertToEntity(TrialNewRequestDatasetAuthorships auth) {
		DatasetAuthorshipEntity entity = null;
		if (auth != null) {
			entity = new DatasetAuthorshipEntity();
			entity.setDatasetPUI(auth.getDatasetPUI());
			entity.setLicense(auth.getLicense());
			entity.setPublicReleaseDate(DateUtility.toDate(auth.getPublicReleaseDate()));
			entity.setSubmissionDate(DateUtility.toDate(auth.getSubmissionDate()));
		}
		return entity;
	}

	private TrialNewRequestPublications convertFromEntity(PublicationEntity entity) {
		TrialNewRequestPublications publication = new TrialNewRequestPublications();
		publication.setPublicationPUI(entity.getPublicationPUI());
		publication.setPublicationReference(entity.getPublicationReference());
		return publication;

	}

	private PublicationEntity convertToEntity(TrialNewRequestPublications pub) {
		PublicationEntity entity = null;
		if (pub != null) {
			entity = new PublicationEntity();
			entity.setPublicationPUI(pub.getPublicationPUI());
			entity.setPublicationReference(pub.getPublicationReference());
		}
		return entity;

	}

	private String getSortByField(SortBy sortBy) {
		String sortByStr = "id";
		if (sortBy != null) {
			switch (sortBy) {
			case STARTDATE:
				sortByStr = "startDate";
				break;
			case ENDDATE:
				sortByStr = "endDate";
				break;
			case TRIALNAME:
				sortByStr = "trialName";
				break;
			case PROGRAMDBID:
				sortByStr = "program.id";
				break;
			case PROGRAMNAME:
				sortByStr = "program.name";
				break;
			case TRIALDBID:
			default:
				sortByStr = "id";
				break;
			}
		}

		return sortByStr;
	}

}
