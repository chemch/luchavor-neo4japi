package com.lockettvesp.luchador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.luchavor.neo4japi.data.SingleTechniqueRepo;

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
	private SingleTechniqueRepo repository;

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
		repository.deleteAll();
	}

    @Test
    void shouldReturnRepositoryIndex() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.single-technique").exists());
	}

    @Test
    void shouldCreateEntity() throws Exception {
		mockMvc.perform(post("/single-technique").content(
				"{\"mitreId\": \"T-001\", \"tactic\": \"Model\", \"name\": \"Test\", \"description\":\"Trampling is an unholy approach to defense.\"}")).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("technique/")));
	}

    @Test
    void shouldRetrieveEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/single-technique").content(
				"{\"mitreId\": \"T-001\", \"tactic\": \"Model\", \"name\": \"Test\", \"description\":\"Trampling is an unholy approach to defense.\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T-001")).andExpect(
						jsonPath("$.tactic").value("Model"));
	}

    @Test
    void shouldQueryEntity() throws Exception {
		mockMvc.perform(post("/single-technique").content(
				"{\"mitreId\": \"T-001\", \"tactic\": \"Model\", \"name\": \"Test\", \"description\":\"Trampling is an unholy approach to defense.\"}")).andExpect(
						status().isCreated());

		mockMvc.perform(
				get("/single-technique/search/findByMitreId?mitreId={mitreId}", "T-001")).andExpect(
						status().isOk()).andExpect(
								jsonPath("$._embedded.single-technique[0].name").value(
										"Test"));
	}

    @Test
    void shouldUpdateEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/single-technique").content(
				"{\"mitreId\": \"T-002\", \"tactic\": \"Model\", \"name\": \"Test\", \"description\":\"Trampling is an unholy approach to defense.\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(
				"{\"mitreId\": \"T-001\", \"tactic\": \"Model\", \"name\": \"Test\", \"description\":\"Trampling is an unholy approach to defense.\"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T-001")).andExpect(
						jsonPath("$.name").value("Test"));
	}

    @Test
    void shouldPartiallyUpdateEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/single-technique").content(
				"{\"mitreId\": \"T-001\", \"tactic\": \"Model\", \"name\": \"Test\", \"description\":\"Trampling is an unholy approach to defense.\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(
				patch(location).content("{\"tactic\": \"Detect\"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T-001")).andExpect(
						jsonPath("$.tactic").value("Detect"));
	}

    @Test
    void shouldDeleteEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/single-technique").content(
				"{\"mitreId\": \"T-001\", \"tactic\": \"Model\", \"name\": \"Test\", \"description\":\"Trampling is an unholy approach to defense.\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());
		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
}