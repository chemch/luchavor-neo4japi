package com.luchavor.neo4japi.persistence.finding;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.luchavor.datamodel.finding.FindingImpl;

@RepositoryRestResource(collectionResourceRel = "finding", path = "finding")
public interface FindingRepo extends PagingAndSortingRepository<FindingImpl<?>, UUID>, CrudRepository<FindingImpl<?>, UUID> {
}