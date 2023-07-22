package com.luchavor.neo4japi.persistence.artifact.network.session;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.session.smb.SmbEventImpl;

@RepositoryRestResource(collectionResourceRel = "smbEvent", path = "smbEvent")
public interface SmbEventRepo extends PagingAndSortingRepository<SmbEventImpl, UUID>, CrudRepository<SmbEventImpl, UUID> {
	
}