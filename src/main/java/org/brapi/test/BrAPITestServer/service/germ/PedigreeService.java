package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Set;

import org.brapi.test.BrAPITestServer.auth.BrapiTestServerJWTAuthFilter;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossingProjectEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.PedigreeNodeEntity;
import org.brapi.test.BrAPITestServer.repository.germ.PedigreeRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.PedigreeNode;
import io.swagger.model.germ.PedigreeNodeParents;
import io.swagger.model.germ.PedigreeNodeSiblings;
import io.swagger.model.germ.PedigreeSearchRequest;

@Service
public class PedigreeService {
	private static final Logger log = LoggerFactory.getLogger(PedigreeService.class);

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
			String externalReferenceId, String externalReferenceSource, Boolean includeParents, Boolean includeSiblings,
			Boolean includeProgeny, Boolean includeFullTree, Integer pedigreeDepth, Integer progenyDepth,
			Metadata metadata) {

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
		if (includeParents != null)
			request.setIncludeParents(includeParents);
		if (includeProgeny != null)
			request.setIncludeProgeny(includeProgeny);
		if (includeSiblings != null)
			request.setIncludeSiblings(includeSiblings);
		if (includeFullTree != null)
			request.setIncludeFullTree(includeFullTree);
		if (pedigreeDepth != null)
			request.setPedigreeDepth(pedigreeDepth);
		if (progenyDepth != null)
			request.setProgenyDepth(progenyDepth);

		request.addExternalReferenceItem(externalReferenceId, null, externalReferenceSource);

		return findPedigree(request, metadata);
	}

	public List<PedigreeNode> findPedigree(PedigreeSearchRequest request, Metadata metadata) {
		List<PedigreeNodeEntity> page = findPedigreeEntities(request, metadata);
		List<PedigreeNode> pedigreeNodes = convertFromEntities(page, request);
		return pedigreeNodes;
	}

	public List<PedigreeNodeEntity> findPedigreeEntities(PedigreeSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<PedigreeNodeEntity> searchQuery = new SearchQueryBuilder<PedigreeNodeEntity>(
				PedigreeNodeEntity.class);

		if (request.getProgramDbIds() != null || request.getProgramNames() != null || request.getTrialDbIds() != null
				|| request.getTrialNames() != null || request.getStudyDbIds() != null
				|| request.getStudyNames() != null) {
			searchQuery = searchQuery.join("germplasm.observationUnits", "obsunit")
					.appendList(request.getProgramDbIds(), "*obsunit.program.id")
					.appendList(request.getProgramNames(), "*obsunit.program.name")
					.appendList(request.getTrialDbIds(), "*obsunit.trial.id")
					.appendList(request.getTrialNames(), "*obsunit.trial.name")
					.appendList(request.getStudyDbIds(), "*obsunit.study.id")
					.appendList(request.getStudyNames(), "*obsunit.study.studyName");
		}
		if (request.getSynonyms() != null) {
			searchQuery = searchQuery.join("germplasm.synonyms", "synonym").appendList(request.getSynonyms(),
					"*synonym.synonym");
		}
		if (request.getInstituteCodes() != null) {
			searchQuery = searchQuery.join("germplasm.institutes", "institute").appendList(request.getSynonyms(),
					"*institute.instituteCode");
		}

		searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getAccessionNumbers(), "germplasm.accessionNumber")
				.appendList(request.getCollections(), "germplasm.collection")
				.appendList(request.getCommonCropNames(), "germplasm.crop.cropName")
				.appendList(request.getGermplasmDbIds(), "germplasm.id")
				.appendList(request.getGermplasmNames(), "germplasm.germplasmName")
				.appendList(request.getGermplasmPUIs(), "germplasm.germplasmPUI")
				.appendList(request.getGenus(), "germplasm.genus").appendList(request.getSpecies(), "germplasm.species")
				.appendNamesList(request.getBinomialNames(), "germplasm.genus", "germplasm.genus", "germplasm.species")
				.appendList(request.getFamilyCodes(), "familyCode");

		Page<PedigreeNodeEntity> page = pedigreeRepository.findAllBySearch(searchQuery, pageReq);

		List<PedigreeNodeEntity> filteredNodes = filterGenerations(request, page.getContent());

		filteredNodes = PagingUtility.paginateSimpleList(filteredNodes, metadata);

		return filteredNodes;
	}

	public Optional<PedigreeNodeEntity> getPedigreeNode(String germplasmDbId) {
		Optional<PedigreeNodeEntity> node = Optional.empty();
		List<PedigreeNodeEntity> nodeList = pedigreeRepository.findByGermplasm_Id(germplasmDbId);
		if (nodeList.size() == 1) {
			node = Optional.of(nodeList.get(0));
		} else if (nodeList.size() > 1) {
			log.error("multiple pedigree nodes found for a single germplasm");
		}
		return node;
	}

	public List<PedigreeNode> savePedigreeNodes(List<PedigreeNode> request) throws BrAPIServerException {
		Map<String, PedigreeNodeEntity> nodesByGermplasm = getExistingPedigreeNodes(
				request.stream().map(p -> p.getGermplasmDbId()).collect(Collectors.toList()));

		if (!nodesByGermplasm.isEmpty()) {
			String errorMsg = "The following germplasmDbIds already have existing pedigree data. Please use PUT /pedigree to update these germplasm. \n"
					+ nodesByGermplasm.keySet().toString();
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, errorMsg);
		}

		List<PedigreeNodeEntity> newEntities = new ArrayList<>();

		for (PedigreeNode node : request) {
			PedigreeNodeEntity entity = new PedigreeNodeEntity();
			updateEntity(entity, node);
			newEntities.add(entity);
		}
		// save all the new nodes without edges
		pedigreeRepository.saveAllAndFlush(newEntities);

		Map<String, PedigreeNode> updateRequest = new HashMap<>();
		for (PedigreeNode newNode : request) {
			updateRequest.put(newNode.getGermplasmDbId(), newNode);
		}
		// update the new nodes with requested edges
		List<PedigreeNode> saved = updatePedigreeNodes(updateRequest);

		return saved;
	}

	public List<PedigreeNode> updatePedigreeNodes(Map<String, PedigreeNode> request) throws BrAPIServerException {
		Map<String, PedigreeNodeEntity> nodesByGermplasm = getExistingPedigreeNodes(new ArrayList<>(request.keySet()));
		List<PedigreeNodeEntity> newEntities = new ArrayList<>();

		for (Entry<String, PedigreeNode> entry : request.entrySet()) {
			PedigreeNodeEntity entity = nodesByGermplasm.get(entry.getKey());
			if (entity != null) {
				updateEntityWithEdges(entity, entry.getValue());
				newEntities.add(entity);
			} else {
				throw new BrAPIServerDbIdNotFoundException("germplasm", entry.getKey(), HttpStatus.BAD_REQUEST);
			}
		}

		List<PedigreeNodeEntity> savedEntities = pedigreeRepository.saveAllAndFlush(newEntities);
		List<PedigreeNode> saved = convertFromEntities(savedEntities,
				new PedigreeSearchRequest().includeParents(true).includeProgeny(true).includeSiblings(true));
		return saved;
	}

	private Map<String, PedigreeNodeEntity> getExistingPedigreeNodes(List<String> germplasmDbIds) {
		PedigreeSearchRequest searchReq = new PedigreeSearchRequest();
		searchReq.setGermplasmDbIds(germplasmDbIds);
		searchReq.setIncludeParents(false);
		searchReq.setIncludeProgeny(false);
		searchReq.setIncludeSiblings(false);

		List<PedigreeNodeEntity> nodeEntities = findPedigreeEntities(searchReq, null);
		Map<String, PedigreeNodeEntity> nodesByGermplasm = new HashMap<>();

		for (PedigreeNodeEntity nodeEntity : nodeEntities) {
			if (nodeEntity.getGermplasm() != null && nodeEntity.getGermplasm().getId() != null) {
				nodesByGermplasm.put(nodeEntity.getGermplasm().getId(), nodeEntity);
			}
		}

		return nodesByGermplasm;
	}

	private List<PedigreeNodeEntity> filterGenerations(PedigreeSearchRequest request,
			List<PedigreeNodeEntity> baseNodes) {
		int pedigreeDepth = request.getPedigreeDepth();
		int progenyDepth = request.getProgenyDepth();

		if (request.isIncludeFullTree()) {
			pedigreeDepth = Integer.MAX_VALUE;
			progenyDepth = Integer.MAX_VALUE;
		}

		Set<PedigreeNodeEntity> baseNodesSet = new HashSet<>(baseNodes);
		Set<PedigreeNodeEntity> pedigreeTree = new HashSet<>(baseNodes);

		getGenerationsRecursively(baseNodesSet, pedigreeDepth, true, pedigreeTree);
		getGenerationsRecursively(baseNodesSet, progenyDepth, false, pedigreeTree);

		return new ArrayList<>(pedigreeTree);
	}

	private void getGenerationsRecursively(final Set<PedigreeNodeEntity> baseNodes, final int generations,
			final boolean traverseUp, final Set<PedigreeNodeEntity> pedigreeTree) {

		if (generations > 0) {
			Set<PedigreeNodeEntity> newGeneration = new HashSet<>();
			for (PedigreeNodeEntity node : baseNodes) {
				if (traverseUp) {
					newGeneration.addAll(node.getParentNodes());
				} else {
					newGeneration.addAll(node.getProgenyNodes());
				}
			}
			int treeSize = pedigreeTree.size();
			pedigreeTree.addAll(newGeneration);

			if (treeSize == pedigreeTree.size()) {
				// tree has not grown, boundary of the tree or loop has been reached
				return;
			}
			getGenerationsRecursively(newGeneration, generations - 1, traverseUp, pedigreeTree);
		}
	}

	private List<PedigreeNode> convertFromEntities(List<PedigreeNodeEntity> entities, PedigreeSearchRequest request) {
		List<PedigreeNode> convertedNodes = new ArrayList<>();
		for (PedigreeNodeEntity entity : entities) {
			convertedNodes.add(convertFromEntity(entity, request));
		}
		return convertedNodes;
	}

	private PedigreeNode convertFromEntity(PedigreeNodeEntity entity, PedigreeSearchRequest request) {
		PedigreeNode node = new PedigreeNode();
		if (entity != null) {
			UpdateUtility.convertFromEntity(entity, node);
			if (entity.getGermplasm() != null) {
				node.setDefaultDisplayName(entity.getGermplasm().getDefaultDisplayName());
				node.setGermplasmDbId(entity.getGermplasm().getId());
				node.setGermplasmName(entity.getGermplasm().getGermplasmName());
				node.setGermplasmPUI(entity.getGermplasm().getGermplasmPUI());
				if (entity.getGermplasm().getBreedingMethod() != null) {
					node.setBreedingMethodDbId(entity.getGermplasm().getBreedingMethod().getId());
					node.setBreedingMethodName(entity.getGermplasm().getBreedingMethod().getName());
				}
			}
			if (entity.getCrossingProject() != null) {
				node.setCrossingProjectDbId(entity.getCrossingProject().getId());
			}
			node.setCrossingYear(entity.getCrossingYear());
			node.setFamilyCode(entity.getFamilyCode());
			if (entity.getPedigreeString() == null && entity.getParentEdges() != null
					&& !entity.getParentEdges().isEmpty()) {
				List<PedigreeNodeEntity> parents = entity.getParentNodes();
				String pedStr = parents.get(0).getGermplasm().getGermplasmName();
				for (int i = 1; i < parents.size(); i++) {
					pedStr += "/" + parents.get(i).getGermplasm().getGermplasmName();
				}
				node.setPedigreeString(pedStr);
			} else {
				node.setPedigreeString(entity.getPedigreeString());
			}
			if (entity.getParentEdges() != null && request.isIncludeParents()) {
				node.setParents(entity.getParentEdges().stream().map(edge -> {
					PedigreeNodeParents parent = new PedigreeNodeParents();
					parent.setGermplasmDbId(edge.getConncetedNode().getGermplasm().getId());
					parent.setGermplasmName(edge.getConncetedNode().getGermplasm().getGermplasmName());
					parent.setParentType(edge.getParentType());
					return parent;
				}).collect(Collectors.toList()));
			}
			if (entity.getProgenyEdges() != null && request.isIncludeProgeny()) {
				node.setProgeny(entity.getProgenyEdges().stream().map(edge -> {
					PedigreeNodeParents progeny = new PedigreeNodeParents();
					progeny.setGermplasmDbId(edge.getConncetedNode().getGermplasm().getId());
					progeny.setGermplasmName(edge.getConncetedNode().getGermplasm().getGermplasmName());
					progeny.setParentType(edge.getParentType());
					return progeny;
				}).collect(Collectors.toList()));
			}
			if (entity.getSiblingEdges() != null && request.isIncludeSiblings()) {
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
	}

	private void updateEntityWithEdges(PedigreeNodeEntity entity, PedigreeNode node) throws BrAPIServerException {
		UpdateUtility.updateEntity(node, entity);
		updateEntity(entity, node);
		if (node.getParents() != null) {
			for (PedigreeNodeParents parent : node.getParents()) {
				Optional<PedigreeNodeEntity> parentNode = getPedigreeNode(parent.getGermplasmDbId());
				if (parentNode.isPresent())
					entity.addParent(parentNode.get(), parent.getParentType());
			}
		}
		if (node.getProgeny() != null) {
			for (PedigreeNodeParents child : node.getProgeny()) {
				Optional<PedigreeNodeEntity> childNode = getPedigreeNode(child.getGermplasmDbId());
				if (childNode.isPresent())
					entity.addProgeny(childNode.get(), child.getParentType());
			}
		}
		if (node.getSiblings() != null) {
			for (PedigreeNodeSiblings sibling : node.getSiblings()) {
				Optional<PedigreeNodeEntity> siblingNode = getPedigreeNode(sibling.getGermplasmDbId());
				if (siblingNode.isPresent())
					entity.addSibling(siblingNode.get());
			}
		}
	}
}
