package com.luchavor.neo4japi.config.infocontributor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import com.luchavor.datamodel.artifact.ArtifactImpl;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class ApiSessionNodeCountContributor extends AbstractRepositoryEventListener<ArtifactImpl<?>>{
	@Autowired
	MeterRegistry meterRegistry;
	
	@Override
	protected void onAfterCreate(ArtifactImpl<?> event) {
		meterRegistry.counter("artifact", "uid", event.getId().toString()).increment(); 
	}
}