package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.apache.commons.lang3.math.NumberUtils;
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

	public List<Scale> findScales(String scaleDbId, String observationVariableDbId, String ontologyDbId,
			String commonCropName, String programDbId, String externalReferenceId, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) {
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

	public ScaleEntity updateEntity(ScaleEntity entity, ScaleBaseClass scale) throws BrAPIServerException {

		UpdateUtility.updateEntity(scale, entity);

		entity.setDataType(UpdateUtility.replaceField(scale.getDataType(), entity.getDataType()));
		entity.setDecimalPlaces(UpdateUtility.replaceField(scale.getDecimalPlaces(), entity.getDecimalPlaces()));
		entity.setUnits(UpdateUtility.replaceField(scale.getUnits(), entity.getUnits()));
		entity.setScaleName(UpdateUtility.replaceField(scale.getScaleName(), entity.getScaleName()));
		entity.setScalePUI(UpdateUtility.replaceField(scale.getScalePUI(), entity.getScalePUI()));

		ontologyService.updateOntologyReference(entity, scale.getOntologyReference());

		if (scale.getValidValues() != null) {
			if (scale.getValidValues().isPresent()) {
				ScaleBaseClassValidValues validValues = scale.getValidValues().get();

				Integer maxInt = NumberUtils.isCreatable(entity.getValidValueMax())
						? Integer.parseInt(entity.getValidValueMax())
						: null;
				entity.setValidValueMax(UpdateUtility.replaceField(validValues.getMax(), maxInt).toString());
				entity.setValidValueMax(
						UpdateUtility.replaceField(validValues.getMaximumValue(), entity.getValidValueMax()));

				Integer minInt = NumberUtils.isCreatable(entity.getValidValueMin())
						? Integer.parseInt(entity.getValidValueMin())
						: null;
				entity.setValidValueMin(UpdateUtility.replaceField(validValues.getMin(), minInt).toString());
				entity.setValidValueMin(
						UpdateUtility.replaceField(validValues.getMinimumValue(), entity.getValidValueMin()));

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
			UpdateUtility.convertFromEntity(entity, scale);

			scale.setDataType(entity.getDataType());
			scale.setDecimalPlaces(entity.getDecimalPlaces());
			scale.setUnits(entity.getUnits());
			scale.setScaleDbId(entity.getId());
			scale.setScaleName(entity.getScaleName());
			scale.setScalePUI(entity.getScalePUI());
			scale.setOntologyReference(ontologyService.convertFromEntity(entity));

			ScaleBaseClassValidValues validValues = new ScaleBaseClassValidValues();
			if (NumberUtils.isCreatable(entity.getValidValueMin())) {
				validValues.setMin(Integer.parseInt(entity.getValidValueMin()));
			}
			if (NumberUtils.isCreatable(entity.getValidValueMax())) {
				validValues.setMax(Integer.parseInt(entity.getValidValueMax()));
			}
			validValues.setMaximumValue(entity.getValidValueMax());
			validValues.setMinimumValue(entity.getValidValueMin());
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
