package com.luchavor.neo4japi.model.technique;

import java.util.UUID;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import com.luchavor.datamodel.technique.TechniqueItem;

public class Neo4jTechnique extends TechniqueItem {	
	// neo4j id
	@Id @GeneratedValue private UUID id;
}