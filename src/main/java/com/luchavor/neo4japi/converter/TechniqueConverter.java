package com.luchavor.neo4japi.converter;

import org.springframework.stereotype.Component;

import com.luchavor.datamodel.mitre.ModelType;
import com.luchavor.datamodel.technique.TechniqueItem;
import com.luchavor.datamodel.techniquegroup.TechniqueGroup;
import com.luchavor.neo4japi.model.technique.AttackTechnique;
import com.luchavor.neo4japi.model.technique.DefendTechnique;
import com.luchavor.neo4japi.model.techniquegroup.AttackTechniqueGroup;
import com.luchavor.neo4japi.model.techniquegroup.DefendTechniqueGroup;

@Component
public class TechniqueConverter {	
		
	// converter to convert TechniqueItem to AttackTechnique
	public DefendTechnique toDefendTechnique( TechniqueItem techniqueItem ) {
		DefendTechnique converted = new DefendTechnique();
		converted.setDescription(techniqueItem.getDescription());
		converted.setMitreId(techniqueItem.getMitreId());
		converted.setModel(ModelType.DEFEND);
		converted.setSubModel(techniqueItem.getSubModel());
		converted.setName(techniqueItem.getName());
		converted.setParentMitreId(techniqueItem.getParentMitreId());
		converted.setTactic(techniqueItem.getTactic());
		return converted;
	}
	
	// converter to convert TechniqueItem to AttackTechnique
	public AttackTechnique toAttackTechnique( TechniqueItem techniqueItem ) {
		AttackTechnique converted = new AttackTechnique();
		converted.setDescription(techniqueItem.getDescription());
		converted.setMitreId(techniqueItem.getMitreId());
		converted.setModel(ModelType.ATTACK);
		converted.setSubModel(techniqueItem.getSubModel());
		converted.setName(techniqueItem.getName());
		converted.setParentMitreId(techniqueItem.getParentMitreId());
		converted.setTactic(techniqueItem.getTactic());
		return converted;
	}
	
	// converter to convert techinqueGroup to DefendTechniqueGroup
	public DefendTechniqueGroup toDefendTechniqueGroup( TechniqueGroup techniqueGroup ) {
		DefendTechniqueGroup converted = new DefendTechniqueGroup();
		converted.setDescription(techniqueGroup.getDescription());
		converted.setMitreId(techniqueGroup.getMitreId());
		converted.setModel(ModelType.DEFEND);
		converted.setSubModel(techniqueGroup.getSubModel());
		converted.setName(techniqueGroup.getName());
		converted.setParentMitreId(techniqueGroup.getParentMitreId());
		converted.setTactic(techniqueGroup.getTactic());
		return converted;
	}
	
	// converter to convert techniqueGroup to AttackTechniqueGroup
	public AttackTechniqueGroup toAttackTechniqueGroup( TechniqueGroup techniqueGroup ) {
		AttackTechniqueGroup converted = new AttackTechniqueGroup();
		converted.setDescription(techniqueGroup.getDescription());
		converted.setMitreId(techniqueGroup.getMitreId());
		converted.setModel(ModelType.ATTACK);
		converted.setSubModel(techniqueGroup.getSubModel());
		converted.setName(techniqueGroup.getName());
		converted.setParentMitreId(techniqueGroup.getParentMitreId());
		converted.setTactic(techniqueGroup.getTactic());
		return converted;
	}
}