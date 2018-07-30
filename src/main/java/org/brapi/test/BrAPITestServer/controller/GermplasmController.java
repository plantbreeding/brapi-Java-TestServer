package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.GermplasmAttributeService;
import org.brapi.test.BrAPITestServer.service.GermplasmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.BreedingmethodsApi;
import io.swagger.api.GermplasmApi;
import io.swagger.api.GermplasmSearchApi;
import io.swagger.model.BreedingMethod;
import io.swagger.model.BreedingMethodResponse;
import io.swagger.model.BreedingMethodResponse1;
import io.swagger.model.BreedingMethodResponseResult;
import io.swagger.model.Germplasm;
import io.swagger.model.GermplasmAttribute;
import io.swagger.model.GermplasmAttributeList;
import io.swagger.model.GermplasmAttributeListResponse;
import io.swagger.model.GermplasmMarkerprofilesList;
import io.swagger.model.GermplasmMarkerprofilesListResponse;
import io.swagger.model.GermplasmResponse;
import io.swagger.model.GermplasmResponse1;
import io.swagger.model.GermplasmResponseResult;
import io.swagger.model.GermplasmSearchRequest;
import io.swagger.model.Metadata;
import io.swagger.model.Pedigree;
import io.swagger.model.PedigreeResponse;
import io.swagger.model.Progeny;
import io.swagger.model.ProgenyResponse;

@RestController
public class GermplasmController extends BrAPIController
		implements GermplasmApi, GermplasmSearchApi, BreedingmethodsApi {

	private GermplasmService germplasmService;
	private GermplasmAttributeService germplasmAttributeService;

	@Autowired
	public GermplasmController(GermplasmService germplasmService, GermplasmAttributeService germplasmAttributeService) {
		super();
		this.germplasmService = germplasmService;
		this.germplasmAttributeService = germplasmAttributeService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmResponse> germplasmSearchGet(@Valid String germplasmPUI, @Valid String germplasmDbId,
			@Valid String germplasmName, @Valid String commonCropName, @Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Germplasm> data = germplasmService.search(germplasmPUI, germplasmDbId, germplasmName, commonCropName,
				metaData);

		GermplasmResponseResult result = new GermplasmResponseResult();
		result.setData(data);
		GermplasmResponse response = new GermplasmResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GermplasmResponse>(response, HttpStatus.OK);

	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmResponse> germplasmSearchPost(@Valid @RequestBody GermplasmSearchRequest request)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<Germplasm> data = germplasmService.search(request.getGermplasmDbIds(), request.getGermplasmGenus(),
				request.getCommonCropNames(), request.getGermplasmNames(), request.getGermplasmPUIs(),
				request.getGermplasmSpecies(), request.getAccessionNumbers(), metaData);

		GermplasmResponseResult result = new GermplasmResponseResult();
		result.setData(data);
		GermplasmResponse response = new GermplasmResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GermplasmResponse>(response, HttpStatus.OK);

	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeListResponse> germplasmGermplasmDbIdAttributesGet(
			@PathVariable("germplasmDbId") String germplasmDbId, @Valid ArrayList<String> attributeDbIds,
			@Valid ArrayList<String> attributeList, @Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<GermplasmAttribute> data = germplasmAttributeService.getGermplasmAttributeValues(germplasmDbId,
				attributeList, metaData);

		GermplasmAttributeList result = new GermplasmAttributeList();
		result.setData(data);
		result.setGermplasmDbId(germplasmDbId);
		GermplasmAttributeListResponse response = new GermplasmAttributeListResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GermplasmAttributeListResponse>(response, HttpStatus.OK);

	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmResponse1> germplasmGermplasmDbIdGet(
			@PathVariable("germplasmDbId") String germplasmDbId) {
		Germplasm result = germplasmService.searchByDbId(germplasmDbId);

		GermplasmResponse1 response = new GermplasmResponse1();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<GermplasmResponse1>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmMarkerprofilesListResponse> germplasmGermplasmDbIdMarkerprofilesGet(
			@PathVariable("germplasmDbId") String germplasmDbId) {
		GermplasmMarkerprofilesList result = germplasmService.searchMarkerProfilesByDbId(germplasmDbId);

		GermplasmMarkerprofilesListResponse response = new GermplasmMarkerprofilesListResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<GermplasmMarkerprofilesListResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PedigreeResponse> germplasmGermplasmDbIdPedigreeGet(
			@PathVariable("germplasmDbId") String germplasmDbId, @Valid String notation,
			@Valid Boolean includeSiblings) {
		Pedigree result = germplasmService.searchPedigreeByDbId(germplasmDbId, notation, includeSiblings);

		PedigreeResponse response = new PedigreeResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<PedigreeResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgenyResponse> germplasmGermplasmDbIdProgenyGet(
			@PathVariable("germplasmDbId") String germplasmDbId) {
		Progeny result = germplasmService.searchProgenyByDbId(germplasmDbId);

		ProgenyResponse response = new ProgenyResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<ProgenyResponse>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BreedingMethodResponse1> breedingmethodsBreedingMethodDbIdGet(
			@PathVariable("breedingMethodDbId") String breedingMethodDbId) {
		BreedingMethod result = germplasmService.getBreedingMethod(breedingMethodDbId);

		BreedingMethodResponse1 response = new BreedingMethodResponse1();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<BreedingMethodResponse1>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BreedingMethodResponse> breedingmethodsGet(@Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<BreedingMethod> data = germplasmService.getBreedingMethods(metadata);

		BreedingMethodResponseResult result = new BreedingMethodResponseResult();
		result.setData(data);
		BreedingMethodResponse response = new BreedingMethodResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<BreedingMethodResponse>(response, HttpStatus.OK);

	}
}
