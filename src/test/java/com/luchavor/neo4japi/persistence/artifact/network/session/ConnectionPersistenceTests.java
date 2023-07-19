package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.network.session.connection.Connection;

@SpringBootTest
@ActiveProfiles("test")
public class ConnectionPersistenceTests {
	//private ConnectionTests connectionTests = new ConnectionTests();
	
	@Autowired
	ConnectionRepo connectionRepo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	connectionRepo.deleteAll();
	}
    
//    @Test
//    void shouldAddSafely() throws Exception {
//		Connection connection = connectionTests.getTestConnection1();
//		// examine connection for nullness
//		assertNotNull(connection);
//		connectionRepo.save((ConnectionImpl) connection);
//	}    
}