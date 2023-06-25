package com.luchavor.neo4japi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchavor.neo4japi.model.TechniqueGroup;
import com.luchavor.neo4japi.model.MitreTechnique;
import com.luchavor.neo4japi.data.TechniqueGroupRepo;
import com.luchavor.datamodel.technique.Technique;
import com.luchavor.neo4japi.data.MitreTechniqueRepo;
import java.util.ArrayList;

@Service
public class TechniqueService {
	
	@Autowired
	MitreTechniqueRepo mitreTechniqueRepo;
	
	@Autowired
	TechniqueGroupRepo techniqueGroupRepo;
	
	public void addSingleTechniques(List<MitreTechnique> techniques) {
		mitreTechniqueRepo.saveAll(techniques);
	}
	
	public void addCompositeTechniques(List<TechniqueGroup> composites) {
		techniqueGroupRepo.saveAll(composites);
	}
	
	public void deleteAllTechniques() {
		mitreTechniqueRepo.deleteAll();
		techniqueGroupRepo.deleteAll();
	}
	
	public void buildTechniqueRelations() {
		// get all composites
		Iterable<TechniqueGroup> composites = techniqueGroupRepo.findAll();
		
		// loop through composites adding children along the way
		composites.forEach(composite -> {
			// get children (both composite children and single children)
			List<Technique> children = new ArrayList<>();
			children.addAll(mitreTechniqueRepo.findByParentMitreId(composite.getMitreId()));
			children.addAll(techniqueGroupRepo.findByParentMitreId(composite.getMitreId()));
			// add children
			children.forEach(child -> {
				composite.add(child);
			});
			// save updated composite
			techniqueGroupRepo.save((TechniqueGroup) composite);
		});
	}
}