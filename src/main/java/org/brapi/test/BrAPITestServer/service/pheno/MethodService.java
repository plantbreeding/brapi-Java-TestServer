package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.pheno.MethodEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.MethodRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Method;
import io.swagger.model.pheno.MethodBaseClass;

@Service
public class MethodService {
	private final MethodRepository methodRepository;
	private final OntologyService ontologyService;

	@Autowired
	public MethodService(MethodRepository methodRepository, OntologyService ontologyService) {
		this.methodRepository = methodRepository;
		this.ontologyService = ontologyService;
	}

	public List<Method> findMethods(String methodDbId, String observationVariableDbId, String ontologyDbId,
			String commonCropName, String programDbId, String externalReferenceId, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<MethodEntity> searchQuery = new SearchQueryBuilder<MethodEntity>(MethodEntity.class);
		if (observationVariableDbId != null) {
			searchQuery = searchQuery.join("variables", "variable").appendSingle(observationVariableDbId,
					"*variable.id");
		}
		searchQuery = searchQuery.appendSingle(methodDbId, "id").withExRefs(externalReferenceID,
				externalReferenceSource);
		Page<MethodEntity> methodPage = methodRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, methodPage);

		List<Method> methods = methodPage.map(this::convertFromEntity).getContent();
		return methods;
	}

	public Method updateMethod(String methodDbId, @Valid MethodBaseClass body) throws BrAPIServerException {
		MethodEntity savedEntity;
		Optional<MethodEntity> entityOpt = methodRepository.findById(methodDbId);
		if (entityOpt.isPresent()) {
			MethodEntity entity = entityOpt.get();
			updateEntity(entity, body);
			savedEntity = saveMethodEntity(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("method", methodDbId, "methodDbId");
		}

		return convertFromEntity(savedEntity);
	}

	public List<Method> saveMethods(@Valid List<MethodBaseClass> body) throws BrAPIServerException {
		List<Method> savedMethods = new ArrayList<>();
		for (MethodBaseClass request : body) {
			MethodEntity newEntity = new MethodEntity();
			updateEntity(newEntity, request);
			MethodEntity saved = saveMethodEntity(newEntity);
			savedMethods.add(convertFromEntity(saved));
		}

		return savedMethods;
	}

	public MethodEntity saveMethodEntity(MethodEntity entity) {
		return methodRepository.save(entity);
	}

	public Method getMethod(String methodDbId) throws BrAPIServerException {
		return convertFromEntity(getMethodEntity(methodDbId, HttpStatus.NOT_FOUND));
	}

	public MethodEntity getMethodEntity(String methodDbId) throws BrAPIServerException {
		return getMethodEntity(methodDbId, HttpStatus.BAD_REQUEST);
	}

	public MethodEntity getMethodEntity(String methodDbId, HttpStatus errorStatus) throws BrAPIServerException {
		MethodEntity method = null;
		if (methodDbId != null) {
			Optional<MethodEntity> entityOpt = methodRepository.findById(methodDbId);
			if (entityOpt.isPresent()) {
				method = entityOpt.get();
			} else {
				throw new BrAPIServerDbIdNotFoundException("method", methodDbId, "methodDbId");
			}
		}
		return method;
	}

	public MethodEntity updateEntity(MethodEntity entity, @Valid MethodBaseClass method) throws BrAPIServerException {

		entity.setAdditionalInfo(UpdateUtility.replaceField(method.getAdditionalInfo(), entity.getAdditionalInfoMap()));
		entity.setDescription(UpdateUtility.replaceField(method.getDescription(), entity.getDescription()));
		entity.setExternalReferences(
				UpdateUtility.replaceField(method.getExternalReferences(), entity.getExternalReferencesMap()));
		entity.setFormula(UpdateUtility.replaceField(method.getFormula(), entity.getFormula()));
		entity.setMethodClass(UpdateUtility.replaceField(method.getMethodClass(), entity.getMethodClass()));
		entity.setName(UpdateUtility.replaceField(method.getMethodName(), entity.getName()));
		entity.setReference(UpdateUtility.replaceField(method.getBibliographicalReference(), entity.getReference()));

		ontologyService.updateOntologyReference(entity, method.getOntologyReference());

		return entity;
	}

	public Method convertFromEntity(MethodEntity entity) {
		Method method = null;
		if (entity != null) {
			method = new Method();
			method.setAdditionalInfo(entity.getAdditionalInfoMap());
			method.setBibliographicalReference(entity.getReference());
			method.setDescription(entity.getDescription());
			method.setExternalReferences(entity.getExternalReferencesMap());
			method.setFormula(entity.getFormula());
			method.setMethodClass(entity.getMethodClass());
			method.setMethodDbId(entity.getId());
			method.setMethodName(entity.getName());
			method.setOntologyReference(ontologyService.convertFromEntity(entity));
		}
		return method;
	}
}
