package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.network.session.anomaly.AnomalyEventTests;
import com.luchavor.datamodel.artifact.network.session.anomoly.AnomalyEvent;
import com.luchavor.datamodel.artifact.network.session.anomoly.AnomalyEventImpl;

@SpringBootTest
@ActiveProfiles("test")
public class AnomalyEventPersistenceTests {
	private AnomalyEventTests anomalyEventTests = new AnomalyEventTests();
	
	@Autowired
	AnomalyEventRepo anomalyEventRepo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	anomalyEventRepo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		AnomalyEvent event = anomalyEventTests.getAnomalyEventList1().get(0);
		// examine event for nullness
		assertNotNull(event);
		anomalyEventRepo.save((AnomalyEventImpl) event);
	}    
}