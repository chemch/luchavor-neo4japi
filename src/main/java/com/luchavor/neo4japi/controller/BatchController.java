package com.luchavor.neo4japi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.luchavor.datamodel.technique.TechniqueImpl;
import com.luchavor.datamodel.techniquegroup.TechniqueGroupImpl;
import com.luchavor.neo4japi.service.EventService;
import com.luchavor.neo4japi.service.TechniqueService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/batch")
@Slf4j
public class BatchController {
	
	@Autowired
	TechniqueService techniqueService;
	
	@Autowired
	EventService eventService;

	// tag::techniqueBatchController[]
	@PostMapping("/single-technique")
	@ResponseBody
	public ResponseEntity<String> addSingleTechniques(@RequestBody List<TechniqueImpl> techniques) {
		log.debug("Batch Upload of " + techniques.size() + " Technique Items");
		techniqueService.addSingleTechniques(techniques);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/composite-technique")
	@ResponseBody
	public ResponseEntity<String> addCompositeTechniques(@RequestBody List<TechniqueGroupImpl> composites) {
		log.debug("Batch Upload of " + composites.size() + " Technique Groups");
		techniqueService.addCompositeTechniques(composites);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/technique")
	public ResponseEntity<String> deleteAllTechniques() {
		techniqueService.deleteAllTechniques();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	// end::techniqueBatchController[]
}