package com.luchavor.neo4japi.persistence.artifact.network.session;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luchavor.datamodel.artifact.network.session.modbus.ModbusEventImpl;

@RepositoryRestResource(collectionResourceRel = "modbusEvent", path = "modbusEvent")
public interface ModbusEventRepo extends PagingAndSortingRepository<ModbusEventImpl, UUID>, CrudRepository<ModbusEventImpl, UUID> {
}