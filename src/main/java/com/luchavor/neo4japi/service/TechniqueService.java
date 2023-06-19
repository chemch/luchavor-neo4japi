package com.luchavor.neo4japi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchavor.neo4japi.model.CompositeTechnique;
import com.luchavor.neo4japi.model.SingleTechnique;
import com.luchavor.neo4japi.data.CompositeTechniqueRepo;
import com.luchavor.neo4japi.data.SingleTechniqueRepo;

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
}