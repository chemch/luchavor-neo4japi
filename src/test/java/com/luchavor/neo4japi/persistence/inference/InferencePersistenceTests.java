package com.luchavor.neo4japi.persistence.inference;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.inference.Inference;
import com.luchavor.datamodel.inference.InferenceImpl;
import com.luchavor.datamodel.inference.InferenceTests;
import com.luchavor.datamodel.inference.inferredHost.InferredHost;

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
    	Inference<InferredHost> rv =  tests.getInference1();
    	// check for nullness
		assertNotNull(rv);
		// save objects
		repo.save((InferenceImpl<?>) rv);
    }
}