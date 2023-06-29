package com.luchavor.neo4japi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchavor.neo4japi.converter.TechniqueConverter;
import com.luchavor.neo4japi.model.AttackTechnique;
import com.luchavor.neo4japi.model.AttackTechniqueGroup;
import com.luchavor.neo4japi.model.DefendTechniqueGroup;
import com.luchavor.neo4japi.model.DefendTechnique;
import com.luchavor.neo4japi.model.TechniqueGroup;
import com.luchavor.neo4japi.persistence.AttackTechniqueGroupRepo;
import com.luchavor.neo4japi.persistence.AttackTechniqueRepo;
import com.luchavor.neo4japi.persistence.DefendTechniqueGroupRepo;
import com.luchavor.neo4japi.persistence.DefendTechniqueRepo;
import com.luchavor.neo4japi.persistence.TechniqueGroupRepo;
import com.luchavor.datamodel.technique.TechniqueItem;
import com.luchavor.datamodel.mitre.ModelType;
import com.luchavor.datamodel.technique.Technique;

@Service
public class TechniqueService {
	
	@Autowired
	AttackTechniqueRepo attackTechniqueRepo;
	
	@Autowired
	DefendTechniqueRepo defendTechniqueRepo;
	
	@Autowired
	AttackTechniqueGroupRepo attackTechniqueGroupRepo;
	
	@Autowired
	DefendTechniqueGroupRepo defendTechniqueGroupRepo;
	
	@Autowired
	TechniqueGroupRepo techniqueGroupRepo;
	
	@Autowired
	TechniqueConverter techniqueConverter;

	
	public void addSingleTechniques(List<TechniqueItem> techniques) {
		// build and load attack techniques
		List<AttackTechnique> attackTechniques = techniques
				.stream()
				.filter(technique -> technique.getModel().toString().equalsIgnoreCase(ModelType.ATTACK.toString()))
				.map(technique -> { return( techniqueConverter.convertAttackTechnique(technique) ); })
				.collect(Collectors.toList());		
		attackTechniqueRepo.saveAll(attackTechniques);
		// build and load defend techniques
		List<DefendTechnique> defendTechniques = techniques
				.stream()
				.filter(technique -> technique.getModel().toString().equalsIgnoreCase(ModelType.DEFEND.toString()))
				.map(technique -> { return( techniqueConverter.convertDefendTechnique(technique) ); })
				.collect(Collectors.toList());
		defendTechniqueRepo.saveAll(defendTechniques);
	}
	
	public void addCompositeTechniques(List<TechniqueGroup> composites) {
		// build and load attack technique groups
		List<AttackTechniqueGroup> attackTechniqueGroups = composites
				.stream()
				.filter(composite -> composite.getModel().toString().equalsIgnoreCase(ModelType.ATTACK.toString()))
				.map(composite -> { return( techniqueConverter.convertAttackTechniqueGroup( composite ) ); })
				.collect(Collectors.toList());	
		attackTechniqueGroupRepo.saveAll(attackTechniqueGroups);
		// build and load attack technique groups
		List<DefendTechniqueGroup> defendTechniqueGroups = composites
				.stream()
				.filter(composite -> composite.getModel().toString().equalsIgnoreCase(ModelType.DEFEND.toString()))
				.map(composite -> { return( techniqueConverter.convertDefendTechniqueGroup( composite ) ); })
				.collect(Collectors.toList());	
		defendTechniqueGroupRepo.saveAll(defendTechniqueGroups);
	}
	
	public void deleteAllTechniques() {
		this.deleteTechniqueItems();
		this.deleteTechniqueGroups();
	}
	
	private void deleteTechniqueItems() {
		attackTechniqueRepo.deleteAll();
		defendTechniqueRepo.deleteAll();
	}
	
	private void deleteTechniqueGroups() {
		attackTechniqueGroupRepo.deleteAll();
		defendTechniqueGroupRepo.deleteAll();
	}
	
	public void buildTechniqueRelations() {
		// get all composites
		Iterable<TechniqueGroup> composites = techniqueGroupRepo.findAll();
		// loop through composites adding children along the way
		composites.forEach(composite -> {
			// get children (both composite children and single children)
			List<Technique> children = new ArrayList<>();
			// get attack children if the composite is an attackTechniqueGroup
			if(composite.getModel().toString().equalsIgnoreCase(ModelType.ATTACK.toString())) {
				children.addAll(attackTechniqueRepo.findByParentMitreId(composite.getMitreId()));
				children.addAll(attackTechniqueGroupRepo.findByParentMitreId(composite.getMitreId()));
			} else if (composite.getModel().toString().equalsIgnoreCase(ModelType.DEFEND.toString())) { // else get defend children
				children.addAll(defendTechniqueRepo.findByParentMitreId(composite.getMitreId()));
				children.addAll(defendTechniqueGroupRepo.findByParentMitreId(composite.getMitreId()));
			}
			// add children
			children.forEach(child -> { composite.add(child); });
			// save updated composite as applicable
			if(composite.getModel().toString().equalsIgnoreCase(ModelType.ATTACK.toString())) {
				attackTechniqueGroupRepo.save((AttackTechniqueGroup) composite);
			} else if (composite.getModel().toString().equalsIgnoreCase(ModelType.DEFEND.toString())) {
				defendTechniqueGroupRepo.save((DefendTechniqueGroup) composite);
			}
		});
	}
}