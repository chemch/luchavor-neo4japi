package com.luchavor.neo4japi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luchavor.datamodel.artifact.Artifact;
import com.luchavor.datamodel.artifact.ArtifactImpl;
import com.luchavor.datamodel.artifact.network.observation.observedhost.ObservedHost;
import com.luchavor.datamodel.artifact.network.observation.observedhost.ObservedHostImpl;
import com.luchavor.neo4japi.persistence.artifact.ArtifactRepo;
import com.luchavor.neo4japi.persistence.artifact.network.observation.ObservedHostRepo;

@Component
public class ArtifactDao {
	
	@Autowired
	ObservedHostRepo observedHostRepo;
	
	public void save(ObservedHost observedHost) {
		observedHostRepo.save((ObservedHostImpl) observedHost);
	}
	
	@Autowired
	ArtifactRepo artifactRepo;
	
	public void save(Artifact<?> artifact) {
		artifactRepo.save((ArtifactImpl<?>) artifact);
	}
	
//	public Boolean exists(String cuid) {
//		artifactRepo.fin
//	}
}