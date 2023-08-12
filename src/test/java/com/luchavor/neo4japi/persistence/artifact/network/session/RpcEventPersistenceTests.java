package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.luchavor.datamodel.artifact.network.session.rpc.RpcEvent;
import com.luchavor.datamodel.artifact.network.session.rpc.RpcEventImpl;
import com.luchavor.datamodel.artifact.network.session.rpc.RpcEventTests;

@SpringBootTest
@ActiveProfiles("test")
public class RpcEventPersistenceTests {
	private RpcEventTests tests = new RpcEventTests();
	
	@Autowired
	RpcEventRepo repo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	repo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		RpcEvent event = tests.getRpcEventList1().get(0);
		// examine event for nullness
		assertNotNull(event);
		repo.save((RpcEventImpl) event);
	}    
}