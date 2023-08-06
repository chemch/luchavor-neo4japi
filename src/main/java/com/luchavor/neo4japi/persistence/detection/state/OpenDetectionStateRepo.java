package com.luchavor.neo4japi.persistence.detection.state;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.detection.state.OpenDetectionState;

@RepositoryRestResource(collectionResourceRel = "openDetectionState", path = "openDetectionState")
public interface OpenDetectionStateRepo extends PagingAndSortingRepository<OpenDetectionState, UUID>, CrudRepository<OpenDetectionState, UUID> {
}