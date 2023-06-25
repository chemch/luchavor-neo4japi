package com.luchavor.neo4japi.model;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import com.luchavor.datamodel.technique.SingleTechnique;
import com.luchavor.datamodel.technique.Technique;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("DefendTechnique")
@EqualsAndHashCode(callSuper=true)
public class DefendTechnique extends SingleTechnique {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(DefendTechnique.class);
	
	// neo4j id
	@Id @GeneratedValue private UUID id;
}