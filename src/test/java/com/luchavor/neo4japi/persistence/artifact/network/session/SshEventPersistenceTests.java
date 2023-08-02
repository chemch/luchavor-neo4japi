package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.network.session.ssh.SshEvent;
import com.luchavor.datamodel.artifact.network.session.ssh.SshEventImpl;
import com.luchavor.datamodel.artifact.network.session.ssh.SshEventTests;

@SpringBootTest
@ActiveProfiles("test")
public class SshEventPersistenceTests {
	private SshEventTests eventTests = new SshEventTests();
	
	@Autowired
	SshEventRepo eventRepo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	eventRepo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		SshEvent event = eventTests.getSshEventList1().get(0);
		// examine event for nullness
		assertNotNull(event);
		eventRepo.save((SshEventImpl) event);
	}    
}