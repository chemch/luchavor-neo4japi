package com.luchavor.neo4japi.persistence.finding;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.finding.Finding;
import com.luchavor.datamodel.finding.FindingImpl;
import com.luchavor.datamodel.finding.FindingTests;
import com.luchavor.neo4japi.persistence.finding.state.ConfirmedFindingStateRepo;
import com.luchavor.neo4japi.persistence.finding.state.PotentialFindingStateRepo;
import com.luchavor.neo4japi.persistence.finding.state.RefutedFindingStateRepo;

@SpringBootTest
@ActiveProfiles("test")
public class FindingPersistenceTests {
	private FindingTests tests = new FindingTests();
	
	@Autowired
	FindingRepo repo;
	
	@Autowired
	RefutedFindingStateRepo refutedFindingStateRepo;
	
	@Autowired
	PotentialFindingStateRepo potentialFindingStateRepo;
	
	@Autowired
	ConfirmedFindingStateRepo confirmedFindingStateRepo;
	
    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	repo.deleteAll();
    	refutedFindingStateRepo.deleteAll();
    	potentialFindingStateRepo.deleteAll();
    	confirmedFindingStateRepo.deleteAll();
	}
    
    @Test
    void shouldAddFindingsSafely() throws Exception {
    	// load all objects
		loadBasicFindings();
	}    
    
    private void loadBasicFindings() throws Exception {
    	Finding<?> obj1 = tests.getFinding1();
		// examine object for nullness
		assertNotNull(obj1);
		// save objects
		repo.save((FindingImpl<?>) obj1);
    }
}