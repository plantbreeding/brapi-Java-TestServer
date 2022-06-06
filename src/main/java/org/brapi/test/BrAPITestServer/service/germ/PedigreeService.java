package org.brapi.test.BrAPITestServer.service.germ;

import java.util.List;
import java.util.Map;

import org.brapi.test.BrAPITestServer.repository.germ.GermplasmRepository;
import org.brapi.test.BrAPITestServer.repository.germ.PedigreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.PedigreeNode;
import io.swagger.model.germ.PedigreeSearchRequest;
import jakarta.validation.Valid;

@Service
public class PedigreeService {

	private final GermplasmRepository germplasmRepository;
	private final PedigreeRepository pedigreeRepository;

	@Autowired
	public PedigreeService(GermplasmRepository germplasmRepository, PedigreeRepository pedigreeRepository) {
		this.germplasmRepository = germplasmRepository;
		this.pedigreeRepository = pedigreeRepository;
	}

	public List<PedigreeNode> findPedigree(String germplasmPUI, String germplasmDbId, String germplasmName,
			String accessionNumber, String collection, String binomialName, String genus, String species,
			String trialDbId, String studyDbId, String synonym, String commonCropName, String programDbId,
			String externalReferenceId, String externalReferenceSource, Metadata metadata) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PedigreeNode> findPedigree(PedigreeSearchRequest body, Metadata metadata) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PedigreeNode> savePedigree(@Valid List<PedigreeNode> body) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PedigreeNode> updatePedigree(@Valid Map<String, PedigreeNode> body) {
		// TODO Auto-generated method stub
		return null;
	}

}
