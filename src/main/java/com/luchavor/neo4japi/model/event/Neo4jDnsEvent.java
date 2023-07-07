package com.luchavor.neo4japi.model.event;

import java.util.UUID;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import com.luchavor.datamodel.event.dns.DnsEventImpl;

@Node("DnsEvent")
public class Neo4jDnsEvent extends DnsEventImpl {
	// neo4j id
	@Id @GeneratedValue private UUID id;
}