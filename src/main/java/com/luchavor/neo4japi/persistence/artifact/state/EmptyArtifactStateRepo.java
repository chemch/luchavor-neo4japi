package com.luchavor.neo4japi.persistence.artifact.state;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.artifact.state.EmptyArtifactState;

@RepositoryRestResource(collectionResourceRel = "completeArtifactState", path = "completeArtifactState")
public interface EmptyArtifactStateRepo extends PagingAndSortingRepository<EmptyArtifactState<?>, UUID>, CrudRepository<EmptyArtifactState<?>, UUID> {
}