package com.luchavor.neo4japi.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.technique.Technique;
import com.luchavor.neo4japi.model.AttackTechniqueGroup;

@RepositoryRestResource(collectionResourceRel = "composite-technique", path = "composite-technique")
public interface AttackTechniqueGroupRepo extends PagingAndSortingRepository<AttackTechniqueGroup, UUID>, CrudRepository<AttackTechniqueGroup, UUID> {
	Technique findByMitreId(@Param("mitreId") String mitreId);
	List<Technique> findByParentMitreId(@Param("mitreId") String mitreId);
}