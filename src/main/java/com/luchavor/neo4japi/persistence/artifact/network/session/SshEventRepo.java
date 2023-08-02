package com.luchavor.neo4japi.persistence.artifact.network.session;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.session.ssh.SshEventImpl;

@RepositoryRestResource(collectionResourceRel = "sshEvent", path = "sshEvent")
public interface SshEventRepo extends PagingAndSortingRepository<SshEventImpl, UUID>, CrudRepository<SshEventImpl, UUID> {	
}