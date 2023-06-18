package com.luchavor.neo4jrest.model.technique;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class TechniqueBase implements Technique {
	
	/* functionality implemented by both the the same way */
	private String mitreId; // t code for offensive techniques and d3 id for defensive techniques
	private String tactic;
	private String name;
	private String description;	

	/* functionality implemented by both independently */
	public void print() {
		throw new UnsupportedOperationException();
	}
	
	public void log() {
		throw new UnsupportedOperationException();
	}
	
	/* functionality implemented by composite only */
	public void add(Technique techniqueBase) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(Technique techniqueBase) {
		throw new UnsupportedOperationException();
	}
	
	public Technique getChild(int i) {
		throw new UnsupportedOperationException();
	}
}