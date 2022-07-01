package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossParentEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossingProjectEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.repository.germ.GermplasmRepository;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationUnitRepository;
import org.springframework.stereotype.Service;

import io.swagger.model.germ.CrossInterface;
import io.swagger.model.germ.CrossParent;
import io.swagger.model.germ.CrossingProject;
import io.swagger.model.germ.CrossingProjectNewRequest;

@Service
public class CrossParentService {

	private final GermplasmRepository germplasmRepository;
	private final ObservationUnitRepository observationUnitRepository;

	public CrossParentService(GermplasmRepository germplasmRepository,
			ObservationUnitRepository observationUnitRepository) {
		this.germplasmRepository = germplasmRepository;
		this.observationUnitRepository = observationUnitRepository;
	}

	public CrossParent convertFromEntity(CrossParentEntity entity) {
		CrossParent parent = new CrossParent();
		if (entity != null) {
			if (entity.getGermplasm() != null) {
				parent.setGermplasmDbId(entity.getGermplasm().getId());
				parent.setGermplasmName(entity.getGermplasm().getGermplasmName());
			}
			if (entity.getObservationUnit() != null) {
				parent.setObservationUnitDbId(entity.getObservationUnit().getId());
				parent.setObservationUnitName(entity.getObservationUnit().getObservationUnitName());
			}
			parent.setParentType(entity.getParentType());
		}
		return parent;
	}

	public CrossParentEntity convertToEntity(CrossParent parent, CrossEntity cross,
			CrossingProjectEntity crossingProject) throws BrAPIServerException {
		CrossParentEntity entity = new CrossParentEntity();
		if (parent.getGermplasmDbId() != null) {
			GermplasmEntity germ = getGermplasmEntity(parent.getGermplasmDbId());
			entity.setGermplasm(germ);
		}
		if (parent.getObservationUnitDbId() != null) {
			ObservationUnitEntity obsUnit = getObservationUnitEntity(parent.getObservationUnitDbId());
			entity.setObservationUnit(obsUnit);
		}
		if (parent.getParentType() != null) {
			entity.setParentType(parent.getParentType());
		}
		if (cross != null) {
			entity.setCross(cross);
		}
		if (crossingProject != null) {
			entity.setCrossingProject(crossingProject);
		}
		return entity;
	}

	public void addParentsToEntity(CrossInterface cross, CrossEntity entity) throws BrAPIServerException {
		if (cross.getParent1() != null)
			entity.addParentItem(convertToEntity(cross.getParent1(), entity, entity.getCrossingProject()));
		if (cross.getParent2() != null)
			entity.addParentItem(convertToEntity(cross.getParent2(), entity, entity.getCrossingProject()));
	}

	public void convertParentsFromEntity(CrossEntity entity, CrossInterface cross) {

		if (entity.getParents() != null && entity.getParents().size() >= 1)
			cross.setParent1(convertFromEntity(entity.getParents().get(0)));
		if (entity.getParents() != null && entity.getParents().size() >= 2)
			cross.setParent2(convertFromEntity(entity.getParents().get(1)));

	}

	public void convertParentsFromEntity(CrossingProjectEntity entity, CrossingProject project) {
		if (entity.getPotentialParents() != null) {
			project.setPotentialParents(new ArrayList<>());
			for (CrossParentEntity parentEntity : entity.getPotentialParents()) {
				project.getPotentialParents().add(convertFromEntity(parentEntity));
			}
		}

	}

	public void convertParentsToEntity(CrossingProjectEntity entity, CrossingProjectNewRequest project)
			throws BrAPIServerException {
		if (project.getPotentialParents() != null) {
			entity.setPotentialParents(new ArrayList<>());
			for (CrossParent parent : project.getPotentialParents()) {
				entity.getPotentialParents().add(convertToEntity(parent, null, entity));
			}
		}
	}

	public GermplasmEntity getGermplasmEntity(String germplasmDbId) throws BrAPIServerException {
		GermplasmEntity germplasm = null;
		Optional<GermplasmEntity> entityOpt = germplasmRepository.findById(germplasmDbId);
		if (entityOpt.isPresent()) {
			germplasm = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("germplasm", germplasmDbId);
		}
		return germplasm;
	}

	public ObservationUnitEntity getObservationUnitEntity(String observationUnitDbId) throws BrAPIServerException {
		ObservationUnitEntity observationUnit = null;
		Optional<ObservationUnitEntity> entityOpt = observationUnitRepository.findById(observationUnitDbId);
		if (entityOpt.isPresent()) {
			observationUnit = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("observationUnit", observationUnitDbId);
		}
		return observationUnit;
	}
}
