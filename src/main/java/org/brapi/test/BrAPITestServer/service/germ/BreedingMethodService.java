package org.brapi.test.BrAPITestServer.service.germ;

import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.BreedingMethodEntity;
import org.brapi.test.BrAPITestServer.repository.germ.BreedingMethodRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.BreedingMethod;

@Service
public class BreedingMethodService {
	
	private final BreedingMethodRepository breedingMethodRepository;
	
	public BreedingMethodService(BreedingMethodRepository breedingMethodRepository) {
		this.breedingMethodRepository = breedingMethodRepository;
	}

	public List<BreedingMethod> findBreedingMethods(Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<BreedingMethodEntity> page = breedingMethodRepository.findAll(pageReq);
		List<BreedingMethod> breedingMethods = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return breedingMethods;
	}

	public BreedingMethod getBreedingMethod(String breedingMethodDbId) throws BrAPIServerException {
		return convertFromEntity(getBreedingMethodEntity(breedingMethodDbId));
	}

	private BreedingMethodEntity getBreedingMethodEntity(String breedingMethodDbId) throws BrAPIServerException {
		BreedingMethodEntity breedingMethodEntity = null;
		Optional<BreedingMethodEntity> entityOpt = breedingMethodRepository.findById(breedingMethodDbId);
		if (entityOpt.isPresent()) {
			breedingMethodEntity = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + breedingMethodDbId);
		}
		return breedingMethodEntity;
	}

	private BreedingMethod convertFromEntity(BreedingMethodEntity entity) {
		BreedingMethod method = new BreedingMethod();
		method.setAbbreviation(entity.getAbbreviation());
		method.setBreedingMethodDbId(entity.getId());
		method.setBreedingMethodName(entity.getName());
		method.setDescription(entity.getDescription());
		return method;
	}

}
