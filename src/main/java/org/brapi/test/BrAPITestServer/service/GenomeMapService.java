package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.GenomeMapEntity;
import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapData;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapDetail;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapSummary;
import org.brapi.test.BrAPITestServer.model.rest.LinkageGroup;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.GenomeMapRepository;
import org.brapi.test.BrAPITestServer.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenomeMapService {

	private GenomeMapRepository genomeMapRepository;
	private MarkerRepository markerRepository;

	@Autowired
	public GenomeMapService(GenomeMapRepository genomeMapRepository, MarkerRepository markerRepository) {
		this.genomeMapRepository = genomeMapRepository;
		this.markerRepository = markerRepository;
	}

	public List<GenomeMapSummary> getMapSummaries(String speciesId, String type, MetaData metaData) {
		Page<GenomeMapSummary> summaries;
		if (speciesId != null && type != null) {
			summaries = genomeMapRepository
					.findBySpeciesAndType(speciesId, type, PagingUtility.getPageRequest(metaData))
					.map(this::convertFromEntity);
		} else if (speciesId != null) {
			summaries = genomeMapRepository.findBySpecies(speciesId, PagingUtility.getPageRequest(metaData))
					.map(this::convertFromEntity);
		} else if (type != null) {
			summaries = genomeMapRepository.findByType(type, PagingUtility.getPageRequest(metaData))
					.map(this::convertFromEntity);
		} else {
			summaries = genomeMapRepository.findAll(PagingUtility.getPageRequest(metaData)).map(this::convertFromEntity);
		}

		PagingUtility.calculateMetaData(metaData, summaries);
		return summaries.getContent();

	}

	private GenomeMapSummary convertFromEntity(GenomeMapEntity entity) {
		GenomeMapSummary summary = new GenomeMapSummary();
		summary.setComments(entity.getComments());
		summary.setMapDbId(entity.getId());
		summary.setName(entity.getName());
		summary.setPublishedDate(entity.getPublishedDate());
		summary.setSpecies(entity.getSpecies());
		summary.setType(entity.getType());
		summary.setUnit(entity.getUnit());

		summary.setLinkageGroupCount(entity.getLinkageGroups().size());
		entity.getLinkageGroups().forEach((group) -> {
			summary.setMarkerCount(summary.getMarkerCount() + group.getMarkers().size());
		});
		return summary;
	}

	public GenomeMapDetail getMapDetail(String mapDbId) {
		Optional<GenomeMapEntity> entityOption = genomeMapRepository.findById(mapDbId);
		GenomeMapDetail detail = null;
		if (entityOption.isPresent()) {
			GenomeMapEntity entity = entityOption.get();
			detail = new GenomeMapDetail();
			detail.setMapDbId(entity.getId());
			detail.setName(entity.getName());
			detail.setType(entity.getType());
			detail.setUnit(entity.getUnit());
			
			List<LinkageGroup> groups = entity.getLinkageGroups()
					.stream()
					.map((linkageGroupEntity) -> {
				LinkageGroup linkageGroup = new LinkageGroup();
				linkageGroup.setLinkageGroupName(linkageGroupEntity.getLinkageGroupName());
				linkageGroup.setMarkerCount(linkageGroupEntity.getMarkers().size());
				int maxPosition = 0;
				for (MarkerEntity marker : linkageGroupEntity.getMarkers()) {
					int markerPos = Integer.parseInt(marker.getLocation());
					if (markerPos > maxPosition) {
						maxPosition = markerPos;
					}
				}
				linkageGroup.setMaxPosition(maxPosition);
				return linkageGroup;
			}).collect(Collectors.toList());

			detail.setLinkageGroups(groups);
			detail.setData(groups);
		}
		return detail;
	}

	public List<GenomeMapData> getMapPositions(String mapDbId, String linkageGroupName, int minPosition, int maxPosition,
			MetaData metaData) {
		Page<MarkerEntity> page;
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		if (linkageGroupName == null) {
			page = markerRepository.findAllByLinkageGroup_GenomeMapDbId(mapDbId, pageReq);
		} else {
			page = markerRepository.findAllByLinkageGroup_LinkageGroupNameAndLinkageGroup_GenomeMapDbId(linkageGroupName, mapDbId, pageReq);
		}
		PagingUtility.calculateMetaData(metaData, page);
		return page.stream()
				.filter((entity) -> { 
					return positionFilter(entity.getLocation(), minPosition, maxPosition);
				})
				.map(this::convertFromEntity)
				.collect(Collectors.toList());
	}

	private boolean positionFilter(String location, int minPosition, int maxPosition) {
		int loc = Integer.parseInt(location);
		return ((loc <= maxPosition || maxPosition < 0) && (loc >= minPosition || minPosition < 0));
	}

	private GenomeMapData convertFromEntity(MarkerEntity entity) {
		GenomeMapData marker = new GenomeMapData();
		marker.setLinkageGroupName(entity.getLinkageGroup().getLinkageGroupName());
		marker.setLocation(entity.getLocation());
		marker.setMarkerDbId(entity.getId());
		marker.setMarkerName(entity.getMarkerName());
		return marker;
	}

}
