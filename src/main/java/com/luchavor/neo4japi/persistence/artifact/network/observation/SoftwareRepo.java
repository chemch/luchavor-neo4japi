package com.luchavor.neo4japi.persistence.artifact.network.observation;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.observation.software.Software;
import com.luchavor.datamodel.artifact.network.observation.software.SoftwareImpl;

@RepositoryRestResource(collectionResourceRel = "software", path = "software")
public interface SoftwareRepo extends PagingAndSortingRepository<SoftwareImpl, UUID>, CrudRepository<SoftwareImpl, UUID> {
	Optional<Software> findByNameAndHostIp(String name, String hostIp);
}