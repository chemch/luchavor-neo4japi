package com.luchavor.neo4japi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchavor.neo4japi.model.CompositeTechnique;
import com.luchavor.neo4japi.model.SingleTechnique;
import com.luchavor.neo4japi.model.Technique;
import com.luchavor.neo4japi.data.CompositeTechniqueRepo;
import com.luchavor.neo4japi.data.SingleTechniqueRepo;
import java.util.ArrayList;

@Service
public class TechniqueService {
	
	@Autowired
	SingleTechniqueRepo singleTechniqueRepo;
	
	@Autowired
	CompositeTechniqueRepo compositeTechniqueRepo;
	
	public void addSingleTechniques(List<SingleTechnique> techniques) {
		singleTechniqueRepo.saveAll(techniques);
	}
	
	public void addCompositeTechniques(List<CompositeTechnique> composites) {
		compositeTechniqueRepo.saveAll(composites);
	}
	
	public void deleteAllTechniques() {
		singleTechniqueRepo.deleteAll();
		compositeTechniqueRepo.deleteAll();
	}
	
	public void buildTechniqueRelations() {
		// get all composites
		Iterable<CompositeTechnique> composites = compositeTechniqueRepo.findAll();
		
		// loop through composites adding children along the way
		composites.forEach(composite -> {
			// get children (both composite children and single children)
			List<Technique> children = new ArrayList<>();
			children.addAll(singleTechniqueRepo.findByParentMitreId(composite.getMitreId()));
			children.addAll(compositeTechniqueRepo.findByParentMitreId(composite.getMitreId()));
			// add children
			children.forEach(child -> {
				composite.add(child);
			});
			// save updated composite
			compositeTechniqueRepo.save((CompositeTechnique) composite);
		});
	}
}