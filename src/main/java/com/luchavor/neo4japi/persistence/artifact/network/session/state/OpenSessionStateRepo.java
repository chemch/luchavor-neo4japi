package com.luchavor.neo4japi.persistence.artifact.network.session.state;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.artifact.network.session.state.OpenSessionState;

@RepositoryRestResource(collectionResourceRel = "openSessionState", path = "openSessionState")
public interface OpenSessionStateRepo extends PagingAndSortingRepository<OpenSessionState, UUID>, CrudRepository<OpenSessionState, UUID> {
}