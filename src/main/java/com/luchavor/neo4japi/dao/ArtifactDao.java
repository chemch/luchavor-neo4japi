package com.luchavor.neo4japi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luchavor.datamodel.artifact.Artifact;
import com.luchavor.datamodel.artifact.ArtifactImpl;
import com.luchavor.neo4japi.persistence.artifact.ArtifactRepo;

@Component
public class ArtifactDao {
	
	@Autowired
	ArtifactRepo artifactRepo;
	
	public void save(Artifact<?> artifact) {
		artifactRepo.save((ArtifactImpl<?>) artifact);
	}
}