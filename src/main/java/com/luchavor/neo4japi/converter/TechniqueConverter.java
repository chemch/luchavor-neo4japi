package com.luchavor.neo4japi.converter;

import org.springframework.stereotype.Component;

import com.luchavor.datamodel.mitre.ModelType;
import com.luchavor.datamodel.technique.AttackTechnique;
import com.luchavor.datamodel.technique.DefendTechnique;
import com.luchavor.datamodel.technique.TechniqueImpl;
import com.luchavor.datamodel.techniquegroup.AttackTechniqueGroup;
import com.luchavor.datamodel.techniquegroup.DefendTechniqueGroup;
import com.luchavor.datamodel.techniquegroup.TechniqueGroupImpl;

@Component
public class TechniqueConverter {	
		
	// converter to convert TechniqueImpl to AttackTechnique
	public DefendTechnique toDefendTechnique( TechniqueImpl techniqueImpl ) {
		DefendTechnique converted = new DefendTechnique();
		converted.setDescription(techniqueImpl.getDescription());
		converted.setMitreId(techniqueImpl.getMitreId());
		converted.setModel(ModelType.DEFEND);
		converted.setSubModel(techniqueImpl.getSubModel());
		converted.setName(techniqueImpl.getName());
		converted.setParentMitreId(techniqueImpl.getParentMitreId());
		converted.setTactic(techniqueImpl.getTactic());
		return converted;
	}
	
	// converter to convert TechniqueImpl to AttackTechnique
	public AttackTechnique toAttackTechnique( TechniqueImpl techniqueImpl ) {
		AttackTechnique converted = new AttackTechnique();
		converted.setDescription(techniqueImpl.getDescription());
		converted.setMitreId(techniqueImpl.getMitreId());
		converted.setModel(ModelType.ATTACK);
		converted.setSubModel(techniqueImpl.getSubModel());
		converted.setName(techniqueImpl.getName());
		converted.setParentMitreId(techniqueImpl.getParentMitreId());
		converted.setTactic(techniqueImpl.getTactic());
		return converted;
	}
	
	// converter to convert techinqueGroup to DefendTechniqueGroup
	public DefendTechniqueGroup toDefendTechniqueGroup( TechniqueGroupImpl techniqueGroupImpl ) {
		DefendTechniqueGroup converted = new DefendTechniqueGroup();
		converted.setDescription(techniqueGroupImpl.getDescription());
		converted.setMitreId(techniqueGroupImpl.getMitreId());
		converted.setModel(ModelType.DEFEND);
		converted.setSubModel(techniqueGroupImpl.getSubModel());
		converted.setName(techniqueGroupImpl.getName());
		converted.setParentMitreId(techniqueGroupImpl.getParentMitreId());
		converted.setTactic(techniqueGroupImpl.getTactic());
		return converted;
	}
	
	// converter to convert techniqueGroup to AttackTechniqueGroup
	public AttackTechniqueGroup toAttackTechniqueGroup( TechniqueGroupImpl techniqueGroupImpl ) {
		AttackTechniqueGroup converted = new AttackTechniqueGroup();
		converted.setDescription(techniqueGroupImpl.getDescription());
		converted.setMitreId(techniqueGroupImpl.getMitreId());
		converted.setModel(ModelType.ATTACK);
		converted.setSubModel(techniqueGroupImpl.getSubModel());
		converted.setName(techniqueGroupImpl.getName());
		converted.setParentMitreId(techniqueGroupImpl.getParentMitreId());
		converted.setTactic(techniqueGroupImpl.getTactic());
		return converted;
	}
}