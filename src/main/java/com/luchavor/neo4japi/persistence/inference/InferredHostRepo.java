package com.luchavor.neo4japi.persistence.inference;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.inference.inferredHost.InferredHostImpl;

@RepositoryRestResource(collectionResourceRel = "inferredHost", path = "inferredHost")
public interface InferredHostRepo extends PagingAndSortingRepository<InferredHostImpl, UUID>, CrudRepository<InferredHostImpl, UUID> {
}