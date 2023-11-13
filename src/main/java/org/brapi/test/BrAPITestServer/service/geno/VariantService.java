package org.brapi.test.BrAPITestServer.service.geno;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.VariantEntity;
import org.brapi.test.BrAPITestServer.repository.geno.VariantRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Variant;
import io.swagger.model.geno.VariantsSearchRequest;

@Service
public class VariantService {

	private final VariantRepository variantRepository;

	public VariantService(VariantRepository variantRepository) {
		this.variantRepository = variantRepository;
	}

	public List<Variant> findVariants(String variantDbId, String variantSetDbId, String referenceDbId,
			String referenceSetDbId, String externalReferenceId, String externalReferenceSource, Metadata metadata) {

		VariantsSearchRequest request = new VariantsSearchRequest();
		if (variantSetDbId != null)
			request.addVariantSetDbIdsItem(variantSetDbId);
		if (variantDbId != null)
			request.addVariantDbIdsItem(variantDbId);
		if (referenceDbId != null)
			request.addReferenceDbIdsItem(referenceDbId);
		if (referenceSetDbId != null)
			request.addReferenceSetDbIdsItem(referenceSetDbId);

		request.addExternalReferenceItem(externalReferenceId, null, externalReferenceSource);

		return findVariants(request, metadata);
	}

	public List<Variant> findVariants(VariantsSearchRequest request, Metadata metadata) {
		return findVariantEntities(request, metadata).stream().map(this::convertFromEntity)
				.collect(Collectors.toList());
	}

	public List<VariantEntity> findVariantEntities(VariantsSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<VariantEntity> searchQuery = new SearchQueryBuilder<VariantEntity>(VariantEntity.class);
		if (request.getCallSetDbIds() != null && !request.getCallSetDbIds().isEmpty()) {
			searchQuery = searchQuery.join("variantSet.callSets", "callSet").appendList(request.getCallSetDbIds(),
					"*callSet.id");
		}
		searchQuery = searchQuery.appendList(request.getVariantSetDbIds(), "variantSet.id")
				.appendList(request.getVariantDbIds(), "id");

		Page<VariantEntity> page = variantRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		return page.getContent();
	}

	public Variant getVariant(String variantDbId) throws BrAPIServerException {
		return convertFromEntity(getVariantEntity(variantDbId, HttpStatus.NOT_FOUND));
	}

	public VariantEntity getVariantEntity(String variantDbId) throws BrAPIServerException {
		return getVariantEntity(variantDbId, HttpStatus.BAD_REQUEST);
	}

	public VariantEntity getVariantEntity(String variantDbId, HttpStatus errorStatus) throws BrAPIServerException {
		VariantEntity variant = null;
		Optional<VariantEntity> entityOpt = variantRepository.findById(variantDbId);
		if (entityOpt.isPresent()) {
			variant = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("variant", variantDbId, errorStatus);
		}
		return variant;
	}

	private Variant convertFromEntity(VariantEntity entity) {
		Variant variant = new Variant();
		variant.setAdditionalInfo(entity.getAdditionalInfo());
		variant.setAlternateBases(entity.getAlternateBases());
		variant.setCiend(entity.getCiend());
		variant.setCipos(entity.getCipos());
		variant.setCreated(DateUtility.toOffsetDateTime(entity.getCreated()));
		variant.setEnd(entity.getEnd());
		variant.setFiltersApplied(entity.getFiltersApplied());
		variant.setFiltersFailed(entity.getFiltersFailed());
		variant.setFiltersPassed(entity.getFiltersPassed());
		variant.setReferenceBases(entity.getReferenceBases());
		if (entity.getReferenceSet() != null)
			variant.setReferenceName(entity.getReferenceSet().getReferenceSetName());
		variant.setStart(entity.getStart());
		variant.setSvlen(entity.getSvlen());
		variant.setUpdated(DateUtility.toOffsetDateTime(entity.getUpdated()));
		variant.setVariantDbId(entity.getId());
		variant.setVariantNames(Arrays.asList(entity.getVariantName()));
		variant.setVariantSetDbId(Arrays.asList(entity.getVariantSet().getId()));
		variant.setVariantType(entity.getVariantType());

		return variant;
	}

	public VariantEntity save(VariantEntity entity) {
		return variantRepository.save(entity);
	}

}
