package com.luchavor.neo4japi.model;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import com.luchavor.datamodel.technique.SingleTechnique;

@Node("Technique")
public class MitreTechnique extends SingleTechnique {
	
	private static final Logger log = LoggerFactory.getLogger(MitreTechnique.class);
	
	// neo4j id
	@Id @GeneratedValue private UUID id;
}