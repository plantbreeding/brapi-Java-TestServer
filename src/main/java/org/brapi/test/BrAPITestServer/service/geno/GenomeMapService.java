package org.brapi.test.BrAPITestServer.service.geno;

import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.GenomeMapEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.LinkageGroupEntity;
import org.brapi.test.BrAPITestServer.repository.geno.GenomeMapRepository;
import org.brapi.test.BrAPITestServer.repository.geno.LinkageGroupRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.GenomeMap;
import io.swagger.model.geno.LinkageGroup;

@Service
public class GenomeMapService {

	private GenomeMapRepository genomeMapRepository;
	private LinkageGroupRepository linkageGroupRepository;

	@Autowired
	public GenomeMapService(GenomeMapRepository genomeMapRepository, LinkageGroupRepository linkageGroupRepository) {
		this.genomeMapRepository = genomeMapRepository;
		this.linkageGroupRepository = linkageGroupRepository;
	}

	public List<GenomeMap> findMaps(String commonCropName, String mapPUI, String scientificName, String type,
			String programDbId, String trialDbId, String studyDbId, Metadata metadata) {
		SearchQueryBuilder<GenomeMapEntity> searchQuery = new SearchQueryBuilder<GenomeMapEntity>(GenomeMapEntity.class);

		if (programDbId != null || trialDbId != null || studyDbId != null) {
			searchQuery = searchQuery.join("studies", "study");
		}
		
		searchQuery.appendSingle(commonCropName, "crop.cropName")
				.appendSingle(mapPUI, "mapPUI")
				.appendSingle(scientificName, "scientificName")
				.appendSingle(type, "type")
				.appendSingle(programDbId, "*study.trial.program.id")
				.appendSingle(trialDbId, "*study.trial.id")
				.appendSingle(studyDbId, "*study.id");

		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<GenomeMapEntity> page = genomeMapRepository.findAllBySearch(searchQuery, pageReq);
		List<GenomeMap> maps = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return maps;
	}

	public GenomeMap getMap(String mapDbId) throws BrAPIServerException {
		GenomeMap map = null;
		Optional<GenomeMapEntity> entityOpt = genomeMapRepository.findById(mapDbId);
		if (entityOpt.isPresent()) {
			map = convertFromEntity(entityOpt.get());
		} else {
			throw new BrAPIServerDbIdNotFoundException("map", mapDbId, HttpStatus.NOT_FOUND);
		}
		return map;
	}

	public List<LinkageGroup> findLinkageGroups(String mapDbId, Metadata metadata) {
		SearchQueryBuilder<LinkageGroupEntity> searchQuery = new SearchQueryBuilder<LinkageGroupEntity>(
				LinkageGroupEntity.class).appendSingle(mapDbId, "genomeMap.id");

		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<LinkageGroupEntity> page = linkageGroupRepository.findAllBySearch(searchQuery, pageReq);
		List<LinkageGroup> linkageGroups = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return linkageGroups;
	}

	private GenomeMap convertFromEntity(GenomeMapEntity entity) {
		GenomeMap map = new GenomeMap();
		map.setAdditionalInfo(entity.getAdditionalInfo());
		map.setComments(entity.getComments());
		if (entity.getCrop() != null)
			map.setCommonCropName(entity.getCrop().getCropName());
		map.setDocumentationURL(entity.getDocumentationURL());
		if (entity.getLinkageGroups() != null) {
			map.setLinkageGroupCount(entity.getLinkageGroups().size());
			map.setMarkerCount((int) entity.getLinkageGroups().stream().filter(lg -> lg.getMarkers() != null)
					.flatMap(lg -> lg.getMarkers().stream()).count());
		}
		map.setMapDbId(entity.getId());
		map.setMapName(entity.getMapName());
		map.setMapPUI(entity.getMapPUI());
		map.setPublishedDate(DateUtility.toOffsetDateTime(entity.getPublishedDate()));
		map.setScientificName(entity.getScientificName());
		map.setType(entity.getType());
		map.setUnit(entity.getUnit());

		return map;
	}

	private LinkageGroup convertFromEntity(LinkageGroupEntity entity) {
		LinkageGroup group = new LinkageGroup();
		group.setAdditionalInfo(entity.getAdditionalInfo());
		group.setLinkageGroupName(entity.getLinkageGroupName());
		group.setMarkerCount(entity.getMarkers().size());
		group.setMaxPosition(entity.getMaxMarkerPosition());
		return group;
	}

}
