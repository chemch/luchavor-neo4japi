package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.network.session.ntp.NtpEvent;
import com.luchavor.datamodel.artifact.network.session.ntp.NtpEventImpl;
import com.luchavor.datamodel.artifact.network.session.ntp.NtpEventTests;

@SpringBootTest
@ActiveProfiles("test")
public class NtpEventPersistenceTests {
	private NtpEventTests eventTests = new NtpEventTests();
	
	@Autowired
	NtpEventRepo eventRepo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	eventRepo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		NtpEvent event = eventTests.getNtpEventList1().get(0);
		// examine event for nullness
		assertNotNull(event);
		eventRepo.save((NtpEventImpl) event);
	}    
}