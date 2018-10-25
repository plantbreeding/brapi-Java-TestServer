package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.GermplasmAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.AttributesApi;
import io.swagger.model.GermplasmAttributeCategoriesResponse;
import io.swagger.model.GermplasmAttributeCategoriesResponseResult;
import io.swagger.model.GermplasmAttributeCategory;
import io.swagger.model.GermplasmAttributeDef;
import io.swagger.model.GermplasmAttributeDefsResponse;
import io.swagger.model.GermplasmAttributeDefsResponseResult;
import io.swagger.model.Metadata;

@RestController
public class GermplasmAttributeController extends BrAPIController implements AttributesApi {
	private GermplasmAttributeService germplasmAttributeService;

	@Autowired
	public GermplasmAttributeController(GermplasmAttributeService germplasmAttributeService) {
		this.germplasmAttributeService = germplasmAttributeService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeCategoriesResponse> attributesCategoriesGet(@Valid Integer page,
			@Valid Integer pageSize, String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<GermplasmAttributeCategory> data = germplasmAttributeService.getGermplasmAttributeCategories(metaData);

		GermplasmAttributeCategoriesResponseResult result = new GermplasmAttributeCategoriesResponseResult();
		result.setData(data);
		GermplasmAttributeCategoriesResponse response = new GermplasmAttributeCategoriesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GermplasmAttributeCategoriesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeDefsResponse> attributesGet(@Valid String attributeCategoryDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<GermplasmAttributeDef> data = germplasmAttributeService.getGermplasmAttributes(attributeCategoryDbId,
				metaData);

		GermplasmAttributeDefsResponseResult result = new GermplasmAttributeDefsResponseResult();
		result.setData(data);
		GermplasmAttributeDefsResponse response = new GermplasmAttributeDefsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GermplasmAttributeDefsResponse>(response, HttpStatus.OK);
	}

}
