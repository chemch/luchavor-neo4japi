package com.luchavor.neo4japi.persistence.detection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.detection.zeeknotification.ZeekNotification;
import com.luchavor.datamodel.detection.zeeknotification.ZeekNotificationImpl;
import com.luchavor.datamodel.detection.zeeknotification.ZeekNotificationTests;

@SpringBootTest
@ActiveProfiles("test")
public class ZeekNotificationPersistenceTests {
	private ZeekNotificationTests tests = new ZeekNotificationTests();
	
	@Autowired
	ZeekNotificationRepo repo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	repo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		ZeekNotification rv = tests.getZeekNotificationList1().get(0);
		// examine event for nullness
		assertNotNull(rv);
		repo.save((ZeekNotificationImpl) rv);
	}    
}