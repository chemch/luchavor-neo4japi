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
	SessionRepo repo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	repo.deleteAll();
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
		Session session8 = sessionTests.getSession8();
		Session session9 = sessionTests.getSession9();
		Session session10 = sessionTests.getSession10();
		Session session11 = sessionTests.getSession11();
		Session session12 = sessionTests.getSession12();
		// examine for nullness
		assertNotNull(session1);
		assertNotNull(session2);
		assertNotNull(session3);
		assertNotNull(session4);
		assertNotNull(session5);
		assertNotNull(session6);
		assertNotNull(session7);
		assertNotNull(session8);
		assertNotNull(session9);
		assertNotNull(session10);
		assertNotNull(session11);
		assertNotNull(session12);
		// save objects
		repo.save((SessionImpl) session1);
		repo.save((SessionImpl) session2);
		repo.save((SessionImpl) session3);
		repo.save((SessionImpl) session4);
		repo.save((SessionImpl) session5);
		repo.save((SessionImpl) session6);
		repo.save((SessionImpl) session7);
		repo.save((SessionImpl) session8);
		repo.save((SessionImpl) session9);
		repo.save((SessionImpl) session10);
		repo.save((SessionImpl) session11);
		repo.save((SessionImpl) session12);
	}    
}