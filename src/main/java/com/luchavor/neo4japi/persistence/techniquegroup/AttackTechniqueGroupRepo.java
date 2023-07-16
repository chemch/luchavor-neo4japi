package com.luchavor.neo4japi.persistence.techniquegroup;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.technique.Technique;
import com.luchavor.neo4japi.model.techniquegroup.AttackTechniqueGroup;

@RepositoryRestResource(collectionResourceRel = "attack-technique-group", path = "attack-technique-group")
public interface AttackTechniqueGroupRepo extends PagingAndSortingRepository<AttackTechniqueGroup, UUID>, CrudRepository<AttackTechniqueGroup, UUID> {
	List<Technique> findByMitreId(@Param("mitreId") String mitreId);
	List<Technique> findByParentMitreId(@Param("mitreId") String mitreId);
}