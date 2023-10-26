package org.brapi.test.BrAPITestServer.service.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.ListEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ListItemEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.PersonEntity;
import org.brapi.test.BrAPITestServer.repository.core.ListRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.core.ListBaseFieldsInterface;
import io.swagger.model.core.ListDetails;
import io.swagger.model.core.ListNewRequest;
import io.swagger.model.core.ListSearchRequest;
import io.swagger.model.core.ListSummary;
import io.swagger.model.core.ListTypes;

@Service
public class ListService {

	private ListRepository listRepository;
	private PeopleService peopleService;

	public ListService(ListRepository listRepository, PeopleService peopleService) {
		this.listRepository = listRepository;
		this.peopleService = peopleService;
	}

	public List<ListSummary> findLists(ListTypes listType, String listName, String listDbId, String listSource,
			String programDbId, String commonCropName, String externalReferenceId, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) {
		ListSearchRequest request = new ListSearchRequest();
		if (listType != null) {
			request.setListType(listType);
		}
		if (listName != null) {
			request.addListNamesItem(listName);
		}
		if (listDbId != null) {
			request.addListDbIdsItem(listDbId);
		}
		if (listSource != null) {
			request.addListSourcesItem(listSource);
		}
		if (programDbId != null) {
			request.addprogramDbIdsItem(programDbId);
		}
		if (commonCropName != null) {
			request.addCommonCropNamesItem(commonCropName);
		}
		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);
		
