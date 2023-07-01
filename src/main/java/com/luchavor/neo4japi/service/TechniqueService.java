package com.luchavor.neo4japi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchavor.neo4japi.converter.TechniqueConverter;
import com.luchavor.neo4japi.model.technique.AttackTechnique;
import com.luchavor.neo4japi.model.technique.DefendTechnique;
import com.luchavor.neo4japi.model.techniquegroup.AttackTechniqueGroup;
import com.luchavor.neo4japi.model.techniquegroup.DefendTechniqueGroup;
import com.luchavor.neo4japi.model.techniquegroup.TechniqueGroup;
import com.luchavor.neo4japi.persistence.technique.AttackTechniqueRepo;
import com.luchavor.neo4japi.persistence.technique.DefendTechniqueRepo;
import com.luchavor.neo4japi.persistence.techniquegroup.AttackTechniqueGroupRepo;
import com.luchavor.neo4japi.persistence.techniquegroup.DefendTechniqueGroupRepo;
import com.luchavor.neo4japi.persistence.techniquegroup.TechniqueGroupRepo;

import lombok.extern.slf4j.Slf4j;

import com.luchavor.datamodel.technique.TechniqueItem;
import com.luchavor.datamodel.mitre.ModelType;
import com.luchavor.datamodel.technique.Technique;

@Slf4j
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
				.filter(technique -> technique.getModel().equals(ModelType.ATTACK))
				.map(technique -> { return( techniqueConverter.toAttackTechnique(technique) ); })
				.collect(Collectors.toList());		
		attackTechniqueRepo.saveAll(attackTechniques);
		// build and load defend techniques
		List<DefendTechnique> defendTechniques = techniques
				.stream()
				.filter(technique -> technique.getModel().equals(ModelType.DEFEND))
				.map(technique -> { return( techniqueConverter.toDefendTechnique(technique) ); })
				.collect(Collectors.toList());
		defendTechniqueRepo.saveAll(defendTechniques);
	}
	
	public void addCompositeTechniques(List<TechniqueGroup> composites) {
		// build and load attack technique groups
		List<AttackTechniqueGroup> attackTechniqueGroups = composites
				.stream()
				.filter(composite -> composite.getModel().equals(ModelType.ATTACK))
				.map(composite -> { return( techniqueConverter.toAttackTechniqueGroup( composite ) ); })
				.collect(Collectors.toList());	
		attackTechniqueGroupRepo.saveAll(attackTechniqueGroups);
		// build and load attack technique groups
		List<DefendTechniqueGroup> defendTechniqueGroups = composites
				.stream()
				.filter(composite -> composite.getModel().equals(ModelType.DEFEND))
				.map(composite -> { return( techniqueConverter.toDefendTechniqueGroup( composite ) ); })
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
			for(TechniqueGroup composite : composites){
				try {
					// get children (both composite children and single children)
					List<Technique> children = new ArrayList<>();
					// get attack children if the composite is an attackTechniqueGroup
					if(composite.getModel().equals(ModelType.ATTACK)) {
						children.addAll(attackTechniqueRepo.findByParentMitreId(composite.getMitreId()));
						children.addAll(attackTechniqueGroupRepo.findByParentMitreId(composite.getMitreId()));
					} else if (composite.getModel().equals(ModelType.DEFEND)) { // else get defend children
						children.addAll(defendTechniqueRepo.findByParentMitreId(composite.getMitreId()));
						children.addAll(defendTechniqueGroupRepo.findByParentMitreId(composite.getMitreId()));
					}
					// add children
					children.forEach(child -> { composite.add(child); });
					// save updated composite as applicable
					if(composite.getModel().equals(ModelType.ATTACK)) {
						attackTechniqueGroupRepo.save((AttackTechniqueGroup) composite);
					} else if (composite.getModel().equals(ModelType.DEFEND)) {
						defendTechniqueGroupRepo.save((DefendTechniqueGroup) composite);
					}
				} catch (Exception e) {
					log.warn(e.toString());
				}
			}		
	}
}