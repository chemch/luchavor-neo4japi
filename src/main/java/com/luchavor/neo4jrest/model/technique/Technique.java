package com.luchavor.neo4jrest.model.technique;

public interface Technique {

	// mitre id getters and setters
	public String getMitreId();
	public void setMitreId(String id);

	// tactic getters and setters
	public String getTactic();
	public void setTactic(String tactic);
	
	// technique name
	public String getName();
	public void setName( String name );
	
	// technique description
	public String getDescription();
	public void setDescription( String description );

	/* functionality implemented by both single and composity independently */
	public void print();
	public void log();
	
	/* functionality implemented by composite only */
	public void add(Technique technique);
	public void remove(Technique technique);
	public Technique getChild(int i);
}