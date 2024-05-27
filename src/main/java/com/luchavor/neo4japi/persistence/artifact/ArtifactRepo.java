package com.luchavor.neo4japi.persistence.artifact;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.Artifact;
import com.luchavor.datamodel.artifact.ArtifactImpl;
import com.luchavor.datamodel.artifact.network.session.Session;



@RepositoryRestResource(collectionResourceRel = "artifact", path = "artifact")
public interface ArtifactRepo extends PagingAndSortingRepository<ArtifactImpl<?>, UUID>, CrudRepository<ArtifactImpl<?>, UUID> {
	Artifact<Session> findByValue(Session value);
}