package org.brapi.test.BrAPITestServer.service.geno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.SampleEntity;
import org.brapi.test.BrAPITestServer.repository.geno.PlateRepository;
import org.springframework.stereotype.Service;

import io.swagger.model.geno.Plate;
import io.swagger.model.geno.Sample;
import io.swagger.model.geno.SampleNewRequest;

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
			throw new BrAPIServerDbIdNotFoundException("plate", plateDbId);
		}
		return plate;
	}
	
	public List<Plate> savePlates(@Valid List<Plate> body) throws BrAPIServerException {
		List<Plate> savedPlates = new ArrayList<>();

		for (Plate plate : body) {
			PlateEntity entity = new PlateEntity();
			updateEntity(entity, plate);
			PlateEntity savedEntity = plateRepository.save(entity);
			savedPlates.add(convertFromEntity(savedEntity));
		}

		return savedPlates;
	}

	private void updateEntity(PlateEntity entity, Plate plate) {
		if(plate.getPlateName() != null ) {
			entity.setPlateName(plate.getPlateName());
		}
		
	}

	private Plate convertFromEntity(PlateEntity savedEntity) {
		Plate plate = new Plate();
		plate.setPlateDbId(savedEntity.getId());
		plate.setPlateName(savedEntity.getPlateName());
		return plate;
	}

}
