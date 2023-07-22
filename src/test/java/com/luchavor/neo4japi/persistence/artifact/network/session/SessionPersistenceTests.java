package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.network.session.Session;
import com.luchavor.datamodel.artifact.network.session.SessionImpl;
import com.luchavor.datamodel.artifact.network.session.SessionTests;

@SpringBootTest
@ActiveProfiles("test")
public class SessionPersistenceTests {
	private SessionTests sessionTests = new SessionTests();
	
	@Autowired
	SessionRepo sessionRepo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	sessionRepo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		Session session1 = sessionTests.getSession1();
		Session session2 = sessionTests.getSession2();
		Session session3 = sessionTests.getSession3();
		Session session4 = sessionTests.getSession4();
		Session session5 = sessionTests.getSession5();
		Session session6 = sessionTests.getSession6();
		Session session7 = sessionTests.getSession7();
		// examine for nullness
		assertNotNull(session1);
		assertNotNull(session2);
		assertNotNull(session3);
		assertNotNull(session4);
		assertNotNull(session5);
		assertNotNull(session6);
		assertNotNull(session7);
		// save objects
		sessionRepo.save((SessionImpl) session1);
		sessionRepo.save((SessionImpl) session2);
		sessionRepo.save((SessionImpl) session3);
		sessionRepo.save((SessionImpl) session4);
		sessionRepo.save((SessionImpl) session5);
		sessionRepo.save((SessionImpl) session6);
		sessionRepo.save((SessionImpl) session7);
	}    
}