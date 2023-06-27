package org.brapi.test.BrAPITestServer.repository.germ;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.germ.PedigreeNodeEntity;

public interface PedigreeRepositoryCustom {
	public List<PedigreeNodeEntity> findPedigreeSiblings(PedigreeNodeEntity sourceNode);
}
