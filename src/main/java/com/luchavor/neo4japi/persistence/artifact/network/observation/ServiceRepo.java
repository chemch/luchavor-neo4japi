package com.luchavor.neo4japi.persistence.artifact.network.observation;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.observation.observedservice.ObservedService;
import com.luchavor.datamodel.artifact.network.observation.observedservice.ObservedServiceImpl;
import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "service", path = "service")
public interface ServiceRepo extends PagingAndSortingRepository<ObservedServiceImpl, UUID>, CrudRepository<ObservedServiceImpl, UUID> {
	Optional<ObservedService> findByServicesAndHostIp(List<String> services, String hostIp);

	void save(ObservedService observedService);
}