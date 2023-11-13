package org.brapi.test.BrAPITestServer.service.geno;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.geno.MarkerPositionEntity;
import org.brapi.test.BrAPITestServer.repository.geno.MarkerPositionRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.MarkerPositionSearchRequest;
import io.swagger.model.geno.MarkerPosition;

@Service
public class MarkerPositionService {

	private final MarkerPositionRepository markerPositionRepository;

	public MarkerPositionService(MarkerPositionRepository markerPositionRepository) {
		this.markerPositionRepository = markerPositionRepository;
	}

	public List<MarkerPosition> findMarkerPositions(String mapDbId, String linkageGroupName, String variantDbId,
			Integer maxPosition, Integer minPosition, Metadata metadata) {
		MarkerPositionSearchRequest request = new MarkerPositionSearchRequest();
		if (mapDbId != null)
			request.addMapDbIdsItem(mapDbId);
		if (linkageGroupName != null)
			request.addLinkageGroupNamesItem(linkageGroupName);
		if (variantDbId != null)
			request.addVariantDbIdsItem(variantDbId);
		request.setMinPosition(minPosition);
		request.setMaxPosition(maxPosition);

		return findMarkerPositions(request, metadata);
	}

	public List<MarkerPosition> findMarkerPositions(MarkerPositionSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<MarkerPositionEntity> searchQuery = new SearchQueryBuilder<MarkerPositionEntity>(
				MarkerPositionEntity.class).appendList(request.getLinkageGroupNames(), "linkageGroup.linkageGroupName")
						.appendList(request.getVariantDbIds(), "variant.id")
						.appendList(request.getMapDbIds(), "linkageGroup.genomeMap.id")
						.appendNumberRange(request.getMinPosition(), request.getMaxPosition(), "position");

		Page<MarkerPositionEntity> page = markerPositionRepository.findAllBySearch(searchQuery, pageReq);
		List<MarkerPosition> markerPositions = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return markerPositions;
	}

	private MarkerPosition convertFromEntity(MarkerPositionEntity entity) {
		MarkerPosition position = new MarkerPosition();
		position.setAdditionalInfo(entity.getAdditionalInfo());
		if (entity.getLinkageGroup() != null) {
			position.setLinkageGroupName(entity.getLinkageGroup().getLinkageGroupName());
			if (entity.getLinkageGroup().getGenomeMap() != null) {
				position.setMapDbId(entity.getLinkageGroup().getGenomeMap().getId());
				position.setMapName(entity.getLinkageGroup().getGenomeMap().getMapName());
			}
		}
		position.setPosition(entity.getPosition());
		if (entity.getVariant() != null) {
			position.setVariantDbId(entity.getVariant().getId());
			position.setVariantName(entity.getVariant().getVariantName());
		}
		return position;
	}

}
