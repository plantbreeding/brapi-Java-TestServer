package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttribute;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeCategory;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeMasterWrapper;
import org.springframework.stereotype.Service;

@Service
public class GermplasmAttributeService {

	public List<GermplasmAttribute> getGermplasmAttributes(String attributeCategoryDbId, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GermplasmAttributeCategory> getGermplasmAttributeCategories(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public GermplasmAttributeMasterWrapper getGermplasmAttributes(String germplasmDbId, List<String> attributeList,
			int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
