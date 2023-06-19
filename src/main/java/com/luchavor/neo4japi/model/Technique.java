package com.luchavor.neo4japi.model;

public interface Technique {
	
	// model is either ATT&CK or D3FEND model
	public String getModel();
	public void setModel(String model);

	// mitre id is either t code for ATT&CK or D3 id for D3FEND
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
	
	// parent mitre id is either t code for ATT&CK or D3 id for D3FEND
	public String getParentMitreId();
	public void setParentMitreId(String id);
	
	// tree level is the level in the tree where this technique sits 
	public String getTreeLevel();
	public void setTreeLevel(String level);

	/* functionality implemented by both single and composity independently */
	public void print();
	public void log();
	
	/* functionality implemented by composite only */
	public void add(Technique technique);
	public void remove(Technique technique);
	public Technique getChild(int i);
}