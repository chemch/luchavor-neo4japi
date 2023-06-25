package com.luchavor.neo4japi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchavor.neo4japi.model.AttackTechnique;
import com.luchavor.neo4japi.model.DefendTechnique;
import com.luchavor.neo4japi.model.TechniqueGroup;

import com.luchavor.neo4japi.data.TechniqueGroupRepo;
import com.luchavor.datamodel.technique.SingleTechnique;
import com.luchavor.datamodel.technique.Technique;
import com.luchavor.neo4japi.data.AttackTechniqueRepo;
import com.luchavor.neo4japi.data.DefendTechniqueRepo;

import java.util.ArrayList;

@Service
public class TechniqueService {
	
	@Autowired
	AttackTechniqueRepo attackTechniqueRepo;
	
	@Autowired
	DefendTechniqueRepo defendTechniqueRepo;
	
	@Autowired
	TechniqueGroupRepo techniqueGroupRepo;

	// wrapper to convert SingleTechnique to DefendTechnique
	public DefendTechnique convertDefendTechnique( SingleTechnique singleTechnique ) {
		DefendTechnique defendTechnique = new DefendTechnique();
		defendTechnique.setDescription(singleTechnique.getDescription());
		defendTechnique.setMitreId(singleTechnique.getMitreId());
		defendTechnique.setModel(singleTechnique.getModel());
		defendTechnique.setName(singleTechnique.getName());
		defendTechnique.setParentMitreId(singleTechnique.getParentMitreId());
		defendTechnique.setTactic(singleTechnique.getTactic());
		defendTechnique.setTreeLevel(singleTechnique.getTreeLevel());
		return defendTechnique;
	}
	
	// wrapper to convert SingleTechnique to AttackTechnique
	public AttackTechnique convertAttackTechnique( SingleTechnique singleTechnique ) {
		AttackTechnique attackTechnique = new AttackTechnique();
		attackTechnique.setDescription(singleTechnique.getDescription());
		attackTechnique.setMitreId(singleTechnique.getMitreId());
		attackTechnique.setModel(singleTechnique.getModel());
		attackTechnique.setName(singleTechnique.getName());
		attackTechnique.setParentMitreId(singleTechnique.getParentMitreId());
		attackTechnique.setTactic(singleTechnique.getTactic());
		attackTechnique.setTreeLevel(singleTechnique.getTreeLevel());
		return attackTechnique;
	}
	
	public void addSingleTechniques(List<SingleTechnique> techniques) {
		// build and load attack techniques
		List<AttackTechnique> attackTechniques = techniques
				.stream()
				.filter(technique -> technique.getModel().toString().equalsIgnoreCase("ATT&CK"))
				.map(technique -> { return( convertAttackTechnique( technique ) ); })
				.collect(Collectors.toList());		
		attackTechniqueRepo.saveAll(attackTechniques);
		// build and load defend techniques
		List<DefendTechnique> defendTechniques = techniques
				.stream()
				.filter(technique -> technique.getModel().toString().equalsIgnoreCase("D3FEND"))
				.map(technique -> { return( convertDefendTechnique( technique ) ); })
				.collect(Collectors.toList());
		defendTechniqueRepo.saveAll(defendTechniques);
	}
	
	public void addCompositeTechniques(List<TechniqueGroup> composites) {
		techniqueGroupRepo.saveAll(composites);
	}
	
	public void deleteAllTechniques() {
		attackTechniqueRepo.deleteAll();
		defendTechniqueRepo.deleteAll();
		techniqueGroupRepo.deleteAll();
	}
	
	public void buildTechniqueRelations() {
		// get all composites
		Iterable<TechniqueGroup> composites = techniqueGroupRepo.findAll();
		
		// loop through composites adding children along the way
		composites.forEach(composite -> {
			// get children (both composite children and single children)
			List<Technique> children = new ArrayList<>();
			children.addAll(attackTechniqueRepo.findByParentMitreId(composite.getMitreId()));
			children.addAll(defendTechniqueRepo.findByParentMitreId(composite.getMitreId()));
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