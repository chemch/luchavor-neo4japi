package com.luchavor.neo4japi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luchavor.neo4japi.model.event.Neo4jConnection;
import com.luchavor.neo4japi.persistence.event.ConnectionRepo;

@Service
public class EventService {
	
	@Autowired
	ConnectionRepo connectionRepo;
	
	public void addConnectionEvents(List<Neo4jConnection> connections) {
		connectionRepo.saveAll(connections);
	}
}