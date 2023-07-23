package com.luchavor.neo4japi.persistence.artifact.network.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.network.session.modbus.ModbusEvent;
import com.luchavor.datamodel.artifact.network.session.modbus.ModbusEventImpl;
import com.luchavor.datamodel.artifact.network.session.modbus.ModbusEventTests;

@SpringBootTest
@ActiveProfiles("test")
public class ModbusEventPersistenceTests {
	private ModbusEventTests tests = new ModbusEventTests();
	
	@Autowired
	ModbusEventRepo eventRepo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	eventRepo.deleteAll();
	}
    
    @Test
    void shouldAddSafely() throws Exception {
		ModbusEvent event = tests.getModbusEventList1().get(0);
		// examine event for nullness
		assertNotNull(event);
		eventRepo.save((ModbusEventImpl) event);
	}    
}