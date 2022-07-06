package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossingProjectEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.PedigreeNodeEntity;
import org.brapi.test.BrAPITestServer.repository.germ.PedigreeRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.PedigreeNode;
import io.swagger.model.germ.PedigreeNodeParents;
import io.swagger.model.germ.PedigreeNodeSiblings;
import io.swagger.model.germ.PedigreeSearchRequest;

@Service
public class PedigreeService {
	private final PedigreeRepository pedigreeRepository;
	private final CrossingProjectService crossingProjectService;
	private final GermplasmService germplasmService;

	@Autowired
	public PedigreeService(PedigreeRepository pedigreeRepository, CrossingProjectService crossingProjectService,
			GermplasmService germplasmService) {
		this.pedigreeRepository = pedigreeRepository;
		this.crossingProjectService = crossingProjectService;
		this.germplasmService = germplasmService;
	}

	public List<PedigreeNode> findPedigree(String germplasmPUI, String germplasmDbId, String germplasmName,
			String accessionNumber, String collection, String binomialName, String genus, String species,
			String trialDbId, String studyDbId, String synonym, String commonCropName, String programDbId,
			String externalReferenceId, String externalReferenceSource, Metadata metadata) {

		PedigreeSearchRequest request = new PedigreeSearchRequest();
		if (germplasmPUI != null)
			request.addGermplasmPUIsItem(germplasmPUI);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (germplasmName != null)
			request.addGermplasmNamesItem(germplasmName);
		if (accessionNumber != null)
			request.addAccessionNumbersItem(accessionNumber);
		if (collection != null)
			request.addCollectionsItem(collection);
		if (binomialName != null)
			request.addBinomialNamesItem(binomialName);
		if (genus != null)
			request.addGenusItem(genus);
		if (species != null)
			request.addSpeciesItem(species);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (synonym != null)
			request.addSynonymsItem(synonym);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);

		request.addExternalReferenceItem(externalReferenceId, null, externalReferenceSource);

