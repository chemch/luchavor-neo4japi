package com.luchavor.neo4japi.persistence.event;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.event.EventType;
import com.luchavor.datamodel.event.dns.Dns;
import com.luchavor.neo4japi.model.event.Neo4jDnsEvent;

@RepositoryRestResource(collectionResourceRel = "dns", path = "dns")
public interface DnsEventRepo extends PagingAndSortingRepository<Neo4jDnsEvent, UUID>, CrudRepository<Neo4jDnsEvent, UUID> {
	Dns findByEventType(@Param("eventType") EventType eventType);
}