		return findLists(request, metadata);
	}

	public List<ListSummary> findLists(ListSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ListEntity> searchQuery = buildQueryString(request);

		Page<ListEntity> entityPage = listRepository.findAllBySearch(searchQuery, pageReq);

		List<ListSummary> data = entityPage.map(this::convertToSummary).getContent();
		PagingUtility.calculateMetaData(metadata, entityPage);

		return data;
	}

	public SearchQueryBuilder<ListEntity> buildQueryString(ListSearchRequest request) {

		SearchQueryBuilder<ListEntity> query = new SearchQueryBuilder<ListEntity>(ListEntity.class)
				.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getListDbIds(), "id").appendList(request.getListNames(), "listName")
				.appendList(request.getListOwnerNames(), "listOwnerName")
				.appendList(request.getListOwnerPersonDbIds(), "listOwnerPerson.id")
				.appendList(request.getListSources(), "listSource").appendEnum(request.getListType(), "listType")
				.appendDateRange(request.getDateCreatedRangeStart(), request.getDateCreatedRangeEnd(), "dateCreated")
				.appendDateRange(request.getDateModifiedRangeStart(), request.getDateModifiedRangeEnd(),
						"dateModified");

		return query;
	}

	public ListDetails getList(String listDbId) throws BrAPIServerException {
		ListEntity entity;

		Optional<ListEntity> entityOpt = listRepository.findById(listDbId);
		if (entityOpt.isPresent()) {
			entity = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("list", listDbId, HttpStatus.NOT_FOUND);
		}

		return convertToDetails(entity);
	}

	public ListDetails updateListItems(String listDbId, List<String> listItems) throws BrAPIServerException {
		ListEntity savedEntity;
		Optional<ListEntity> entityOpt = listRepository.findById(listDbId);
		if (entityOpt.isPresent()) {
			ListEntity entity = entityOpt.get();
			entity.setDateModified(new Date());

			List<ListItemEntity> itemEntities = listItems.stream().map((item) -> {
				ListItemEntity itemEntity = new ListItemEntity();
				itemEntity.setItem(item);
				itemEntity.setList(entity);
				return itemEntity;
			}).collect(Collectors.toList());

			entity.getData().addAll(itemEntities);

			savedEntity = listRepository.save(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("list", listDbId, HttpStatus.NOT_FOUND);
		}

		return convertToDetails(savedEntity);
	}

	public ListDetails updateList(String listDbId, ListNewRequest list) throws BrAPIServerException {
		ListEntity savedEntity;
		Optional<ListEntity> entityOpt = listRepository.findById(listDbId);
		if (entityOpt.isPresent()) {
			ListEntity entity = entityOpt.get();
			updateEntity(entity, list);
			entity.setDateModified(new Date());

			savedEntity = listRepository.save(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("list", listDbId, HttpStatus.NOT_FOUND);
		}

		return convertToDetails(savedEntity);
	}

	public List<ListSummary> saveNewList(@Valid List<ListNewRequest> requests) throws BrAPIServerException {

		List<ListSummary> savedLists = new ArrayList<>();

		for (ListNewRequest list : requests) {

			ListEntity entity = new ListEntity();
			updateEntity(entity, list);
			Date now = new Date();
			entity.setDateCreated(now);
			entity.setDateModified(now);

			ListEntity savedEntity = listRepository.save(entity);

			savedLists.add(convertToSummary(savedEntity));
		}

		return savedLists;
	}

	private ListDetails convertToDetails(ListEntity entity) {
		ListDetails details = new ListDetails();
		details = (ListDetails) convertToBaseFields(entity, details);
		details.setListDbId(entity.getId());
		details.setData(entity.getData().stream().map((e) -> {
			return e.getItem();
		}).collect(Collectors.toList()));

		return details;
	}

	private ListSummary convertToSummary(ListEntity entity) {
		ListSummary summary = new ListSummary();
		summary = (ListSummary) convertToBaseFields(entity, summary);
		summary.setListDbId(entity.getId());

		return summary;

	}

	private ListBaseFieldsInterface convertToBaseFields(ListEntity entity, ListBaseFieldsInterface base) {
		base.setDateCreated(DateUtility.toOffsetDateTime(entity.getDateCreated()));
		base.setDateModified(DateUtility.toOffsetDateTime(entity.getDateModified()));
		base.setListDescription(entity.getDescription());
		base.setListName(entity.getListName());
		base.setListOwnerName(entity.getListOwnerName());
		base.setListSource(entity.getListSource());
		base.setListType(entity.getListType());
		base.setAdditionalInfo(entity.getAdditionalInfo());
		base.setExternalReferences(entity.getExternalReferencesMap());

		if (entity.getListOwnerPerson() != null) {
			base.setListOwnerPersonDbId(entity.getListOwnerPerson().getId());
		}
		if (entity.getData() != null) {
			base.setListSize(entity.getData().size());
		}
		return base;
	}

	private void updateEntity(ListEntity entity, @Valid ListNewRequest list) throws BrAPIServerException {

		if (list.getAdditionalInfo() != null)
			entity.setAdditionalInfo(list.getAdditionalInfo());
		if (list.getListDescription() != null)
			entity.setDescription(list.getListDescription());
		if (list.getExternalReferences() != null)
			entity.setExternalReferences(list.getExternalReferences());
		if (list.getListName() != null)
			entity.setListName(list.getListName());
		if (list.getListOwnerName() != null)
			entity.setListOwnerName(list.getListOwnerName());
		if (list.getListSource() != null)
			entity.setListSource(list.getListSource());
		if (list.getListType() != null)
			entity.setListType(list.getListType());

		if (list.getListOwnerPersonDbId() != null) {
			PersonEntity person = peopleService.getPersonEntity(list.getListOwnerPersonDbId());
			entity.setListOwnerPerson(person);
		}

		if (entity.getData() != null) {
			entity.getData().stream().forEach((item) -> {
				item.setList(null);
			});
		}

		if (list.getData() != null) {
			entity.setData(list.getData().stream().map((item) -> {
				ListItemEntity itemEntity = new ListItemEntity();
				itemEntity.setItem(item);
				itemEntity.setList(entity);
				return itemEntity;
			}).collect(Collectors.toList()));
		} else {
			entity.setData(new ArrayList<>());
		}
	}
}
