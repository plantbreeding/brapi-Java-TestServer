package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyInterface;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyReferenceEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.OntologyReferenceEntity.OntologyReferenceTypeEnum;
import org.brapi.test.BrAPITestServer.repository.pheno.OntologyRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.OntologyReference;
import io.swagger.model.OntologyReferenceDocumentationLinks;
import io.swagger.model.OntologyReferenceDocumentationLinks.TypeEnum;
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
			if(ontologyOpt.isPresent()) {
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

	public OntologyReference convertFromEntityToRef(OntologyEntity ontology) {
		OntologyReference oRef = null;
		if (ontology != null) {
			oRef = new OntologyReference();
			oRef.setOntologyDbId(ontology.getId());
			oRef.setOntologyName(ontology.getOntologyName());
			oRef.setVersion(ontology.getVersion());
			oRef.setDocumentationLinks(ontology.getDocumentationLinks().stream().map((entity -> {
				OntologyReferenceDocumentationLinks link = new OntologyReferenceDocumentationLinks();
				link.setType(TypeEnum.WEBPAGE);
				link.setURL(entity);
				return link;
			})).collect(Collectors.toList()));
		}
		return oRef;
	}

	private void updateOntologyReference(OntologyInterface entity, OntologyReference ontologyReference) {
		if (entity != null && ontologyReference != null) {
			Optional<OntologyEntity> ontologyOpt = ontologyRepository.findById(ontologyReference.getOntologyDbId());
			if (ontologyOpt.isPresent()) {
				// if (ontologyOpt.isPresent() && entity.getId() != null &&
				// !entity.getId().isEmpty()) {
				entity.setOntology(ontologyOpt.get());
				entity.setOntologyReference(ontologyReference.getDocumentationLinks().stream().map((link) -> {
					OntologyReferenceEntity e = new OntologyReferenceEntity();
					e.setType(OntologyReferenceTypeEnum.fromValue(link.getType().toString()));
					e.setURL(link.getURL());
					return e;
				}).collect(Collectors.toList()));
			}
		}
	}

	public OntologyEntity updateEntityFromRef(@Valid OntologyReference ontologyReference) {
		// TODO Auto-generated method stub
		return null;
	}

}
