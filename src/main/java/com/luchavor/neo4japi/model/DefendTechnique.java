package com.luchavor.neo4japi.model;


import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Node("DefendTechnique")
@EqualsAndHashCode(callSuper=true)
public class DefendTechnique extends Neo4jTechnique { 
	/* inherits everything from parent  */
}