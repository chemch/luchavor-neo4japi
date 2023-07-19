package com.luchavor.neo4japi.persistence.artifact.network.session;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.artifact.network.session.connection.Connection;
import com.luchavor.datamodel.artifact.network.session.connection.ConnectionImpl;
import com.luchavor.datamodel.artifact.network.session.event.SessionEventType;

@RepositoryRestResource(collectionResourceRel = "connection", path = "connection")
public interface ConnectionRepo extends PagingAndSortingRepository<ConnectionImpl, UUID>, CrudRepository<ConnectionImpl, UUID> {
	Connection findBySessionEventType(@Param("sessionEventType") SessionEventType sessionEventType);
}