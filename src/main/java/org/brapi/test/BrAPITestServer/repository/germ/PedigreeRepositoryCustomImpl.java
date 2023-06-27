package org.brapi.test.BrAPITestServer.repository.germ;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.germ.PedigreeNodeEntity;

public class PedigreeRepositoryCustomImpl implements PedigreeRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<PedigreeNodeEntity> findPedigreeSiblings(PedigreeNodeEntity sourceNode) {
		String siblingSearchSQL = "select distinct siblingNode from PedigreeNodeEntity siblingNode "
				+ "join siblingNode.edges parentEdge "
				+ "join parentEdge.conncetedNode.edges childEdge "
				+ "join childEdge.conncetedNode sourceNode "
				+ "where sourceNode = :sourceId and parentEdge.edgeType = 0 and childEdge.edgeType = 1 and siblingNode.id != childEdge.conncetedNode.id";
		
		TypedQuery<PedigreeNodeEntity> query = em.createQuery(siblingSearchSQL, PedigreeNodeEntity.class);
		query.setParameter("sourceId", sourceNode);
		return query.getResultList();
	}

}
