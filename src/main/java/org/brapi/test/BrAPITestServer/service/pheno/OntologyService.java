package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyReferenceEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyReferenceHolder;
import org.brapi.test.BrAPITestServer.repository.pheno.OntologyRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.OntologyReference;
import io.swagger.model.OntologyReferenceDocumentationLinks;
import io.swagger.model.pheno.Ontology;
import io.swagger.model.pheno.OntologyNewRequest;

@Service
public class OntologyService {
	private OntologyRepository ontologyRepository;

	@Autowired
	public OntologyService(OntologyRepository ontologyRepository) {
		this.ontologyRepository = ontologyRepository;
	}

	public List<Ontology> findOntologies(String ontologyDbId, String ontologyName, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		List<Ontology> ontologies = new ArrayList<>();
		if (ontologyDbId == null) {
			Page<OntologyEntity> ontologiesPage = ontologyRepository.findAll(pageReq);
			PagingUtility.calculateMetaData(metadata, ontologiesPage);
			ontologies = ontologiesPage.map(this::convertFromEntity).getContent();
		} else {
			Optional<OntologyEntity> ontologyOpt = ontologyRepository.findById(ontologyDbId);
			if (ontologyOpt.isPresent()) {
				ontologies.add(convertFromEntity(ontologyOpt.get()));
				metadata.getPagination().setCurrentPage(0);
				metadata.getPagination().setTotalCount(1);
				metadata.getPagination().setTotalPages(1);
			}
		}
		return ontologies;
	}

	public Ontology getOntology(String ontologyDbId) throws BrAPIServerException {
		return convertFromEntity(getOntologyEntity(ontologyDbId, HttpStatus.NOT_FOUND));
	}

	public List<Ontology> saveOntologies(List<OntologyNewRequest> body) {
		List<Ontology> savedOntologies = new ArrayList<>();
		for (OntologyNewRequest request : body) {
			OntologyEntity newEntity = new OntologyEntity();
			updateEntity(newEntity, request);
			OntologyEntity saved = ontologyRepository.save(newEntity);
			savedOntologies.add(convertFromEntity(saved));
		}

		return savedOntologies;
	}

	public Ontology updateOntologies(String ontologyDbId, OntologyNewRequest body) throws BrAPIServerException {
		OntologyEntity entity = getOntologyEntity(ontologyDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, body);
		OntologyEntity savedEntity = ontologyRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	public Ontology convertFromEntity(OntologyEntity entity) {
		Ontology ontology = new Ontology();
		UpdateUtility.convertFromEntity(entity, ontology);

		ontology.setAuthors(entity.getAuthors());
		ontology.setCopyright(entity.getCopyright());
		ontology.setDescription(entity.getDescription());
		ontology.setDocumentationURL(entity.getDocumentationURL());
		ontology.setLicence(entity.getLicence());
		ontology.setOntologyDbId(entity.getId());
		ontology.setOntologyName(entity.getOntologyName());
		ontology.setVersion(entity.getVersion());
		return ontology;
	}

	private void updateEntity(OntologyEntity entity, OntologyNewRequest request) {
		UpdateUtility.updateEntity(request, entity);

		if (request.getAuthors() != null)
			entity.setAuthors(request.getAuthors());
		if (request.getCopyright() != null)
			entity.setCopyright(request.getCopyright());
		if (request.getDescription() != null)
			entity.setDescription(request.getDescription());
		if (request.getDocumentationURL() != null)
			entity.setDocumentationURL(request.getDocumentationURL());
		if (request.getLicence() != null)
			entity.setLicence(request.getLicence());
		if (request.getOntologyName() != null)
			entity.setOntologyName(request.getOntologyName());
		if (request.getVersion() != null)
			entity.setVersion(request.getVersion());

	}

	public OntologyEntity getOntologyEntity(String ontologyDbId) throws BrAPIServerException {
		return getOntologyEntity(ontologyDbId, HttpStatus.BAD_REQUEST);
	}

	public OntologyEntity getOntologyEntity(String ontologyDbId, HttpStatus errorStatus) throws BrAPIServerException {
		OntologyEntity ontology = null;
		if (ontologyDbId != null) {
			Optional<OntologyEntity> entityOpt = ontologyRepository.findById(ontologyDbId);
			if (entityOpt.isPresent()) {
				ontology = entityOpt.get();
			} else {
				throw new BrAPIServerDbIdNotFoundException("ontology", ontologyDbId, errorStatus);
			}
		}else {
			throw new BrAPIServerDbIdNotFoundException("ontology", ontologyDbId, errorStatus);
		}
		return ontology;
	}

	public void updateOntologyReference(OntologyReferenceHolder entity, Optional<OntologyReference> ontologyRef)
			throws BrAPIServerException {

		if (ontologyRef != null) {
			if (ontologyRef.isPresent()) {
				OntologyReference ontologyReference = ontologyRef.get();
				if (ontologyReference.getOntologyDbId() != null) {
					OntologyEntity ontology = getOntologyEntity(ontologyReference.getOntologyDbId());
					entity.setOntology(ontology);
				}
				if (ontologyReference.getDocumentationLinks() != null) {
					entity.setOntologyReference(new ArrayList<>());
					for (OntologyReferenceDocumentationLinks docLink : ontologyReference.getDocumentationLinks()) {
						OntologyReferenceEntity ref = new OntologyReferenceEntity();
						ref.setType(docLink.getType());
						ref.setURL(docLink.getURL());
						entity.getOntologyReference().add(ref);
					}
				}
			} else {
				entity.setOntology(null);
				entity.setOntologyReference(null);
			}
		}
	}

	public OntologyReference convertFromEntity(OntologyReferenceHolder entity) {
		OntologyReference ontologyReference = null;
		if (entity.getOntology() != null) {
			ontologyReference = new OntologyReference();
			ontologyReference.setOntologyDbId(entity.getOntology().getId());
			ontologyReference.setOntologyName(entity.getOntology().getOntologyName());
			ontologyReference.setVersion(entity.getOntology().getVersion());
			if (entity.getOntologyReference() != null) {
				ontologyReference.setDocumentationLinks(new ArrayList<>());
				for (OntologyReferenceEntity refEntity : entity.getOntologyReference()) {
					OntologyReferenceDocumentationLinks docLink = new OntologyReferenceDocumentationLinks();
					docLink.setType(refEntity.getType());
					docLink.setURL(refEntity.getURL());
					ontologyReference.getDocumentationLinks().add(docLink);
				}
			}
		}

		return ontologyReference;
	}
}
