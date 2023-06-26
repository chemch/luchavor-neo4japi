package com.luchavor.neo4japi.model;


import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Node("AttackTechnique")
@EqualsAndHashCode(callSuper=true)
public class AttackTechnique extends MitreTechnique { 
	/* inherits everything from parent  */
}