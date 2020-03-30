package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.SeasonEntity;
import org.brapi.test.BrAPITestServer.repository.core.SeasonRepository;
import org.brapi.test.BrAPITestServer.utility.PagingUtility;
import org.brapi.test.BrAPITestServer.utility.SearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.common.Metadata;
import io.swagger.model.core.Season;

@Service
public class SeasonService {

	private SeasonRepository seasonRepository;

	@Autowired
	public SeasonService(SeasonRepository seasonRepository) {
		this.seasonRepository = seasonRepository;
	}
	
	public List<Season> findSeasons(String seasonDbId, String season, Integer year, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<SeasonEntity> searchQuery = new SearchQueryBuilder<SeasonEntity>(SeasonEntity.class);
		if (seasonDbId != null) 
			searchQuery = searchQuery.appendSingle(seasonDbId, "id");
		if (season != null) 
			searchQuery = searchQuery.appendSingle(season, "season");
		if (year != null) 
			searchQuery = searchQuery.appendSingle(year, "year");

		Page<SeasonEntity> entityPage = seasonRepository.findAllBySearch(searchQuery, pageReq);

		List<Season> data = entityPage.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, entityPage);

		return data;
	}

	public Season getSeason(String seasonDbId) throws BrAPIServerException {
		Season season = null;
		Optional<SeasonEntity> entityOpt = seasonRepository.findById(seasonDbId);
		if (entityOpt.isPresent()) {
			SeasonEntity entity = entityOpt.get();
			season = convertFromEntity(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found!");
		}
		return season;
	}

	public Season updateSeason(String seasonDbId, @Valid Season body) throws BrAPIServerException {
		SeasonEntity savedEntity;
		Optional<SeasonEntity> entityOpt = seasonRepository.findById(seasonDbId);
		if (entityOpt.isPresent()) {
			SeasonEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = seasonRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found!");
		}

		return convertFromEntity(savedEntity);
	}

	public List<Season> saveSeasons(@Valid List<Season> body) {
		List<Season> savedSeasons = new ArrayList<>();

		for (Season list : body) {

			SeasonEntity entity = new SeasonEntity();
			updateEntity(entity, list);

			SeasonEntity savedEntity = seasonRepository.save(entity);

			savedSeasons.add(convertFromEntity(savedEntity));
		}

		return savedSeasons;
	}

	public Season convertFromEntity(SeasonEntity entity) {
		Season season = new Season();
		season.setSeasonName(entity.getSeason());
		season.setSeasonDbId(entity.getId());
		season.setYear(entity.getYear());

		return season;
	}

	private void updateEntity(SeasonEntity entity, Season request) {
		if (request.getSeasonName() != null)
			entity.setSeason(request.getSeasonName());
		if (request.getYear() != null)
			entity.setYear(request.getYear());

	}

}
