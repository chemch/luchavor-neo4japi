package com.luchavor.neo4japi.persistence.finding.state;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.finding.state.PotentialFindingState;

@RepositoryRestResource(collectionResourceRel = "potentialFindingState", path = "potentialFindingState")
public interface PotentialFindingStateRepo extends PagingAndSortingRepository<PotentialFindingState, UUID>, CrudRepository<PotentialFindingState, UUID> {
}