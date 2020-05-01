package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyReferenceEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyReferenceHolder;
import org.brapi.test.BrAPITestServer.repository.pheno.OntologyRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.OntologyReference;
import io.swagger.model.OntologyReferenceDocumentationLinks;
import io.swagger.model.pheno.Ontology;

@Service
public class OntologyService {
	private OntologyRepository ontologyRepository;

	@Autowired
	public OntologyService(OntologyRepository ontologyRepository) {
		this.ontologyRepository = ontologyRepository;
	}

	public List<Ontology> findOntologies(@Valid String ontologyDbId, Metadata metadata) {
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

	public Ontology convertFromEntity(OntologyEntity entity) {
		Ontology ontology = new Ontology();
		ontology.setAdditionalInfo(entity.getAdditionalInfoMap());
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

	public OntologyEntity getOntologyEntity(String ontologyDbId) throws BrAPIServerException {
		OntologyEntity method = null;
		if (ontologyDbId != null) {
			Optional<OntologyEntity> entityOpt = ontologyRepository.findById(ontologyDbId);
			if (entityOpt.isPresent()) {
				method = entityOpt.get();
			} else {
				throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found " + ontologyDbId);
			}
		}
		return method;
	}

	public void updateOntologyReference(OntologyReferenceHolder entity, @Valid OntologyReference ontologyReference)
			throws BrAPIServerException {
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
