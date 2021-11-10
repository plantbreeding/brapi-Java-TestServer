package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ScaleEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ScaleValidValueCategoryEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.ScaleRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Scale;
import io.swagger.model.pheno.ScaleBaseClass;
import io.swagger.model.pheno.ScaleBaseClassValidValues;
import io.swagger.model.pheno.ScaleBaseClassValidValuesCategories;

@Service
public class ScaleService {
	private final ScaleRepository scaleRepository;
	private final OntologyService ontologyService;

	@Autowired
	public ScaleService(ScaleRepository scaleRepository, OntologyService ontologyService) {
		this.scaleRepository = scaleRepository;
		this.ontologyService = ontologyService;
	}

	public List<Scale> findScales(@Valid String scaleDbId, @Valid String observationVariableDbId,
			@Valid String externalReferenceID, @Valid String externalReferenceSource, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ScaleEntity> searchQuery = new SearchQueryBuilder<ScaleEntity>(ScaleEntity.class);
		if (observationVariableDbId != null) {
			searchQuery = searchQuery.join("variables", "variable").appendSingle(observationVariableDbId,
					"*variable.id");
		}
		searchQuery = searchQuery.appendSingle(scaleDbId, "id").withExRefs(externalReferenceID,
				externalReferenceSource);
		Page<ScaleEntity> scalePage = scaleRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, scalePage);

		List<Scale> scales = scalePage.map(this::convertFromEntity).getContent();
		return scales;
	}

	public Scale updateScale(String scaleDbId, @Valid ScaleBaseClass body) throws BrAPIServerException {
		ScaleEntity savedEntity;
		Optional<ScaleEntity> entityOpt = scaleRepository.findById(scaleDbId);
		if (entityOpt.isPresent()) {
			ScaleEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = saveScaleEntity(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("scale", scaleDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public List<Scale> saveScales(@Valid List<ScaleBaseClass> body) throws BrAPIServerException {
		List<Scale> savedScales = new ArrayList<>();
		for (ScaleBaseClass request : body) {
			ScaleEntity newEntity = new ScaleEntity();
			updateEntity(newEntity, request);
			ScaleEntity saved = saveScaleEntity(newEntity);
			savedScales.add(convertFromEntity(saved));
		}

		return savedScales;
	}

	public ScaleEntity saveScaleEntity(ScaleEntity scaleEntity) {
		return scaleRepository.save(scaleEntity);
	}

	public Scale getScale(String scaleDbId) throws BrAPIServerException {
		return convertFromEntity(getScaleEntity(scaleDbId, HttpStatus.NOT_FOUND));
	}

	public ScaleEntity getScaleEntity(String scaleDbId) throws BrAPIServerException {
		return getScaleEntity(scaleDbId, HttpStatus.BAD_REQUEST);
	}

	public ScaleEntity getScaleEntity(String scaleDbId, HttpStatus errorStatus) throws BrAPIServerException {
		ScaleEntity scale = null;
		if (scaleDbId != null) {
			Optional<ScaleEntity> entityOpt = scaleRepository.findById(scaleDbId);
			if (entityOpt.isPresent()) {
				scale = entityOpt.get();
			} else {
				throw new BrAPIServerDbIdNotFoundException("scale", scaleDbId);
			}
		}
		return scale;
	}

	public ScaleEntity updateEntity(ScaleEntity entity, @Valid ScaleBaseClass scale) throws BrAPIServerException {

		entity.setAdditionalInfo(UpdateUtility.replaceField(scale.getAdditionalInfo(), entity.getAdditionalInfoMap()));
		entity.setDataType(UpdateUtility.replaceField(scale.getDataType(), entity.getDataType()));
		entity.setDecimalPlaces(UpdateUtility.replaceField(scale.getDecimalPlaces(), entity.getDecimalPlaces()));
		entity.setExternalReferences(
				UpdateUtility.replaceField(scale.getExternalReferences(), entity.getExternalReferencesMap()));
		entity.setScaleName(UpdateUtility.replaceField(scale.getScaleName(), entity.getScaleName()));

		ontologyService.updateOntologyReference(entity, scale.getOntologyReference());

		if (scale.getValidValues() != null) {
			if (scale.getValidValues().isPresent()) {
				ScaleBaseClassValidValues validValues = scale.getValidValues().get();
				entity.setValidValueMin(UpdateUtility.replaceField(validValues.getMin(), entity.getValidValueMin()));
				entity.setValidValueMax(UpdateUtility.replaceField(validValues.getMax(), entity.getValidValueMax()));

				if (validValues.getCategories() != null) {
					if (validValues.getCategories().isPresent()) {
						List<ScaleBaseClassValidValuesCategories> categories = validValues.getCategories().get();

						if (entity.getValidValueCategories() != null) {
							for (ScaleValidValueCategoryEntity catEntity : entity.getValidValueCategories()) {
								catEntity.setScale(null);
							}
						}
						entity.setValidValueCategories(new ArrayList<>());
						entity.setValidValueCategories(categories.stream().map(cat -> {
							ScaleValidValueCategoryEntity catEntity = new ScaleValidValueCategoryEntity();
							catEntity.setLabel(cat.getLabel());
							catEntity.setValue(cat.getValue());
							catEntity.setScale(entity);
							return catEntity;
						}).collect(Collectors.toList()));
					} else {
						entity.setValidValueCategories(null);
					}
				}
			} else {
				entity.setValidValueCategories(null);
				entity.setValidValueMax(null);
				entity.setValidValueMin(null);
			}
		}

		return entity;
	}

	public Scale convertFromEntity(ScaleEntity entity) {
		Scale scale = null;
		if (entity != null) {
			scale = new Scale();
			scale.setAdditionalInfo(entity.getAdditionalInfoMap());
			scale.setDataType(entity.getDataType());
			scale.setDecimalPlaces(entity.getDecimalPlaces());
			scale.setExternalReferences(entity.getExternalReferencesMap());
			scale.setScaleDbId(entity.getId());
			scale.setScaleName(entity.getScaleName());
			scale.setOntologyReference(ontologyService.convertFromEntity(entity));

			ScaleBaseClassValidValues validValues = new ScaleBaseClassValidValues();
			validValues.setMin(entity.getValidValueMin());
			validValues.setMax(entity.getValidValueMax());
			if (entity.getValidValueCategories() != null) {
				validValues.setCategories(entity.getValidValueCategories().stream().map(e -> {
					ScaleBaseClassValidValuesCategories cat = new ScaleBaseClassValidValuesCategories();
					cat.setLabel(e.getLabel());
					cat.setValue(e.getValue());
					return cat;
				}).collect(Collectors.toList()));
			}
			scale.setValidValues(validValues);
		}
		return scale;
	}
}
