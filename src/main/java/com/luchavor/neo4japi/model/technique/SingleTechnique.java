package com.luchavor.neo4japi.model.technique;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Technique")
public class SingleTechnique extends TechniqueBase {
	
	private static final Logger log = LoggerFactory.getLogger(SingleTechnique.class);
	
	// neo4j id
	@Id @GeneratedValue private UUID id;
	
	// custom print
	public void print() {
		System.out.print(this.toString());
	}
	
	// custom log
	public void log() {
		log.info(this.toString());
	}
	
	@Override
	public String toString() {
		return "mitreId: " + this.getMitreId() + ", tactic: " + this.getTactic() + ", name: " + this.getName() + ", description: " + this.getDescription();
	}
}