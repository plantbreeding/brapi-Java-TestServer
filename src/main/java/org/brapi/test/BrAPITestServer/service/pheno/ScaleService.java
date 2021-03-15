package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ScaleEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ScaleValidValueCategoryEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.ScaleRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
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
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "scaleDbId not found: " + scaleDbId);
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
				throw new BrAPIServerException(errorStatus, "scaleDbId not found " + scaleDbId);
			}
		}
		return scale;
	}

	public ScaleEntity updateEntity(ScaleEntity entity, @Valid ScaleBaseClass scale) throws BrAPIServerException {
		if (scale.getAdditionalInfo() != null)
			entity.setAdditionalInfo(scale.getAdditionalInfo());
		if (scale.getDataType() != null)
			entity.setDataType(scale.getDataType());
		if (scale.getDecimalPlaces() != null)
			entity.setDecimalPlaces(scale.getDecimalPlaces());
		if (scale.getExternalReferences() != null)
			entity.setExternalReferences(scale.getExternalReferences());
		if (scale.getScaleName() != null)
			entity.setScaleName(scale.getScaleName());
		if (scale.getOntologyReference() != null)
			ontologyService.updateOntologyReference(entity, scale.getOntologyReference());
		if (scale.getValidValues() != null) {
			if (scale.getValidValues().getMin() != null)
				entity.setValidValueMin(scale.getValidValues().getMin());
			if (scale.getValidValues().getMax() != null)
				entity.setValidValueMax(scale.getValidValues().getMax());
			if (scale.getValidValues().getCategories() != null) {
				if (entity.getValidValueCategories() != null) {
					for (ScaleValidValueCategoryEntity catEntity : entity.getValidValueCategories()) {
						catEntity.setScale(null);
					}
				}
				entity.setValidValueCategories(new ArrayList<>());
				entity.setValidValueCategories(scale.getValidValues().getCategories().stream().map(cat -> {
					ScaleValidValueCategoryEntity catEntity = new ScaleValidValueCategoryEntity();
					catEntity.setLabel(cat.getLabel());
					catEntity.setValue(cat.getValue());
					catEntity.setScale(entity);
					return catEntity;
				}).collect(Collectors.toList()));
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
			scale.setValidValues(new ScaleBaseClassValidValues());
			scale.getValidValues().setMin(entity.getValidValueMin());
			scale.getValidValues().setMax(entity.getValidValueMax());
			if(entity.getValidValueCategories() != null) {
				scale.getValidValues().setCategories(entity.getValidValueCategories().stream().map(e -> {
					ScaleBaseClassValidValuesCategories cat = new ScaleBaseClassValidValuesCategories();
					cat.setLabel(e.getLabel());
					cat.setValue(e.getValue());
					return cat;
				}).collect(Collectors.toList()));
			}
		}
		return scale;
	}
}
