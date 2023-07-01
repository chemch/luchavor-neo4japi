package com.luchavor.neo4japi.model.technique;


import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Node("AttackTechnique")
public class AttackTechnique extends Neo4jTechnique { 
	/* inherits everything from parent  */
}