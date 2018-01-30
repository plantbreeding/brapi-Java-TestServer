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
		List<GenomeMapSummary> summaries;
		if (speciesId != null && type != null) {
			summaries = genomeMapRepository
					.findBySpeciesAndType(speciesId, type, PagingUtility.getPageRequest(metaData))
					.map(this::convertFromEntity).getContent();
		} else if (speciesId != null) {
			summaries = genomeMapRepository.findBySpecies(speciesId, PagingUtility.getPageRequest(metaData))
					.map(this::convertFromEntity).getContent();
		} else if (type != null) {
			summaries = genomeMapRepository.findByType(type, PagingUtility.getPageRequest(metaData))
					.map(this::convertFromEntity).getContent();
		} else {
			summaries = genomeMapRepository.findAll(PagingUtility.getPageRequest(metaData)).map(this::convertFromEntity)
					.getContent();
		}

		return summaries;

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
				linkageGroup.setLinkageGroupDbId(linkageGroupEntity.getLinkageGroupName());
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

			detail.setLinkageGroups_dep(groups);
			detail.setData(groups);
		}
		return detail;
	}

	public List<GenomeMapData> getMapPositions(String mapDbId, String linkageGroupName, int minPosition, int maxPosition,
			MetaData metaData) {
		List<GenomeMapData> data;
		if (linkageGroupName == null) {
			data = markerRepository.findAllByLinkageGroup_GenomeMapDbId(mapDbId, PagingUtility.getPageRequest(metaData))
					.stream().filter((entity) -> {
						int loc = Integer.parseInt(entity.getLocation());
						if (loc > maxPosition || loc < minPosition) {
							return false;
						}
						return true;
					}).map(this::convertFromEntity).collect(Collectors.toList());
		} else {
			data = markerRepository.findAllByLinkageGroup_IdAndLinkageGroup_GenomeMapDbId(linkageGroupName, mapDbId,
					PagingUtility.getPageRequest(metaData)).stream().filter((entity) -> {
						int loc = Integer.parseInt(entity.getLocation());
						if (loc > maxPosition || loc < minPosition) {
							return false;
						}
						return true;
					}).map(this::convertFromEntity).collect(Collectors.toList());
		}
		return data;
	}

	private GenomeMapData convertFromEntity(MarkerEntity entity) {
		GenomeMapData marker = new GenomeMapData();
		marker.setLinkageGroup(entity.getLinkageGroup().getLinkageGroupName());
		marker.setLocation(entity.getLocation());
		marker.setMarkerDbId(entity.getId());
		marker.setMarkerName(entity.getMarkerName());
		return marker;
	}

}
