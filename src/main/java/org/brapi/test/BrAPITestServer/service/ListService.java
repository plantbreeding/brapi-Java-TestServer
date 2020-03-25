package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.ListEntity;
import org.brapi.test.BrAPITestServer.model.entity.ListItemEntity;
import org.brapi.test.BrAPITestServer.repository.core.ListRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.common.ExternalReferences;
import io.swagger.model.common.Metadata;
import io.swagger.model.core.ListDetails;
import io.swagger.model.core.ListNewRequest;
import io.swagger.model.core.ListSummary;
import io.swagger.model.core.ListTypes;

@Service
public class ListService {

	private ListRepository listRepository;

	public ListService(ListRepository listRepository) {
		this.listRepository = listRepository;
	}

	public List<ListSummary> findLists(@Valid ListTypes listType, @Valid String listName, @Valid String listDbId,
			@Valid String listSource, ExternalReferences exRefs, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<ListEntity> entityPage;
		listName = prepParam(listName, true);
		listDbId = prepParam(listDbId, false);
		listSource = prepParam(listSource, true);
		if (listType == null) {
			entityPage = listRepository.findBySearch(listName, listDbId, listSource, pageReq);
		} else {
			entityPage = listRepository.findBySearch(listType, listName, listDbId, listSource, pageReq);
		}

		List<ListSummary> summaries = entityPage.map(this::convertToSummary).getContent();
		PagingUtility.calculateMetaData(metadata, entityPage);

		return summaries;
	}

	private String prepParam(String param, boolean fuzzySearch) {
		if (param == null) {
			return "";
		} else {
			if (fuzzySearch) {
				return "%" + param + "%";
			} else {
				return param;
			}
		}
	}

	public ListDetails getList(String listDbId) throws BrAPIServerException {
		ListEntity entity;

		Optional<ListEntity> entityOpt = listRepository.findById(listDbId);
		if (entityOpt.isPresent()) {
			entity = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "ListDbId not found!");
		}

		return convertFromEntity(entity);
	}

	public ListDetails updateListItems(String listDbId, @Valid List<String> listItems) throws BrAPIServerException {
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

			entity.setData(itemEntities);

			savedEntity = listRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "ListDbId not found!");
		}

		return convertFromEntity(savedEntity);
	}

	public ListDetails updateList(String listDbId, @Valid ListNewRequest list) throws BrAPIServerException {
		ListEntity savedEntity;
		Optional<ListEntity> entityOpt = listRepository.findById(listDbId);
		if (entityOpt.isPresent()) {
			ListEntity entity = entityOpt.get();
			updateEntity(entity, list);
			entity.setDateModified(new Date());

			savedEntity = listRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "ListDbId not found!");
		}

		return convertFromEntity(savedEntity);
	}

	public List<ListSummary> saveNewList(@Valid List<ListNewRequest> requests) {

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

	private ListDetails convertFromEntity(ListEntity entity) {
		ListDetails details = new ListDetails();
		details.setDateCreated(DateUtility.toOffsetDateTime(entity.getDateCreated()));
		details.setDateModified(DateUtility.toOffsetDateTime(entity.getDateModified()));
		details.setListDescription(entity.getDescription());
		details.setListDbId(entity.getId());
		details.setListName(entity.getListName());
		details.setListOwnerName(entity.getListOwnerName());
		details.setListOwnerPersonDbId(entity.getListOwnerPersonDbId());
		details.setListSize(entity.getData().size());
		details.setListSource(entity.getListSource());
		details.setListType(entity.getListType());

		details.setData(entity.getData().stream().map((e) -> {
			return e.getItem();
		}).collect(Collectors.toList()));

		return details;
	}

	private ListSummary convertToSummary(ListEntity entity) {
		ListSummary summary = new ListSummary();
		summary.setDateCreated(DateUtility.toOffsetDateTime(entity.getDateCreated()));
		summary.setDateModified(DateUtility.toOffsetDateTime(entity.getDateModified()));
		summary.setListDescription(entity.getDescription());
		summary.setListDbId(entity.getId());
		summary.setListName(entity.getListName());
		summary.setListOwnerName(entity.getListOwnerName());
		summary.setListOwnerPersonDbId(entity.getListOwnerPersonDbId());
		summary.setListSize(entity.getData().size());
		summary.setListSource(entity.getListSource());
		summary.setListType(entity.getListType());

		return summary;
	}

	private void updateEntity(ListEntity entity, @Valid ListNewRequest list) {

		entity.setDescription(list.getListDescription());
		entity.setListName(list.getListName());
		entity.setListOwnerName(list.getListOwnerName());
		entity.setListOwnerPersonDbId(list.getListOwnerPersonDbId());
		entity.setListSource(list.getListSource());
		entity.setListType(list.getListType());

		entity.setData(list.getData().stream().map((item) -> {
			ListItemEntity itemEntity = new ListItemEntity();
			itemEntity.setItem(item);
			itemEntity.setList(entity);
			return itemEntity;
		}).collect(Collectors.toList()));
	}

}
