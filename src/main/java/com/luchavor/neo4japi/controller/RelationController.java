package com.luchavor.neo4japi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.luchavor.neo4japi.service.TechniqueService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/relation")
@Slf4j
public class RelationController {
	
	@Autowired
	TechniqueService techniqueService;
	
	@PostMapping("/technique")
	@ResponseBody
	public ResponseEntity<String> addTechniqueRelations() {
		log.info("Building Technique Composite Relationships to Children");
		techniqueService.buildTechniqueRelations();
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}