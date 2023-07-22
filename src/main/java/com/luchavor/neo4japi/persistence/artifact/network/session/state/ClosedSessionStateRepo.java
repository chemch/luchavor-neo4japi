package com.luchavor.neo4japi.persistence.artifact.network.session.state;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.artifact.network.session.state.ClosedSessionState;

@RepositoryRestResource(collectionResourceRel = "closedSessionState", path = "closedSessionState")
public interface ClosedSessionStateRepo extends PagingAndSortingRepository<ClosedSessionState, UUID>, CrudRepository<ClosedSessionState, UUID> {
}