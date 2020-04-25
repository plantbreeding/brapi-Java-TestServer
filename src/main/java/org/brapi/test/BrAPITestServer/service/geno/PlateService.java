package org.brapi.test.BrAPITestServer.service.geno;

import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.PlateEntity;
import org.brapi.test.BrAPITestServer.repository.geno.PlateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PlateService {
	private final PlateRepository plateRepository;

	public PlateService(PlateRepository plateRepository) {
		super();
		this.plateRepository = plateRepository;
	}

	public PlateEntity getPlateEntity(String plateDbId) throws BrAPIServerException {
		PlateEntity plate = null;
		Optional<PlateEntity> entityOpt = plateRepository.findById(plateDbId);
		if (entityOpt.isPresent()) {
			plate = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + plateDbId);
		}
		return plate;
	}
}
