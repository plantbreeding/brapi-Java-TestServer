package org.brapi.test.BrAPITestServer.controller.old;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.BreedingmethodsApi;
import io.swagger.api.GermplasmApi;
import io.swagger.api.GermplasmSearchApi;
import io.swagger.model.BreedingMethod;
import io.swagger.model.BreedingMethodResponse;
import io.swagger.model.BreedingMethodsResponse;
import io.swagger.model.BreedingMethodsResponseResult;
import io.swagger.model.Germplasm;
import io.swagger.model.GermplasmAttribute;
import io.swagger.model.GermplasmAttributeList;
import io.swagger.model.GermplasmAttributeListResponse;
import io.swagger.model.GermplasmMCPD;
import io.swagger.model.GermplasmMCPDResponse;
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

	@Override
	public ResponseEntity<BreedingMethodResponse> breedingmethodsBreedingMethodDbIdGet(@PathVariable("breedingMethodDbId") String breedingMethodDbId,
			String authorization) throws BrAPIServerException {
		BreedingMethod result = germplasmService.getBreedingMethod(breedingMethodDbId);

		BreedingMethodResponse response = new BreedingMethodResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<BreedingMethodResponse>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BreedingMethodsResponse> breedingmethodsGet(@Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<BreedingMethod> data = germplasmService.getBreedingMethods(metadata);

		BreedingMethodsResponseResult result = new BreedingMethodsResponseResult();
		result.setData(data);
		BreedingMethodsResponse response = new BreedingMethodsResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<BreedingMethodsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeListResponse> germplasmGermplasmDbIdAttributesGet(@PathVariable("germplasmDbId") String germplasmDbId,
			@Valid @RequestParam(value = "attributeDbIds", required = false) ArrayList<String> attributeDbIds, 
			@Valid @RequestParam(value = "attributeList", required = false) ArrayList<String> attributeList, 
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<String> attribs = new ArrayList<>();
		if(attributeList != null)
			attribs.addAll(attributeList);
		if(attributeDbIds != null)
			attribs.addAll(attributeDbIds);
		List<GermplasmAttribute> data = germplasmAttributeService.getGermplasmAttributeValues(germplasmDbId,
				attribs, metaData);

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
	public ResponseEntity<GermplasmResponse1> germplasmGermplasmDbIdGet(@PathVariable("germplasmDbId") String germplasmDbId, String authorization)
			throws BrAPIServerException {
		Germplasm result = germplasmService.searchByDbId(germplasmDbId);

		GermplasmResponse1 response = new GermplasmResponse1();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<GermplasmResponse1>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmMarkerprofilesListResponse> germplasmGermplasmDbIdMarkerprofilesGet(
			@PathVariable("germplasmDbId") String germplasmDbId, String authorization) throws BrAPIServerException {
		GermplasmMarkerprofilesList result = germplasmService.searchMarkerProfilesByDbId(germplasmDbId);

		GermplasmMarkerprofilesListResponse response = new GermplasmMarkerprofilesListResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<GermplasmMarkerprofilesListResponse>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GermplasmMCPDResponse> germplasmGermplasmDbIdMcpdGet(@PathVariable("germplasmDbId") String germplasmDbId,
			String authorization) throws BrAPIServerException {
		GermplasmMCPD result = germplasmService.searchMCPDByDbId(germplasmDbId);

		GermplasmMCPDResponse response = new GermplasmMCPDResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<GermplasmMCPDResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PedigreeResponse> germplasmGermplasmDbIdPedigreeGet(@PathVariable("germplasmDbId") String germplasmDbId,
			@Valid String notation, @Valid Boolean includeSiblings, String authorization) throws BrAPIServerException {
		Pedigree result = germplasmService.searchPedigreeByDbId(germplasmDbId, notation, includeSiblings);

		PedigreeResponse response = new PedigreeResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<PedigreeResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgenyResponse> germplasmGermplasmDbIdProgenyGet(@PathVariable("germplasmDbId") String germplasmDbId, String authorization)
			throws BrAPIServerException {
		Progeny result = germplasmService.searchProgenyByDbId(germplasmDbId);

		ProgenyResponse response = new ProgenyResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<ProgenyResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmResponse> germplasmGet(@Valid String germplasmPUI, @Valid String germplasmDbId,
			@Valid String germplasmName, @Valid String commonCropName, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {

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
	@Deprecated
	public ResponseEntity<GermplasmResponse> germplasmSearchGet(@Valid String germplasmPUI, @Valid String germplasmDbId,
			@Valid String germplasmName, @Valid String commonCropName, @Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {
		return germplasmGet(germplasmPUI, germplasmDbId, germplasmName, commonCropName, page, pageSize, null);
	}

	@CrossOrigin
	@Override
	@Deprecated
	public ResponseEntity<GermplasmResponse> germplasmSearchPost(@Valid @RequestBody GermplasmSearchRequest request)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<Germplasm> data = germplasmService.search(request, metaData);

		GermplasmResponseResult result = new GermplasmResponseResult();
		result.setData(data);
		GermplasmResponse response = new GermplasmResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GermplasmResponse>(response, HttpStatus.OK);

	}
}
