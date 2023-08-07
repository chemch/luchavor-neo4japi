package com.luchavor.neo4japi.persistence.inference;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.Artifact;
import com.luchavor.datamodel.artifact.ArtifactImpl;
import com.luchavor.datamodel.artifact.ArtifactTests;
import com.luchavor.datamodel.artifact.network.session.Session;
import com.luchavor.datamodel.inference.Inference;
import com.luchavor.datamodel.inference.InferenceImpl;
import com.luchavor.datamodel.inference.InferenceTests;
import com.luchavor.datamodel.inference.inferredHost.InferredHost;
import com.luchavor.neo4japi.persistence.artifact.network.session.state.ClosedSessionStateRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.state.OpenSessionStateRepo;

@SpringBootTest
@ActiveProfiles("test")
public class InferencePersistenceTests {
	private InferenceTests tests = new InferenceTests();
	
	@Autowired
	InferenceRepo repo;
	
    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	repo.deleteAll();
	}

    @Test
    void loadSessionArtifacts() throws Exception {
    	Inference<?> rv =  tests.getInference1();
		// examine object for nullness
		assertNotNull(rv);
		// save objects
		repo.save((InferenceImpl<?>) rv);
		
    }
}