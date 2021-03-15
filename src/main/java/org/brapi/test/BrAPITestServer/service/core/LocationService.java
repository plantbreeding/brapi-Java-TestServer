package org.brapi.test.BrAPITestServer.service.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.LocationEntity;
import org.brapi.test.BrAPITestServer.repository.core.LocationRepository;
import org.brapi.test.BrAPITestServer.service.GeoJSONUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.core.Location;
import io.swagger.model.core.LocationNewRequest;
import io.swagger.model.core.LocationSearchRequest;

@Service
public class LocationService {

	private LocationRepository locationRepository;

	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public List<Location> findLocations(String locationDbId, String locationType, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) {
		LocationSearchRequest request = new LocationSearchRequest();
		if (locationType != null) 
			request.addLocationTypesItem(locationType);
		if (locationDbId != null) 
			request.addLocationDbIdsItem(locationDbId);
		if (externalReferenceID != null) 
			request.addExternalReferenceIDsItem(externalReferenceID);
		if (externalReferenceSource != null) 
			request.addExternalReferenceSourcesItem(externalReferenceSource);
		return findLocations(request, metadata);
	}

	public List<Location> findLocations(LocationSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<LocationEntity> searchQuery = new SearchQueryBuilder<LocationEntity>(LocationEntity.class)
				.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getAbbreviations(), "abbreviaion")
				.appendList(request.getCountryCodes(), "countrycode")
				.appendList(request.getCountryNames(), "countryname")
				.appendList(request.getInstituteAddresses(), "instituteaddress")
				.appendList(request.getInstituteNames(), "institutename")
				.appendList(request.getLocationDbIds(), "id")
				.appendList(request.getLocationNames(), "locationName")
				.appendList(request.getLocationTypes(), "locationType")
				.appendNumberRange(request.getAltitudeMin(), request.getAltitudeMax(), "altitude")
				.appendGeoJSONArea(request.getCoordinates());

		Page<LocationEntity> entityPage = locationRepository.findAllBySearch(searchQuery, pageReq);

		List<Location> data = entityPage.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, entityPage);

		return data;
	}

	public Location getLocation(String locationDbId) throws BrAPIServerException {
		return convertFromEntity(getLocationEntity(locationDbId));
	}

	public LocationEntity getLocationEntity(String locationDbId) throws BrAPIServerException {
		LocationEntity location = null;
		Optional<LocationEntity> entityOpt = locationRepository.findById(locationDbId);
		if (entityOpt.isPresent()) {
			location = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "locationDbId not found: " + locationDbId);
		}
		return location;
	}

	public Location updateLocation(String locationDbId, @Valid LocationNewRequest body) throws BrAPIServerException {
		LocationEntity savedEntity;
		Optional<LocationEntity> entityOpt = locationRepository.findById(locationDbId);
		if (entityOpt.isPresent()) {
			LocationEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = locationRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "locationDbId not found: " + locationDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public List<Location> saveLocations(@Valid List<LocationNewRequest> body) {
		List<Location> savedLocations = new ArrayList<>();

		for (LocationNewRequest list : body) {

			LocationEntity entity = new LocationEntity();
			updateEntity(entity, list);

			LocationEntity savedEntity = locationRepository.save(entity);

			savedLocations.add(convertFromEntity(savedEntity));
		}

		return savedLocations;
	}

	public Location convertFromEntity(LocationEntity entity) {
		Location location = new Location();
		location.setAdditionalInfo(entity.getAdditionalInfoMap());
		location.setAbbreviation(entity.getAbbreviation());
		location.setCoordinateDescription(entity.getCoordinateDescription());
		location.setCoordinateUncertainty(entity.getCoordinateUncertainty());
		location.setCountryCode(entity.getCountryCode());
		location.setCountryName(entity.getCountryName());
		location.setDocumentationURL(entity.getDocumentationURL());
		location.setEnvironmentType(entity.getEnvironmentType());
		location.setExposure(entity.getExposure());
		location.setExternalReferences(entity.getExternalReferencesMap());
		location.setInstituteAddress(entity.getInstituteAddress());
		location.setInstituteName(entity.getInstituteName());
		location.setLocationDbId(entity.getId());
		location.setLocationName(entity.getLocationName());
		location.setLocationType(entity.getLocationType());
		location.setSiteStatus(entity.getSiteStatus());
		location.setSlope(entity.getSlope());
		location.setTopography(entity.getTopography());
		location.setCoordinates(GeoJSONUtility.convertFromEntity(entity.getCoordinates()));

		return location;
	}

	private void updateEntity(LocationEntity entity, LocationNewRequest request) {
		if (request.getAdditionalInfo() != null)
			entity.setAdditionalInfo(request.getAdditionalInfo());
		if (request.getAbbreviation() != null)
			entity.setAbbreviation(request.getAbbreviation());
		if (request.getCoordinateDescription() != null)
			entity.setCoordinateDescription(request.getCoordinateDescription());
		if (request.getCoordinateUncertainty() != null)
			entity.setCoordinateUncertainty(request.getCoordinateUncertainty());
		if (request.getCountryCode() != null)
			entity.setCountryCode(request.getCountryCode());
		if (request.getCountryName() != null)
			entity.setCountryName(request.getCountryName());
		if (request.getDocumentationURL() != null)
			entity.setDocumentationURL(request.getDocumentationURL());
		if (request.getEnvironmentType() != null)
			entity.setEnvironmentType(request.getEnvironmentType());
		if (request.getExposure() != null)
			entity.setExposure(request.getExposure());
		if (request.getExternalReferences() != null)
			entity.setExternalReferences(request.getExternalReferences());
		if (request.getInstituteAddress() != null)
			entity.setInstituteAddress(request.getInstituteAddress());
		if (request.getInstituteName() != null)
			entity.setInstituteName(request.getInstituteName());
		if (request.getLocationName() != null)
			entity.setLocationName(request.getLocationName());
		if (request.getLocationType() != null)
			entity.setLocationType(request.getLocationType());
		if (request.getSiteStatus() != null)
			entity.setSiteStatus(request.getSiteStatus());
		if (request.getSlope() != null)
			entity.setSlope(request.getSlope());
		if (request.getTopography() != null)
			entity.setTopography(request.getTopography());
		if (request.getCoordinates() != null)
			entity.setCoordinates(GeoJSONUtility.convertToEntity(request.getCoordinates()));

	}

}
