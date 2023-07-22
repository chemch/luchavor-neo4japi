package com.luchavor.neo4japi.persistence.artifact.network.observation;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.observation.service.ServiceImpl;

@RepositoryRestResource(collectionResourceRel = "service", path = "service")
public interface ServiceRepo extends PagingAndSortingRepository<ServiceImpl, UUID>, CrudRepository<ServiceImpl, UUID> {
}