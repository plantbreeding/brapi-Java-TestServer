package org.brapi.test.BrAPITestServer.repository.germ;

import org.brapi.test.BrAPITestServer.model.entity.germ.CrossEntity;
import org.brapi.test.BrAPITestServer.repository.BrAPIRepository;

public interface CrossRepository extends BrAPIRepository<CrossEntity, String> {
	public CrossEntity findByIdAndPlanned(String crossDbId, Boolean planned);
}
