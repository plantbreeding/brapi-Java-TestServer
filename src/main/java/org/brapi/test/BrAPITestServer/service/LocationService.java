package org.brapi.test.BrAPITestServer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.brapi.test.BrAPITestServer.model.entity.LocationEntity;
import org.brapi.test.BrAPITestServer.model.rest.Location;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	private LocationRepository locationRepository;
	
	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public List<Location> getLocations(String locationType, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<Location> locations;
		if(locationType == null) {
			locations = locationRepository.findAll(pageReq).map(this::convertFromEntity).getContent();
			metaData.getPagination().setTotalCount((int) locationRepository.count());
		}else {
			locations = locationRepository.findByLocationType(locationType, pageReq).map(this::convertFromEntity).getContent();
			metaData.getPagination().setTotalCount((int) locationRepository.countByLocationType(locationType));
		}
		
		PagingUtility.calculateMetaData(metaData);
		return locations;
	}

	public Location getLocation(String locationDbId) {
		LocationEntity entity = locationRepository.findById(locationDbId).get();
		return convertFromEntity(entity);
	}
	
	public Location convertFromEntity(LocationEntity locationEntity) {
		Location location = new Location();
		location.setAbbreviation(locationEntity.getAbbreviation());
		location.setAltitude(locationEntity.getAltitude());
		location.setCountryCode(locationEntity.getCountryCode());
		location.setCountryName(locationEntity.getCountryName());
		location.setInstituteAdress_dep(locationEntity.getInstituteAddress());
		location.setInstituteAddress(locationEntity.getInstituteAddress());
		location.setInstituteName(locationEntity.getInstituteName());
		location.setLatitude(locationEntity.getLatitude());
		location.setLocationDbId(locationEntity.getId());
		location.setLocationType(locationEntity.getLocationType());
		location.setLongitude(locationEntity.getLongitude());
		location.setName(locationEntity.getName());
		
		Map<String, String> additionalInfo = new HashMap<>();
		locationEntity.getAdditionalInfo().forEach((entity) -> {
			additionalInfo.put(entity.getKey(), entity.getValue());
		});
		location.setAdditionalInfo(additionalInfo);
		
		return location;
	}

}