		return findPedigree(request, metadata);
	}

	public List<PedigreeNode> findPedigree(PedigreeSearchRequest request, Metadata metadata) {
		List<PedigreeNodeEntity> page = findPedigreeEntity(request, metadata);
		List<PedigreeNode> pedigreeNodes = page.stream().map(this::convertFromEntity).collect(Collectors.toList());
		return pedigreeNodes;
	}

	public List<PedigreeNodeEntity> findPedigreeEntity(PedigreeSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<PedigreeNodeEntity> searchQuery = new SearchQueryBuilder<PedigreeNodeEntity>(
				PedigreeNodeEntity.class);

		if (request.getProgramDbIds() != null || request.getProgramNames() != null || request.getTrialDbIds() != null
				|| request.getTrialNames() != null || request.getStudyDbIds() != null
				|| request.getStudyNames() != null) {
			searchQuery = searchQuery.join("observationUnits", "obsunit")
					.appendList(request.getProgramDbIds(), "*obsunit.program.id")
					.appendList(request.getProgramNames(), "*obsunit.program.name")
					.appendList(request.getTrialDbIds(), "*obsunit.trial.id")
					.appendList(request.getTrialNames(), "*obsunit.trial.name")
					.appendList(request.getStudyDbIds(), "*obsunit.study.id")
					.appendList(request.getStudyNames(), "*obsunit.study.studyName");
		}
		if (request.getSynonyms() != null) {
			searchQuery = searchQuery.join("synonyms", "synonym").appendList(request.getSynonyms(), "*synonym.synonym");
		}
		if (request.getInstituteCodes() != null) {
			searchQuery = searchQuery.join("institutes", "institute").appendList(request.getSynonyms(),
					"*institute.instituteCode");
		}

		searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getAccessionNumbers(), "accessionNumber")
				.appendList(request.getCollections(), "collection")
				.appendList(request.getCommonCropNames(), "crop.cropName").appendList(request.getGermplasmDbIds(), "id")
				.appendList(request.getGermplasmNames(), "germplasmName")
				.appendList(request.getGermplasmPUIs(), "germplasmPUI").appendList(request.getGenus(), "genus")
				.appendList(request.getSpecies(), "species")
				.appendNamesList(request.getBinomialNames(), "genus", "genus", "species")
				.appendList(request.getFamilyCodes(), "familyCode");

		Page<PedigreeNodeEntity> page = pedigreeRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		return page.getContent();
	}

	public List<PedigreeNode> savePedigreeNodes(List<PedigreeNode> request) throws BrAPIServerException {
		List<PedigreeNode> saved = new ArrayList<>();

		for (PedigreeNode node : request) {
			PedigreeNodeEntity entity = new PedigreeNodeEntity();
			updateEntity(entity, node);
			PedigreeNodeEntity savedEntity = pedigreeRepository.save(entity);
			saved.add(convertFromEntity(savedEntity));
		}

		return saved;
	}

	public List<PedigreeNode> updatePedigreeNodes(Map<String, PedigreeNode> request) throws BrAPIServerException {
		List<PedigreeNode> updatedNodes = new ArrayList<>();
		PedigreeSearchRequest searchReq = new PedigreeSearchRequest();
		searchReq.setGermplasmDbIds(new ArrayList<>(request.keySet()));
		List<PedigreeNodeEntity> nodeEntities = findPedigreeEntity(searchReq, null);
		Map<String, PedigreeNodeEntity> nodesByGermplasm = new HashMap<>();

		for (PedigreeNodeEntity nodeEntity : nodeEntities) {
			if (nodeEntity.getGermplasm() != null && nodeEntity.getGermplasm().getId() != null) {
				nodesByGermplasm.put(nodeEntity.getGermplasm().getId(), nodeEntity);
			}
		}

		for (Entry<String, PedigreeNode> entry : request.entrySet()) {
			PedigreeNodeEntity entity = nodesByGermplasm.get(entry.getKey());
			if (entity != null) {
				updateEntity(entity, entry.getValue());
				PedigreeNodeEntity savedEntity = pedigreeRepository.save(entity);
				updatedNodes.add(convertFromEntity(savedEntity));
			} else {
				throw new BrAPIServerDbIdNotFoundException("germplasm", entry.getKey());
			}

		}
		return updatedNodes;
	}

	private PedigreeNode convertFromEntity(PedigreeNodeEntity entity) {
		PedigreeNode node = new PedigreeNode();
		if (entity != null) {
			UpdateUtility.convertFromEntity(entity, node);
			if (entity.getGermplasm() != null) {
				node.setDefaultDisplayName(entity.getGermplasm().getDefaultDisplayName());
				node.setGermplasmDbId(entity.getGermplasm().getId());
				node.setGermplasmName(entity.getGermplasm().getGermplasmName());
				node.setGermplasmPUI(entity.getGermplasm().getGermplasmPUI());
				node.setBreedingMethodDbId(entity.getGermplasm().getBreedingMethod().getId());
				node.setBreedingMethodName(entity.getGermplasm().getBreedingMethod().getName());
			}
			if (entity.getCrossingProject() != null) {
				node.setCrossingProjectDbId(entity.getCrossingProject().getId());
			}
			node.setCrossingYear(entity.getCrossingYear());
			node.setFamilyCode(entity.getFamilyCode());
			node.setPedigreeString(entity.getPedigreeString());
			if (entity.getParentEdges() != null) {
				node.setParents(entity.getParentEdges().stream().map(edge -> {
					PedigreeNodeParents parent = new PedigreeNodeParents();
					parent.setGermplasmDbId(edge.getConncetedNode().getGermplasm().getId());
					parent.setGermplasmName(edge.getConncetedNode().getGermplasm().getGermplasmName());
					parent.setParentType(edge.getParentType());
					return parent;
				}).collect(Collectors.toList()));
			}
			if (entity.getProgenyEdges() != null) {
				node.setProgeny(entity.getProgenyEdges().stream().map(edge -> {
					PedigreeNodeParents progeny = new PedigreeNodeParents();
					progeny.setGermplasmDbId(edge.getConncetedNode().getGermplasm().getId());
					progeny.setGermplasmName(edge.getConncetedNode().getGermplasm().getGermplasmName());
					progeny.setParentType(edge.getParentType());
					return progeny;
				}).collect(Collectors.toList()));
			}
			if (entity.getSiblingEdges() != null) {
				node.setSiblings(entity.getSiblingNodes().stream().map(sibNode -> {
					PedigreeNodeSiblings progeny = new PedigreeNodeSiblings();
					progeny.setGermplasmDbId(sibNode.getGermplasm().getId());
					progeny.setGermplasmName(sibNode.getGermplasm().getGermplasmName());
					return progeny;
				}).collect(Collectors.toList()));
			}
		}
		return node;
	}

	private void updateEntity(PedigreeNodeEntity entity, PedigreeNode node) throws BrAPIServerException {
		UpdateUtility.updateEntity(node, entity);

		if (node.getCrossingYear() != null)
			entity.setCrossingYear(node.getCrossingYear());
		if (node.getFamilyCode() != null)
			entity.setFamilyCode(node.getFamilyCode());
		if (node.getPedigreeString() != null)
			entity.setPedigreeString(null);

		if (node.getCrossingProjectDbId() != null) {
			CrossingProjectEntity crossingProject = crossingProjectService
					.getCrossingProjectEntity(node.getCrossingProjectDbId());
			entity.setCrossingProject(crossingProject);
		}
		if (node.getGermplasmDbId() != null) {
			GermplasmEntity germplasm = germplasmService.getGermplasmEntity(node.getGermplasmDbId());
			entity.setGermplasm(germplasm);
		}
		if (node.getParents() != null) {
			for (PedigreeNodeParents parent : node.getParents()) {
				GermplasmEntity germplasm = germplasmService.getGermplasmEntity(parent.getGermplasmDbId());
				entity.addParent(germplasm.getPedigree(), parent.getParentType());
			}
		}
		if (node.getProgeny() != null) {
			for (PedigreeNodeParents child : node.getProgeny()) {
				GermplasmEntity germplasm = germplasmService.getGermplasmEntity(child.getGermplasmDbId());
				entity.addProgeny(germplasm.getPedigree(), child.getParentType());
			}
		}
		if (node.getSiblings() != null) {
			for (PedigreeNodeSiblings sibling : node.getSiblings()) {
				GermplasmEntity germplasm = germplasmService.getGermplasmEntity(sibling.getGermplasmDbId());
				entity.addSibling(germplasm.getPedigree());
			}
		}
	}
}
