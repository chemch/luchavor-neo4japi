package com.luchavor.neo4japi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luchavor.neo4japi.model.event.Neo4jConnection;
import com.luchavor.neo4japi.model.event.Neo4jDnsEvent;
import com.luchavor.neo4japi.persistence.event.ConnectionRepo;
import com.luchavor.neo4japi.persistence.event.DnsEventRepo;

@Service
public class EventService {
	
	@Autowired
	ConnectionRepo connectionRepo;
	
	@Autowired
	DnsEventRepo dnsEventRepo;
	
	public void addConnectionEvents(List<Neo4jConnection> connections) {
		connectionRepo.saveAll(connections);
	}
	
	public void addDnsEvents(List<Neo4jDnsEvent> events) {
		dnsEventRepo.saveAll(events);
	}
}