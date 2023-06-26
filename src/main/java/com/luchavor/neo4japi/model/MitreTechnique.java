package com.luchavor.neo4japi.model;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import com.luchavor.datamodel.technique.SingleTechnique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Technique")
@EqualsAndHashCode(callSuper=true)
public class MitreTechnique extends SingleTechnique {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MitreTechnique.class);
	
	// neo4j id
	@Id @GeneratedValue private UUID id;
}