package com.luchavor.neo4japi.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.neo4japi.model.technique.SingleTechnique;
import com.luchavor.neo4japi.model.technique.Technique;

@RepositoryRestResource(collectionResourceRel = "single-technique", path = "single-technique")
public interface SingleTechniqueRepo extends PagingAndSortingRepository<SingleTechnique, UUID>, CrudRepository<SingleTechnique, UUID> {
	List<Technique> findByMitreId(@Param("mitreId") String mitreId);
}