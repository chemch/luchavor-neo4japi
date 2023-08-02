package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.network.session.smtp.SmtpEvent;
import com.luchavor.datamodel.artifact.network.session.smtp.SmtpEventImpl;
import com.luchavor.datamodel.artifact.network.session.smtp.SmtpEventTests;

@SpringBootTest
@ActiveProfiles("test")
public class SmtpEventPersistenceTests {
	private SmtpEventTests tests = new SmtpEventTests();
	
	@Autowired
	SmtpEventRepo eventRepo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	eventRepo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		SmtpEvent event = tests.getSmtpEventList1().get(0);
		// examine event for nullness
		assertNotNull(event);
		eventRepo.save((SmtpEventImpl) event);
	}    
}