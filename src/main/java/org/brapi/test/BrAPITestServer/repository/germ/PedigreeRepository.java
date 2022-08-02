package org.brapi.test.BrAPITestServer.repository.germ;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.germ.PedigreeNodeEntity;
import org.brapi.test.BrAPITestServer.repository.BrAPIRepository;

public interface PedigreeRepository extends BrAPIRepository<PedigreeNodeEntity, String> {
	public List<PedigreeNodeEntity> findByGermplasm_Id(String germplasmDbId);
}
