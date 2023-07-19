package com.luchavor.neo4japi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luchavor.datamodel.artifact.network.session.connection.ConnectionImpl;
import com.luchavor.datamodel.artifact.network.session.dns.DnsEventImpl;
import com.luchavor.neo4japi.persistence.artifact.network.session.ConnectionRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.DnsEventRepo;

@Service
public class EventService {
	
	@Autowired
	ConnectionRepo connectionRepo;
	
	@Autowired
	DnsEventRepo dnsEventRepo;
	
	public void addConnectionEvents(List<ConnectionImpl> connections) {
		connectionRepo.saveAll(connections);
	}
	
	public void addDnsEvents(List<DnsEventImpl> events) {
		dnsEventRepo.saveAll(events);
	}
}