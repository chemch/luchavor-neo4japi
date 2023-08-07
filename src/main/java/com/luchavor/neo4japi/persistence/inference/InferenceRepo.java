package com.luchavor.neo4japi.persistence.inference;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.inference.InferenceImpl;

@RepositoryRestResource(collectionResourceRel = "inference", path = "inference")
public interface InferenceRepo extends PagingAndSortingRepository<InferenceImpl<?, ?>, UUID>, CrudRepository<InferenceImpl<?, ?>, UUID> {
}