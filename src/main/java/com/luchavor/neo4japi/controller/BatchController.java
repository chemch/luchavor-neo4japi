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

import com.luchavor.neo4japi.model.CompositeTechnique;
import com.luchavor.neo4japi.model.SingleTechnique;
import com.luchavor.neo4japi.service.TechniqueService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/batch")
@Slf4j
public class BatchController {
	
	@Autowired
	TechniqueService techniqueService;

	// tag::technique[]
	@PostMapping("/single-technique")
	@ResponseBody
	public ResponseEntity<String> addSingleTechniques(@RequestBody List<SingleTechnique> techniques) {
		log.info("Batch Upload of Single Techniques: Size: " + techniques.size() + " Techniques");
		techniqueService.addSingleTechniques(techniques);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/composite-technique")
	@ResponseBody
	public ResponseEntity<String> addCompositeTechniques(@RequestBody List<CompositeTechnique> composites) {
		log.info("Batch Upload of Composite Techniques: Size: " + composites.size() + " Techniques");
		techniqueService.addCompositeTechniques(composites);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/technique")
	public ResponseEntity<String> deleteAllTechniques() {
		techniqueService.deleteAllTechniques();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	// end::technique[]
}