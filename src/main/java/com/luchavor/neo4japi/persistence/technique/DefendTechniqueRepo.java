package com.luchavor.neo4japi.persistence.technique;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.technique.Technique;
import com.luchavor.neo4japi.model.technique.DefendTechnique;

@RepositoryRestResource(collectionResourceRel = "single-technique", path = "single-technique")
public interface DefendTechniqueRepo extends PagingAndSortingRepository<DefendTechnique, UUID>, CrudRepository<DefendTechnique, UUID> {
	Technique findByMitreId(@Param("mitreId") String mitreId);
	List<Technique> findByParentMitreId(@Param("mitreId") String mitreId);
}