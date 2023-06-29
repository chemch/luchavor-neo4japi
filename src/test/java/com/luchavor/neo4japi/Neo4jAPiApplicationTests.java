package com.luchavor.neo4japi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.luchavor.neo4japi.persistence.AttackTechniqueGroupRepo;
import com.luchavor.neo4japi.persistence.AttackTechniqueRepo;
import com.luchavor.neo4japi.persistence.DefendTechniqueGroupRepo;
import com.luchavor.neo4japi.persistence.DefendTechniqueRepo;
import com.luchavor.neo4japi.persistence.TechniqueGroupRepo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	AttackTechniqueRepo attackTechniqueRepo;
	
	@Autowired
	DefendTechniqueRepo defendTechniqueRepo;
	
	@Autowired
	AttackTechniqueGroupRepo attackTechniqueGroupRepo;
	
	@Autowired
	DefendTechniqueGroupRepo defendTechniqueGroupRepo;
	
	@Autowired
	TechniqueGroupRepo techniqueGroupRepo;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	attackTechniqueGroupRepo.deleteAll();
    	defendTechniqueGroupRepo.deleteAll();
		attackTechniqueRepo.deleteAll();
		defendTechniqueRepo.deleteAll();
	}

    @Test
    void shouldReturnRepositoryIndex() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.single-technique").exists());
	}
    
    @Test
    void shouldCreateEntity() throws Exception {
		mockMvc.perform(post("/single-technique").content(
				"{\"mitreId\": \"T-001.001\", \"model\": \"ATTACK\", \"subModel\": \"ICS\", \"tactic\": \"Evasion\", \"name\": \"Test Technique 1\", \"parentMitreId\": \"T-001\", \"treeLevel\": \"0\", \"description\":\"Test Technique for Junit Tests.\"}")).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("technique/")));
	}

    @Test
    void shouldRetrieveEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/single-technique").content(
				"{\"mitreId\": \"T-001.001\", \"model\": \"ATTACK\", \"subModel\": \"ICS\", \"tactic\": \"Evasion\", \"name\": \"Test Technique 1\", \"parentMitreId\": \"T-001\", \"treeLevel\": \"0\", \"description\":\"Test Technique for Junit Tests.\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T-001.001")).andExpect(
						jsonPath("$.tactic").value("Evasion"));
	}

    @Test
    void shouldQueryEntity() throws Exception {
		mockMvc.perform(post("/single-technique").content(
					"{\"mitreId\": \"T-001.001\", \"model\": \"ATTACK\", \"subModel\": \"ICS\", \"tactic\": \"Evasion\", \"name\": \"Test Technique 1\", \"parentMitreId\": \"T-001\", \"treeLevel\": \"0\", \"description\":\"Test Technique for Junit Tests.\"}")).andExpect(
						status().isCreated());

		mockMvc.perform(
				get("/single-technique/search/findByMitreId?mitreId={mitreId}", "T-001.001")).andExpect(
						status().isOk()).andExpect(
								jsonPath("$.name").value(
										"Test Technique 1"));
	}

    @Test
    void shouldUpdateEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/single-technique").content(
			"{\"mitreId\": \"T-001.001\", \"model\": \"ATTACK\", \"subModel\": \"ICS\", \"tactic\": \"Evasion\", \"name\": \"Test Technique 1\", \"parentMitreId\": \"T-001\", \"treeLevel\": \"0\", \"description\":\"Test Technique for Junit Tests.\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(
				"{\"mitreId\": \"T-001.002\", \"model\": \"ATTACK\", \"subModel\": \"ICS\", \"tactic\": \"Evasion\", \"name\": \"Test Technique 1\", \"parentMitreId\": \"T-001\", \"treeLevel\": \"0\", \"description\":\"Test Technique for Junit Tests.\"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T-001.002")).andExpect(
						jsonPath("$.name").value("Test Technique 1"));
	}

    @Test
    void shouldPartiallyUpdateEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/single-technique").content(
			"{\"mitreId\": \"T-001.001\", \"model\": \"ATTACK\", \"subModel\": \"ICS\", \"tactic\": \"Evasion\", \"name\": \"Test Technique 1\", \"parentMitreId\": \"T-001\", \"treeLevel\": \"0\", \"description\":\"Test Technique for Junit Tests.\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(
				patch(location).content("{\"tactic\": \"Destroy\"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T-001.001")).andExpect(
						jsonPath("$.tactic").value("Destroy"));
	}

    @Test
    void shouldDeleteEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/single-technique").content(
			"{\"mitreId\": \"T-001.001\", \"model\": \"ATTACK\", \"subModel\": \"ICS\", \"tactic\": \"Evasion\", \"name\": \"Test Technique 1\", \"parentMitreId\": \"T-001\", \"treeLevel\": \"0\", \"description\":\"Test Technique for Junit Tests.\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());
		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
}