package com.luchavor.neo4japi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.luchavor.datamodel.mitre.ModelType;
import com.luchavor.neo4japi.persistence.technique.AttackTechniqueRepo;
import com.luchavor.neo4japi.persistence.technique.DefendTechniqueRepo;
import com.luchavor.neo4japi.persistence.techniquegroup.AttackTechniqueGroupRepo;
import com.luchavor.neo4japi.persistence.techniquegroup.DefendTechniqueGroupRepo;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
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

    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	attackTechniqueGroupRepo.deleteAll();
    	defendTechniqueGroupRepo.deleteAll();
		attackTechniqueRepo.deleteAll();
		defendTechniqueRepo.deleteAll();
	}
    
    // json string examples of techniques
    private String attackTechniqueJsonString = "{\"mitreId\": \"T1548.002\", \"model\": \"ATTACK\", \"subModel\": \"ENTERPRISE\", \"tactic\": [\"Defense Evasion\"], \"name\": \"Abuse Elevation Control Mechanism: Bypass User Account Control\", \"parentMitreId\": \"T1548\", \"description\":\"Adversaries may bypass UAC mechanisms to elevate process privileges on system. Windows User Account Control (UAC) allows a program to elevate its privileges (tracked as integrity levels ranging from low to high) to perform a task under administrator-level permissions, possibly by prompting the user for confirmation. The impact to the user ranges from denying the operation under high enforcement to allowing the user to perform the action if they are in the local administrators group and click through the prompt or allowing them to enter an administrator password to complete the action.(Citation: TechNet How UAC Works), , If the UAC protection level of a computer is set to anything but the highest level, certain Windows programs can elevate privileges or execute some elevated [Component Object Model](https://attack.mitre.org/techniques/T1559/001) objects without prompting the user through the UAC notification box.(Citation: TechNet Inside UAC)(Citation: MSDN COM Elevation) An example of this is use of [Rundll32](https://attack.mitre.org/techniques/T1218/011) to load a specifically crafted DLL which loads an auto-elevated [Component Object Model](https://attack.mitre.org/techniques/T1559/001) object and performs a file operation in a protected directory which would typically require elevated access. Malicious software may also be injected into a trusted process to gain elevated privileges without prompting a user.(Citation: Davidson Windows), , Many methods have been discovered to bypass UAC.\"}";
    private String updatedAttackTechniqueJsonString = "{\"mitreId\": \"T1548.003\", \"model\": \"ATTACK\", \"subModel\": \"ENTERPRISE\", \"tactic\": [\"Defense Evasion\"], \"name\": \"Abuse Elevation Control Mechanism: Bypass User Account Control\", \"parentMitreId\": \"T1548\", \"description\":\"Adversaries may bypass UAC mechanisms to elevate process privileges on system. Windows User Account Control (UAC) allows a program to elevate its privileges (tracked as integrity levels ranging from low to high) to perform a task under administrator-level permissions, possibly by prompting the user for confirmation. The impact to the user ranges from denying the operation under high enforcement to allowing the user to perform the action if they are in the local administrators group and click through the prompt or allowing them to enter an administrator password to complete the action.(Citation: TechNet How UAC Works), , If the UAC protection level of a computer is set to anything but the highest level, certain Windows programs can elevate privileges or execute some elevated [Component Object Model](https://attack.mitre.org/techniques/T1559/001) objects without prompting the user through the UAC notification box.(Citation: TechNet Inside UAC)(Citation: MSDN COM Elevation) An example of this is use of [Rundll32](https://attack.mitre.org/techniques/T1218/011) to load a specifically crafted DLL which loads an auto-elevated [Component Object Model](https://attack.mitre.org/techniques/T1559/001) object and performs a file operation in a protected directory which would typically require elevated access. Malicious software may also be injected into a trusted process to gain elevated privileges without prompting a user.(Citation: Davidson Windows), , Many methods have been discovered to bypass UAC.\"}";
    private String defendTechniqueJsonString = "{\"mitreId\": \"D3-CI\", \"model\": \"DEFEND\", \"subModel\": \"NONE\", \"tactic\": [\"Model\"], \"name\": \"Config Inventory\", \"parentMitreId\": \"D3-AI\", \"description\":\"Configuration inventory identifies and records the configuration of software and hardware and their components throughout the organization.\"}";
    private String updatedDefendTechniqueJsonString = "{\"mitreId\": \"D3-UI\", \"model\": \"DEFEND\", \"subModel\": \"NONE\", \"tactic\": [\"Model\"], \"name\": \"Config Inventory\", \"parentMitreId\": \"D3-AI\", \"description\":\"Configuration inventory identifies and records the configuration of software and hardware and their components throughout the organization.\"}";
    private String attackTechniqueGroupJsonString = "{\"mitreId\": \"T1548\", \"model\": \"ATTACK\", \"subModel\": \"ENTERPRISE\", \"tactic\": [\"Defense Evasion\"], \"name\": \"Abuse Elevation Control Mechanism\", \"parentMitreId\": \"\", \"description\":\"Adversaries may circumvent mechanisms designed to control elevate privileges to gain higher-level permissions. Most modern systems contain native elevation control mechanisms that are intended to limit privileges that a user can perform on a machine. Authorization has to be granted to specific users in order to perform tasks that can be considered of higher risk. An adversary can perform several methods to take advantage of built-in control mechanisms in order to escalate privileges on a system.\"}";
    private String updatedAttackTechniqueGroupJsonString = "{\"mitreId\": \"T1550\", \"model\": \"ATTACK\", \"subModel\": \"ENTERPRISE\", \"tactic\": [\"Defense Evasion\"], \"name\": \"Abuse Elevation Control Mechanism\", \"parentMitreId\": \"\", \"description\":\"Adversaries may circumvent mechanisms designed to control elevate privileges to gain higher-level permissions. Most modern systems contain native elevation control mechanisms that are intended to limit privileges that a user can perform on a machine. Authorization has to be granted to specific users in order to perform tasks that can be considered of higher risk. An adversary can perform several methods to take advantage of built-in control mechanisms in order to escalate privileges on a system.\"}";
    private String defendTechniqueGroupJsonString = "{\"mitreId\": \"D3-AI\", \"model\": \"DEFEND\", \"subModel\": \"NONE\", \"tactic\": [\"Model\"], \"name\": \"Asset Inventory\", \"parentMitreId\": \"\", \"description\":\"Asset inventorying identifies and records the organization's assets and enriches each inventory item with knowledge about their vulnerabilities.\"}";
    private String updatedDefendTechniqueGroupJsonString = "{\"mitreId\": \"D3-II\", \"model\": \"DEFEND\", \"subModel\": \"NONE\", \"tactic\": [\"Model\"], \"name\": \"Asset Inventory\", \"parentMitreId\": \"\", \"description\":\"Asset inventorying identifies and records the organization's assets and enriches each inventory item with knowledge about their vulnerabilities.\"}";
    

    // tag::repoIndexTests[]
    @Test
    void shouldReturnAttackTechniqueRepositoryIndex() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.attack-technique").exists());
	}
    
    @Test
    void shouldReturnDefendTechniqueRepositoryIndex() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.defend-technique").exists());
	}
    
    @Test
    void shouldReturnAttackTechniqueGroupRepositoryIndex() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.attack-technique-group").exists());
	}
    
    @Test
    void shouldReturnDefendTechniqueGroupRepositoryIndex() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.defend-technique-group").exists());
	}
    // end::repoIndexTests[]
    
    // tag::createEntityTests[]
    @Test
    void shouldCreateAttackTechniqueEntity() throws Exception {
		mockMvc.perform(post("/attack-technique").content(attackTechniqueJsonString)).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("technique/")));
	}
    
    @Test
    void shouldCreateDefendTechniqueEntity() throws Exception {
		mockMvc.perform(post("/defend-technique").content(defendTechniqueJsonString)).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("technique/")));
	}
    
    @Test
    void shouldCreateAttackTechniqueGroupEntity() throws Exception {
		mockMvc.perform(post("/attack-technique-group").content(attackTechniqueGroupJsonString)).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("technique-group/")));
	}
    
    @Test
    void shouldCreateDefendTechniqueGroupEntity() throws Exception {
		mockMvc.perform(post("/defend-technique-group").content(defendTechniqueGroupJsonString)).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("technique-group/")));
	}
    // end::createEntityTests[]

    // tag::retrieveEntityTests[]
    @Test
    void shouldRetrieveAttackTechniqueEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/attack-technique").content(attackTechniqueJsonString)).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T1548.002")).andExpect(
						jsonPath("$.model").value(ModelType.ATTACK.toString()));
	}
    
    @Test
    void shouldRetrieveDefendEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/defend-technique").content(defendTechniqueJsonString)).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("D3-CI")).andExpect(
						jsonPath("$.tactic").value("Model"));
	}
    
    @Test
    void shouldRetrieveAttackGroupEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/attack-technique-group").content(attackTechniqueGroupJsonString)).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T1548")).andExpect(
						jsonPath("$.tactic").value("Defense Evasion"));
	}
    
    @Test
    void shouldRetrieveDefendGroupEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/defend-technique-group").content(defendTechniqueGroupJsonString)).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("D3-AI")).andExpect(
						jsonPath("$.tactic").value("Model"));
	}
    // end::retrieveEntityTests[]

    // tag::queryEntityTests[]
    @Test
    void shouldQueryAttackEntity() throws Exception {
		mockMvc.perform(post("/attack-technique").content(attackTechniqueJsonString)).andExpect(
						status().isCreated());

		mockMvc.perform(
				get("/attack-technique/search/findByMitreId?mitreId={mitreId}", "T1548.002")).andExpect(
						status().isOk()).andExpect(
								jsonPath("$._embedded.attack-technique").isNotEmpty());
	}
    
    @Test
    void shouldQueryDefendEntity() throws Exception {
		mockMvc.perform(post("/defend-technique").content(defendTechniqueJsonString)).andExpect(
						status().isCreated());

		mockMvc.perform(
				get("/defend-technique/search/findByMitreId?mitreId={mitreId}", "D3-CI")).andExpect(
						status().isOk()).andExpect(
								jsonPath("$._embedded.defend-technique").isNotEmpty());
	}
    
    @Test
    void shouldQueryAttackGroupEntity() throws Exception {
		mockMvc.perform(post("/attack-technique-group").content(attackTechniqueGroupJsonString)).andExpect(
						status().isCreated());

		mockMvc.perform(
				get("/attack-technique-group/search/findByMitreId?mitreId={mitreId}", "T1548")).andExpect(
						status().isOk()).andExpect(
								jsonPath("$._embedded.attack-technique-group").isNotEmpty());
	}
    
    @Test
    void shouldQueryDefendGroupEntity() throws Exception {
		mockMvc.perform(post("/defend-technique-group").content(defendTechniqueGroupJsonString)).andExpect(
						status().isCreated());

		mockMvc.perform(
				get("/defend-technique-group/search/findByMitreId?mitreId={mitreId}", "D3-AI")).andExpect(
						status().isOk()).andExpect(
								jsonPath("$._embedded.defend-technique-group").isNotEmpty());
	}
    // end::queryEntityTests[]

    // tag::updateEntityTests[]
    @Test
    void shouldUpdateAttackEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/attack-technique").content(attackTechniqueJsonString)).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(updatedAttackTechniqueJsonString)).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T1548.003")).andExpect(
						jsonPath("$.name").value("Abuse Elevation Control Mechanism: Bypass User Account Control"));
	}
    
    @Test
    void shouldUpdateDefendEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/defend-technique").content(defendTechniqueJsonString)).andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(updatedDefendTechniqueJsonString)).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("D3-UI")).andExpect(jsonPath("$.name").value("Config Inventory"));
	}
    
    @Test
    void shouldUpdateAttackGroupEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/attack-technique-group").content(attackTechniqueGroupJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(put(location).content(updatedAttackTechniqueGroupJsonString)).andExpect(status().isNoContent());
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T1550")).andExpect(
						jsonPath("$.name").value("Abuse Elevation Control Mechanism"));
	}
    
    @Test
    void shouldUpdateDefendGroupEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/defend-technique-group").content(defendTechniqueGroupJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(put(location).content(updatedDefendTechniqueGroupJsonString)).andExpect(status().isNoContent());
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("D3-II")).andExpect(jsonPath("$.name").value("Asset Inventory"));
	}
    // end::updateEntityTests[]
    
    // tag::partiallyUpdateEntityTests[]
    @Test
    void shouldPartiallyUpdateAttackEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/attack-technique").content(attackTechniqueJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(
				patch(location).content("{\"name\": \"Abuse Elevation Control Mechanism: Updated Advanced Elevation\"}")).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T1548.002")).andExpect(jsonPath("$.name").value("Abuse Elevation Control Mechanism: Updated Advanced Elevation"));
	}
    
    @Test
    void shouldPartiallyUpdateDefendEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/defend-technique").content(defendTechniqueJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(
				patch(location).content("{\"name\": \"Initial Inventory\"}")).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("D3-CI")).andExpect(jsonPath("$.name").value("Initial Inventory"));
	}
    
    @Test
    void shouldPartiallyUpdateAttackGroupEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/attack-technique-group").content(attackTechniqueGroupJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(
				patch(location).content("{\"name\": \"Advanced Abuse Elevation Control Mechanism\"}")).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("T1548")).andExpect(jsonPath("$.name").value("Advanced Abuse Elevation Control Mechanism"));
	}
    
    @Test
    void shouldPartiallyUpdateDefendGroupEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/defend-technique-group").content(defendTechniqueGroupJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(
				patch(location).content("{\"name\": \"Initial Group Inventory\"}")).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.mitreId").value("D3-AI")).andExpect(jsonPath("$.name").value("Initial Group Inventory"));
	}
    // end::partiallyUpdateEntityTests[]

    // tag::deleteEntityTests[]
    @Test
    void shouldDeleteAttackEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/attack-technique").content(attackTechniqueJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());
		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
    
    @Test
    void shouldDeleteDefendEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/defend-technique").content(defendTechniqueJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());
		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
    
    @Test
    void shouldDeleteAttackGroupEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/attack-technique-group").content(attackTechniqueGroupJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());
		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
    
    @Test
    void shouldDeleteDefendGroupEntity() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/defend-technique-group").content(defendTechniqueGroupJsonString)).andExpect(status().isCreated()).andReturn();
		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());
		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
    // end::deleteEntityTests[]
}