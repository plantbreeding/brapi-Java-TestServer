package org.brapi.test.BrAPITestServer.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.brapi.test.BrAPITestServer.model.entity.LocationEntity;
import org.brapi.test.BrAPITestServer.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Location;
import io.swagger.model.Metadata;

@Service
public class LocationService {

	private LocationRepository locationRepository;
	
	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public List<Location> getLocations(String locationType, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<LocationEntity> locationsPage;
		if(locationType == null) {
			locationsPage = locationRepository.findAll(pageReq);
		}else {
			locationsPage = locationRepository.findByLocationType(locationType, pageReq);
		}
		
		List<Location> locations = locationsPage.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metaData, locationsPage);
		return locations;
	}

	public Location getLocation(String locationDbId) {
		LocationEntity entity = locationRepository.findById(locationDbId).get();
		return convertFromEntity(entity);
	}
	
	public Location convertFromEntity(LocationEntity locationEntity) {
		Location location = new Location();
		location.setAbbreviation(locationEntity.getAbbreviation());
		location.setAbreviation(locationEntity.getAbbreviation());
		location.setAltitude(new BigDecimal(locationEntity.getAltitude()));
		location.setCountryCode(locationEntity.getCountryCode());
		location.setCountryName(locationEntity.getCountryName());
		location.setInstituteAdress(locationEntity.getInstituteAddress());
		location.setInstituteAddress(locationEntity.getInstituteAddress());
		location.setInstituteName(locationEntity.getInstituteName());
		location.setLatitude(new BigDecimal(locationEntity.getLatitude()));
		location.setLocationDbId(locationEntity.getId());
		location.setLocationType(locationEntity.getLocationType());
		location.setLongitude(new BigDecimal(locationEntity.getLongitude()));
		location.setName(locationEntity.getName());
		
		Map<String, String> additionalInfo = new HashMap<>();
		locationEntity.getAdditionalInfo().forEach((entity) -> {
			additionalInfo.put(entity.getKey(), entity.getValue());
		});
		location.setAdditionalInfo(additionalInfo);
		
		return location;
	}

}
