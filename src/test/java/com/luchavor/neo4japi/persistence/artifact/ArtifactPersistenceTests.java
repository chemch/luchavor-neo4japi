package com.luchavor.neo4japi.persistence.artifact;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.luchavor.datamodel.artifact.Artifact;
import com.luchavor.datamodel.artifact.ArtifactImpl;
import com.luchavor.datamodel.artifact.ArtifactTests;
import com.luchavor.neo4japi.persistence.artifact.network.observation.CertificateRepo;
import com.luchavor.neo4japi.persistence.artifact.network.observation.ExecutableRepo;
import com.luchavor.neo4japi.persistence.artifact.network.observation.FileRepo;
import com.luchavor.neo4japi.persistence.artifact.network.observation.HostRepo;
import com.luchavor.neo4japi.persistence.artifact.network.observation.ServiceRepo;
import com.luchavor.neo4japi.persistence.artifact.network.observation.SmbFileRepo;
import com.luchavor.neo4japi.persistence.artifact.network.observation.SoftwareRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.AnomalyEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.ConnectionRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.DnsEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.HttpEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.KerberosEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.NtlmEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.RpcEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.SessionRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.SmbEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.SslEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.state.ClosedSessionStateRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.state.OpenSessionStateRepo;
import com.luchavor.neo4japi.persistence.artifact.state.CompleteArtifactStateRepo;
import com.luchavor.neo4japi.persistence.artifact.state.EmptyArtifactStateRepo;
import com.luchavor.neo4japi.persistence.artifact.state.PartialArtifactStateRepo;

@SpringBootTest
@ActiveProfiles("test")
public class ArtifactPersistenceTests {
	private ArtifactTests artifactTests = new ArtifactTests();
	
	@Autowired
	ArtifactRepo artifactRepo;
	
	@Autowired
	SessionRepo sessionRepo;
	
	@Autowired
	FileRepo fileRepo;
	
	@Autowired
	SmbFileRepo smbFileRepo;
	
	@Autowired
	ExecutableRepo executableRepo;
	
	@Autowired
	SoftwareRepo softwareRepo;
	
	@Autowired
	ServiceRepo serviceRepo;
	
	@Autowired
	HostRepo hostRepo;
	
	@Autowired
	ConnectionRepo connectionRepo;
	
	@Autowired
	DnsEventRepo dnsEventRepo;
	
	@Autowired
	HttpEventRepo httpEventRepo;
	
	@Autowired
	SmbEventRepo smbEventRepo;
	
	@Autowired
	KerberosEventRepo kerberosEventRepo;
	
	@Autowired
	SslEventRepo sslEventRepo;
	
	@Autowired
	RpcEventRepo rpcEventRepo;
	
	@Autowired
	NtlmEventRepo ntlmEventRepo;
	
	@Autowired
	AnomalyEventRepo anomalyEventRepo;
	
	@Autowired
	CompleteArtifactStateRepo completeArtifactStateRepo;
	
	@Autowired
	PartialArtifactStateRepo partialArtifactStateRepo;
	
	@Autowired
	EmptyArtifactStateRepo emptyArtifactStateRepo;
	
	@Autowired
	CertificateRepo certificateRepo;
	
	@Autowired
	ClosedSessionStateRepo closedSessionStateRepo;
	
	@Autowired
	OpenSessionStateRepo openSessionStateRepo;
	
    @BeforeEach
    void deleteAllBeforeTests() throws Exception {
    	anomalyEventRepo.deleteAll();
    	artifactRepo.deleteAll();
    	certificateRepo.deleteAll();
    	sessionRepo.deleteAll();
    	connectionRepo.deleteAll();
    	fileRepo.deleteAll();
    	executableRepo.deleteAll();
    	smbFileRepo.deleteAll();
    	softwareRepo.deleteAll();
    	serviceRepo.deleteAll();
    	hostRepo.deleteAll();
    	dnsEventRepo.deleteAll();
    	httpEventRepo.deleteAll();
    	kerberosEventRepo.deleteAll();
    	smbEventRepo.deleteAll();
    	ntlmEventRepo.deleteAll();
    	sslEventRepo.deleteAll();
    	rpcEventRepo.deleteAll();
    	completeArtifactStateRepo.deleteAll();
    	emptyArtifactStateRepo.deleteAll();
    	partialArtifactStateRepo.deleteAll();
    	openSessionStateRepo.deleteAll();
    	closedSessionStateRepo.deleteAll();
	}
    
    @Test
    void shouldAddArtifactsSafely() throws Exception {
    	// load all artifacts
		loadSessionArtifacts();
		loadObservationArtifacts();
	}    
    
    private void loadSessionArtifacts() throws Exception {
    	Artifact<?> artifact1 = artifactTests.getArtifact1();
		Artifact<?> artifact2 = artifactTests.getArtifact2();
		Artifact<?> artifact3 = artifactTests.getArtifact3();
		Artifact<?> artifact4 = artifactTests.getArtifact4();
		Artifact<?> artifact5 = artifactTests.getArtifact5();
		Artifact<?> artifact8 = artifactTests.getArtifact8();
		Artifact<?> artifact9 = artifactTests.getArtifact9();
		// examine object for nullness
		assertNotNull(artifact1);
		assertNotNull(artifact2);
		assertNotNull(artifact3);
		assertNotNull(artifact4);
		assertNotNull(artifact5);
		assertNotNull(artifact8);
		assertNotNull(artifact9);
		// save objects1
		artifactRepo.save((ArtifactImpl<?>) artifact1);
		artifactRepo.save((ArtifactImpl<?>) artifact2);
		artifactRepo.save((ArtifactImpl<?>) artifact3);
		artifactRepo.save((ArtifactImpl<?>) artifact4);
		artifactRepo.save((ArtifactImpl<?>) artifact5);
		artifactRepo.save((ArtifactImpl<?>) artifact8);
		artifactRepo.save((ArtifactImpl<?>) artifact9);
    }
    
    private void loadObservationArtifacts() throws Exception {
    	Artifact<?> artifact6 = artifactTests.getArtifact6();
		Artifact<?> artifact7 = artifactTests.getArtifact7();
		Artifact<?> artifact10 = artifactTests.getArtifact10();
		Artifact<?> artifact11 = artifactTests.getArtifact11();
		Artifact<?> artifact12 = artifactTests.getArtifact12();
		Artifact<?> artifact13 = artifactTests.getArtifact13();
		Artifact<?> artifact14 = artifactTests.getArtifact14();
		// examine object for nullness
		assertNotNull(artifact6);
		assertNotNull(artifact7);
		assertNotNull(artifact10);
		assertNotNull(artifact11);
		assertNotNull(artifact12);
		assertNotNull(artifact13);
		assertNotNull(artifact14);
		// save objects
		artifactRepo.save((ArtifactImpl<?>) artifact6);
		artifactRepo.save((ArtifactImpl<?>) artifact7);
		artifactRepo.save((ArtifactImpl<?>) artifact10);
		artifactRepo.save((ArtifactImpl<?>) artifact11);
		artifactRepo.save((ArtifactImpl<?>) artifact12);
		artifactRepo.save((ArtifactImpl<?>) artifact13);
		artifactRepo.save((ArtifactImpl<?>) artifact14);
    }
}