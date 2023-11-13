package org.brapi.test.BrAPITestServer.service.geno;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.CallSetEntity;
import org.brapi.test.BrAPITestServer.repository.geno.CallSetRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.CallSet;
import io.swagger.model.geno.CallSetsSearchRequest;

@Service
public class CallSetService {

	private final CallSetRepository callSetRepository;

	public CallSetService(CallSetRepository callSetRepository) {
		this.callSetRepository = callSetRepository;
	}

	public List<CallSet> findCallSets(String callSetDbId, String callSetName, String variantSetDbId, String sampleDbId,
			String germplasmDbId, String externalReferenceId, String externalReferenceSource, Metadata metadata) {
		CallSetsSearchRequest request = new CallSetsSearchRequest();
		if (callSetDbId != null)
			request.addCallSetDbIdsItem(callSetDbId);
		if (callSetName != null)
			request.addCallSetNamesItem(callSetName);
		if (variantSetDbId != null)
			request.addVariantSetDbIdsItem(variantSetDbId);
		if (sampleDbId != null)
			request.addSampleDbIdsItem(sampleDbId);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);

		request.addExternalReferenceItem(externalReferenceId, null, externalReferenceSource);
		return findCallSets(request, metadata);
	}

	public List<CallSet> findCallSets(CallSetsSearchRequest request, Metadata metadata) {
		return findCallSetEntities(request, metadata).stream().map(this::convertFromEntity).collect(Collectors.toList());
	}

	public List<CallSetEntity> findCallSetEntities(CallSetsSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<CallSetEntity> searchQuery = new SearchQueryBuilder<CallSetEntity>(CallSetEntity.class);
		if(request.getVariantSetDbIds() != null) {
			searchQuery = searchQuery.join("variantSets", "variantSet")
					.appendList(request.getVariantSetDbIds(), "*variantSet.id");
		}
		
		searchQuery = searchQuery.appendList(request.getCallSetDbIds(), "id")
				.appendList(request.getCallSetNames(), "callSetName")
				.appendList(request.getGermplasmDbIds(), "sample.germplasm.id")
				.appendList(request.getGermplasmNames(), "sample.germplasm.germplasmName")
				.appendList(request.getSampleDbIds(), "sample.id")
				.appendList(request.getSampleNames(), "sample.sampleName");

		Page<CallSetEntity> page = callSetRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		return page.getContent();
	}

	public CallSet getCallSet(String callSetDbId) throws BrAPIServerException {
		return convertFromEntity(getCallSetEntity(callSetDbId, HttpStatus.NOT_FOUND));
	}

	public CallSetEntity getCallSetEntity(String callSetDbId) throws BrAPIServerException {
		return getCallSetEntity(callSetDbId, HttpStatus.BAD_REQUEST);
	}

	public CallSetEntity getCallSetEntity(String callSetDbId, HttpStatus errorStatus) throws BrAPIServerException {
		CallSetEntity callSet = null;
		Optional<CallSetEntity> entityOpt = callSetRepository.findById(callSetDbId);
		if (entityOpt.isPresent()) {
			callSet = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("callSet", callSetDbId, errorStatus);
		}
		return callSet;
	}

	private CallSet convertFromEntity(CallSetEntity entity) {
		CallSet callSet = new CallSet();
		callSet.setAdditionalInfo(entity.getAdditionalInfo());
		callSet.setCallSetDbId(entity.getId());
		callSet.setCallSetName(entity.getCallSetName());
		callSet.setCreated(DateUtility.toOffsetDateTime(entity.getCreated()));
		if (entity.getSample() != null) {
			callSet.setSampleDbId(entity.getSample().getId());
			if (entity.getSample().getObservationUnit() != null && entity.getSample().getObservationUnit().getStudy() != null)
				callSet.setStudyDbId(entity.getSample().getObservationUnit().getStudy().getId());
		}
		callSet.setUpdated(DateUtility.toOffsetDateTime(entity.getUpdated()));
		if (entity.getVariantSets() != null)
			callSet.setVariantSetDbIds(entity.getVariantSets().stream().map(e -> e.getId()).collect(Collectors.toList()));

		return callSet;
	}

	public CallSetEntity save(CallSetEntity entity) {
		return callSetRepository.save(entity);
	}
}
