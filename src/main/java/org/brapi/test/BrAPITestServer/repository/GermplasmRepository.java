package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface GermplasmRepository extends PagingAndSortingRepository<GermplasmEntity, String> {
	@Query("SELECT g FROM GermplasmEntity g "
			+ "where ('' in :germplasmDbIds or g.id in :germplasmDbIds) "
			+ "AND ('' in :genus or g.genus in :genus) "
			+ "AND ('' in :names or g.germplasmName in :names) "
			+ "AND ('' in :puis or g.germplasmPUI in :puis) "
			+ "AND ('' in :species or g.species in :species) "
			+ "AND ('' in :accessionNumbers or g.accessionNumber in :accessionNumbers) ")
	public Page<GermplasmEntity> findBySearch(
			@Param("germplasmDbIds") List<String> germplasmDbIds, 
			@Param("genus") List<String> germplasmGenus, 
			@Param("names") List<String> germplasmNames,
			@Param("puis") List<String> germplasmPUIs, 
			@Param("species") List<String> germplasmSpecies, 
			@Param("accessionNumbers") List<String> accessionNumbers,
			Pageable pageable);

}
