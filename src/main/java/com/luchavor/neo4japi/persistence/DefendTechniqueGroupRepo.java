package com.luchavor.neo4japi.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.technique.Technique;
import com.luchavor.neo4japi.model.DefendTechniqueGroup;

@RepositoryRestResource(collectionResourceRel = "composite-technique", path = "composite-technique")
public interface DefendTechniqueGroupRepo extends PagingAndSortingRepository<DefendTechniqueGroup, UUID>, CrudRepository<DefendTechniqueGroup, UUID> {
	Technique findByMitreId(@Param("mitreId") String mitreId);
	List<Technique> findByParentMitreId(@Param("mitreId") String mitreId);
}