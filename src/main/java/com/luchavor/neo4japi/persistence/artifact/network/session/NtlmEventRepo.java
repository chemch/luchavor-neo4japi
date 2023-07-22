package com.luchavor.neo4japi.persistence.artifact.network.session;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.session.ntlm.NtlmEventImpl;

@RepositoryRestResource(collectionResourceRel = "ntlmEvent", path = "ntlmEvent")
public interface NtlmEventRepo extends PagingAndSortingRepository<NtlmEventImpl, UUID>, CrudRepository<NtlmEventImpl, UUID> {
	
}