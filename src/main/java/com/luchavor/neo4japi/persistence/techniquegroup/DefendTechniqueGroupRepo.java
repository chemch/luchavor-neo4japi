package com.luchavor.neo4japi.persistence.techniquegroup;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.technique.Technique;
import com.luchavor.datamodel.techniquegroup.DefendTechniqueGroup;

@RepositoryRestResource(collectionResourceRel = "defend-technique-group", path = "defend-technique-group")
public interface DefendTechniqueGroupRepo extends PagingAndSortingRepository<DefendTechniqueGroup, UUID>, CrudRepository<DefendTechniqueGroup, UUID> {
	List<Technique> findByMitreId(@Param("mitreId") String mitreId);
	List<Technique> findByParentMitreId(@Param("mitreId") String mitreId);
}