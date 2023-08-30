package com.luchavor.neo4japi.persistence.artifact.network.observation;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.observation.observedhost.ObservedHostImpl;

@RepositoryRestResource(collectionResourceRel = "host", path = "host")
public interface ObservedHostRepo extends PagingAndSortingRepository<ObservedHostImpl, UUID>, CrudRepository<ObservedHostImpl, UUID> {
}