package com.luchavor.neo4japi.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.info.Info.Builder;

import com.luchavor.neo4japi.persistence.artifact.ArtifactRepo;
import com.luchavor.neo4japi.persistence.technique.AttackTechniqueRepo;
import com.luchavor.neo4japi.persistence.technique.DefendTechniqueRepo;

@Component
public class AggregateNodeCountContributor implements InfoContributor {
	
	@Autowired 
	AttackTechniqueRepo attackTechniqueRepo;
	
	@Autowired 
	DefendTechniqueRepo defendTechniqueRepo;
	
	@Autowired 
	ArtifactRepo artifactRepo;
	
	@Override
	public void contribute(Builder builder) {
		// map to hold counts
		Map<String, Object> nodeCountMap = new HashMap<String, Object>();
		// get attack technique count
		long attackTechniqueCount = attackTechniqueRepo.count();
		nodeCountMap.put("attack-technique", attackTechniqueCount);
		// get attack technique count
		long defendTechniqueCount = defendTechniqueRepo.count();
		nodeCountMap.put("defend-technique", defendTechniqueCount);
		// get artifact count
		long artifactCount = artifactRepo.count();
		nodeCountMap.put("artifact", artifactCount);
		// add metrics to contributor
		builder.withDetail("aggregate-node-count", nodeCountMap);
	}
}