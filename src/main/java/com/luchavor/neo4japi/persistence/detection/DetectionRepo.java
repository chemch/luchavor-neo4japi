package com.luchavor.neo4japi.persistence.detection;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.detection.DetectionImpl;

@RepositoryRestResource(collectionResourceRel = "detection", path = "detection")
public interface DetectionRepo extends PagingAndSortingRepository<DetectionImpl<?>, UUID>, CrudRepository<DetectionImpl<?>, UUID> {
}