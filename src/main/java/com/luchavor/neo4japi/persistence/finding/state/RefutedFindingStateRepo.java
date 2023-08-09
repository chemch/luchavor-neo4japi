package com.luchavor.neo4japi.persistence.finding.state;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.finding.state.RefutedFindingState;

@RepositoryRestResource(collectionResourceRel = "refutedFindingState", path = "refutedFindingState")
public interface RefutedFindingStateRepo extends PagingAndSortingRepository<RefutedFindingState, UUID>, CrudRepository<RefutedFindingState, UUID> {
}