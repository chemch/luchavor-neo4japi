package com.luchavor.neo4japi.persistence.detection;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.detection.zeeknotification.ZeekNotificationImpl;

@RepositoryRestResource(collectionResourceRel = "zeekNotification", path = "zeekNotification")
public interface ZeekNotificationRepo extends PagingAndSortingRepository<ZeekNotificationImpl, UUID>, CrudRepository<ZeekNotificationImpl, UUID> {
}