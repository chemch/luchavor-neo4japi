package com.luchavor.neo4japi.persistence.artifact.network.observation;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.observation.certificate.CertificateImpl;

@RepositoryRestResource(collectionResourceRel = "certificate", path = "certificate")
public interface CertificateRepo extends PagingAndSortingRepository<CertificateImpl, UUID>, CrudRepository<CertificateImpl, UUID> {
}