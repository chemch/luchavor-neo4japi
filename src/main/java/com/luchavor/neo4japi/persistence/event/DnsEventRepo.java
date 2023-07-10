package com.luchavor.neo4japi.persistence.event;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.session.dns.DnsEvent;
import com.luchavor.datamodel.artifact.network.session.dns.DnsEventImpl;
import com.luchavor.datamodel.artifact.network.session.event.SessionEventType;

@RepositoryRestResource(collectionResourceRel = "dns", path = "dns")
public interface DnsEventRepo extends PagingAndSortingRepository<DnsEventImpl, UUID>, CrudRepository<DnsEventImpl, UUID> {
	DnsEvent findBySessionEventType(@Param("sessionEventType") SessionEventType sessionEventType);
}