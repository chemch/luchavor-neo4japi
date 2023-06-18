package com.luchavor.neo4japi.model.technique;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("TechniqueGroup")
public class CompositeTechnique extends TechniqueBase {
	
	private static final Logger log = LoggerFactory.getLogger(CompositeTechnique.class);
	
	// neo4j id
	@Id @GeneratedValue private UUID id;
	
	// list of child techniques
	@Relationship(type = "BELONG_TO")
	private List<Technique> techniques = new ArrayList<Technique>();
	
	// custom print
	public void print() {
		// print the composites to string
		System.out.print(this.toString());
		System.out.print("\nChildren:\n");
		// then print the childrens to string
		for (Technique technique : techniques) {
			technique.print();
		}
	}
	
	// custom log
	public void log() {
		log.info(this.toString());
	}
	
	public void add(Technique technique) {
		techniques.add(technique);
	}
	
	public void remove(Technique technique) {
		techniques.remove(technique);
	}
	
	public Technique getChild(int i) {
		return techniques.get(i);
	}
	
	@Override
	public String toString() {
		return "mitreId: " + this.getMitreId() + ", tactic: " + this.getTactic() + ", name: " + this.getName() + ", description: " + this.getDescription();
	}
}