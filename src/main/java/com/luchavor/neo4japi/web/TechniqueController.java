package com.luchavor.neo4japi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luchavor.neo4japi.model.SingleTechnique;
import com.luchavor.neo4japi.service.TechniqueService;

@Controller
public class TechniqueController {
	
	@Autowired
	TechniqueService techniqueService;

	@PostMapping("/single-technique")
	@ResponseBody
	public ResponseEntity<String> addSingleTechniques(@RequestBody List<SingleTechnique> techniques) {
		techniqueService.addSingleTechniques(techniques);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}