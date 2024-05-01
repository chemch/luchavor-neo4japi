package com.luchavor.neo4japi.persistence.artifact.network.observation;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.observation.observedfile.ObservedFile;
import com.luchavor.datamodel.artifact.network.observation.observedfile.ObservedFileImpl;

@RepositoryRestResource(collectionResourceRel = "file", path = "file")
public interface ObservedFileRepo extends PagingAndSortingRepository<ObservedFileImpl, UUID>, CrudRepository<ObservedFileImpl, UUID> {
	Optional<ObservedFile> findByFuid(String fuid);
}