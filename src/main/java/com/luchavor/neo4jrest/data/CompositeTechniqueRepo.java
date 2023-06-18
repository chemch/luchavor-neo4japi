package com.luchavor.neo4jrest.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.neo4jrest.model.technique.CompositeTechnique;
import com.luchavor.neo4jrest.model.technique.Technique;

@RepositoryRestResource(collectionResourceRel = "composite-technique", path = "composite-technique")
public interface CompositeTechniqueRepo extends PagingAndSortingRepository<CompositeTechnique, UUID>, CrudRepository<CompositeTechnique, UUID> {
	List<Technique> findByMitreId(@Param("mitreId") String mitreId);
}