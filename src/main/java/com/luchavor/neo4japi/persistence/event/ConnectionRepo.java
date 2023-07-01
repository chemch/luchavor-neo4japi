//package com.luchavor.neo4japi.persistence.event;
//
//import java.util.UUID;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import com.luchavor.datamodel.event.Event;
//import com.luchavor.datamodel.event.EventType;
//import com.luchavor.neo4japi.model.event.Neo4jConnection;
//
//@RepositoryRestResource(collectionResourceRel = "connection", path = "connection")
//public interface ConnectionRepo extends PagingAndSortingRepository<Neo4jConnection, UUID>, CrudRepository<Neo4jConnection, UUID> {
//	Event findByEventType(@Param("eventType") EventType eventType);
//}