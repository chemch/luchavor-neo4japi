package com.luchavor.neo4japi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.luchavor.datamodel.technique.ModelType;
import com.luchavor.datamodel.technique.TechniqueItem;
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

	// wrapper to convert TechniqueItem to DefendTechnique
	public DefendTechnique convertDefendTechnique( TechniqueItem techniqueItem ) {
		DefendTechnique defendTechnique = new DefendTechnique();
		defendTechnique.setDescription(techniqueItem.getDescription());
		defendTechnique.setMitreId(techniqueItem.getMitreId());
		defendTechnique.setModel(techniqueItem.getModel());
		defendTechnique.setName(techniqueItem.getName());
		defendTechnique.setParentMitreId(techniqueItem.getParentMitreId());
		defendTechnique.setTactic(techniqueItem.getTactic());
		defendTechnique.setTreeLevel(techniqueItem.getTreeLevel());
		return defendTechnique;
	}
	
	// wrapper to convert TechniqueItem to AttackTechnique
	public AttackTechnique convertAttackTechnique( TechniqueItem techniqueItem ) {
		AttackTechnique attackTechnique = new AttackTechnique();
		attackTechnique.setDescription(techniqueItem.getDescription());
		attackTechnique.setMitreId(techniqueItem.getMitreId());
		attackTechnique.setModel(techniqueItem.getModel());
		attackTechnique.setName(techniqueItem.getName());
		attackTechnique.setParentMitreId(techniqueItem.getParentMitreId());
		attackTechnique.setTactic(techniqueItem.getTactic());
		attackTechnique.setTreeLevel(techniqueItem.getTreeLevel());
		return attackTechnique;
	}
	
	// wrapper to convert techinqueGroup to DefendTechniqueGroup
	public DefendTechniqueGroup convertDefendTechniqueGroup( TechniqueGroup techniqueGroup ) {
		DefendTechniqueGroup defendTechniqueGroup = new DefendTechniqueGroup();
		defendTechniqueGroup.setDescription(techniqueGroup.getDescription());
		defendTechniqueGroup.setMitreId(techniqueGroup.getMitreId());
		defendTechniqueGroup.setModel(techniqueGroup.getModel());
		defendTechniqueGroup.setName(techniqueGroup.getName());
		defendTechniqueGroup.setParentMitreId(techniqueGroup.getParentMitreId());
		defendTechniqueGroup.setTactic(techniqueGroup.getTactic());
		defendTechniqueGroup.setTreeLevel(techniqueGroup.getTreeLevel());
		return defendTechniqueGroup;
	}
	
	// wrapper to convert techniqueGroup to AttackTechniqueGroup
	public AttackTechniqueGroup convertAttackTechniqueGroup( TechniqueGroup techniqueGroup ) {
		AttackTechniqueGroup attackTechniqueGroup = new AttackTechniqueGroup();
		attackTechniqueGroup.setDescription(techniqueGroup.getDescription());
		attackTechniqueGroup.setMitreId(techniqueGroup.getMitreId());
		attackTechniqueGroup.setModel(techniqueGroup.getModel());
		attackTechniqueGroup.setName(techniqueGroup.getName());
		attackTechniqueGroup.setParentMitreId(techniqueGroup.getParentMitreId());
		attackTechniqueGroup.setTactic(techniqueGroup.getTactic());
		attackTechniqueGroup.setTreeLevel(techniqueGroup.getTreeLevel());
		return attackTechniqueGroup;
	}
	
	public void addSingleTechniques(List<TechniqueItem> techniques) {
		// build and load attack techniques
		List<AttackTechnique> attackTechniques = techniques
				.stream()
				.filter(technique -> technique.getModel().toString().equalsIgnoreCase(ModelType.ATTACK.toString()))
				.map(technique -> { return( convertAttackTechnique( technique ) ); })
				.collect(Collectors.toList());		
		attackTechniqueRepo.saveAll(attackTechniques);
		// build and load defend techniques
		List<DefendTechnique> defendTechniques = techniques
				.stream()
				.filter(technique -> technique.getModel().toString().equalsIgnoreCase(ModelType.DEFEND.toString()))
				.map(technique -> { return( convertDefendTechnique( technique ) ); })
				.collect(Collectors.toList());
		defendTechniqueRepo.saveAll(defendTechniques);
	}
	
	public void addCompositeTechniques(List<TechniqueGroup> composites) {
		// build and load attack technique groups
		List<AttackTechniqueGroup> attackTechniqueGroups = composites
				.stream()
				.filter(composite -> composite.getModel().toString().equalsIgnoreCase(ModelType.ATTACK.toString()))
				.map(composite -> { return( convertAttackTechniqueGroup( composite ) ); })
				.collect(Collectors.toList());	
		attackTechniqueGroupRepo.saveAll(attackTechniqueGroups);
		// build and load attack technique groups
		List<DefendTechniqueGroup> defendTechniqueGroups = composites
				.stream()
				.filter(composite -> composite.getModel().toString().equalsIgnoreCase(ModelType.DEFEND.toString()))
				.map(composite -> { return( convertDefendTechniqueGroup( composite ) ); })
				.collect(Collectors.toList());	
		defendTechniqueGroupRepo.saveAll(defendTechniqueGroups);
	}
	
	public void deleteAllTechniques() {
		attackTechniqueRepo.deleteAll();
		defendTechniqueRepo.deleteAll();
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
			} else if (composite.getModel().toString().equalsIgnoreCase(ModelType.DEFEND.toString())) { // else get defend children
				defendTechniqueGroupRepo.save((DefendTechniqueGroup) composite);
			}
		});
	}
}