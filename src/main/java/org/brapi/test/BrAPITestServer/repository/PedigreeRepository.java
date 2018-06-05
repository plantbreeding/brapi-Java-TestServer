package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.PedigreeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PedigreeRepository extends PagingAndSortingRepository<PedigreeEntity, String> {
	public PedigreeEntity findByGermplasm_Id(String germplasmDbId);
	public PedigreeEntity findByGermplasm_IdAndNotation(String germplasmDbId, String notation);
	public List<PedigreeEntity> findByParent1_IdOrParent2_Id(String germplasmDbId, String germplasmDbId2);
	

	@Query("select p from PedigreeEntity p "
			+ "where (p.parent1.id = :parent1 OR p.parent2.id = :parent1) "
			+ "AND  (p.parent1.id = :parent2 OR p.parent2.id = :parent2)")
	public List<PedigreeEntity> findSiblings(@Param("parent1") String parent1, @Param("parent2") String parent2);
}
