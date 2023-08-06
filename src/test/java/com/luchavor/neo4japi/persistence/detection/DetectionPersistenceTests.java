package com.luchavor.neo4japi.persistence.detection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.network.session.ssl.SslEvent;
import com.luchavor.datamodel.detection.Detection;
import com.luchavor.datamodel.detection.DetectionImpl;
import com.luchavor.datamodel.detection.DetectionTests;
import com.luchavor.neo4japi.persistence.detection.state.ClosedDetectionStateRepo;
import com.luchavor.neo4japi.persistence.detection.state.OpenDetectionStateRepo;

@SpringBootTest
@ActiveProfiles("test")
public class DetectionPersistenceTests {
	private DetectionTests detectionTests = new DetectionTests();
	
	@Autowired
	DetectionRepo detectionRepo;
	
	@Autowired
	ClosedDetectionStateRepo closedDetectionStateRepo;
	
	@Autowired
	OpenDetectionStateRepo openDetectionStateRepo;
	
    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	detectionRepo.deleteAll();
    	openDetectionStateRepo.deleteAll();
    	closedDetectionStateRepo.deleteAll();
	}
    
    @Test
    void shouldAddDetectionsSafely() throws Exception {
    	// load all detection types
		loadDetections();
	}
    
    private void loadDetections() throws Exception {
    	Detection<SslEvent, SslEvent, SslEvent> detection1 = detectionTests.getDetection1();
		// examine object for nullness
		assertNotNull(detection1);
		// save objects
		// artifactRepo.save((ArtifactImpl<?>) artifact1);
		detectionRepo.save((DetectionImpl<?, ?, ?>) detection1);
    }
}