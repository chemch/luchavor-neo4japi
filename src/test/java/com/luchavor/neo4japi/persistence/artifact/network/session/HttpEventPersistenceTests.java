package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.luchavor.datamodel.artifact.network.session.http.HttpEvent;
import com.luchavor.datamodel.artifact.network.session.http.HttpEventImpl;
import com.luchavor.datamodel.artifact.network.session.http.HttpEventTests;

@SpringBootTest
@ActiveProfiles("test")
public class HttpEventPersistenceTests {
	private HttpEventTests tests = new HttpEventTests();
	
	@Autowired
	HttpEventRepo repo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	repo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		HttpEvent event = tests.getHttpEventList1().get(0);
		// examine event for nullness
		assertNotNull(event);
		repo.save((HttpEventImpl) event);
	}    
}