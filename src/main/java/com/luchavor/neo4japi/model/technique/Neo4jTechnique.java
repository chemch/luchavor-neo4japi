package com.luchavor.neo4japi.model.technique;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import com.luchavor.datamodel.technique.TechniqueItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class Neo4jTechnique extends TechniqueItem {	
	// neo4j id
	@Id @GeneratedValue private UUID id;
}