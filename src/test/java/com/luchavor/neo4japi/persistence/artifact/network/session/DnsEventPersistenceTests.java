package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.luchavor.datamodel.artifact.network.session.dns.DnsEvent;
import com.luchavor.datamodel.artifact.network.session.dns.DnsEventImpl;
import com.luchavor.datamodel.artifact.network.session.dns.DnsEventTests;

@SpringBootTest
@ActiveProfiles("test")
public class DnsEventPersistenceTests {
	private DnsEventTests tests = new DnsEventTests();
	
	@Autowired
	DnsEventRepo repo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	repo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		DnsEvent event = tests.getDnsEventList1().get(0);
		// examine event for nullness
		assertNotNull(event);
		repo.save((DnsEventImpl) event);
	}    
}