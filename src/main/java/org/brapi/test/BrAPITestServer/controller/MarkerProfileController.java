package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.AlleleFormatParams;
import org.brapi.test.BrAPITestServer.service.MarkerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.AllelematricesApi;
import io.swagger.api.AllelematricesSearchApi;
import io.swagger.api.AllelematrixSearchApi;
import io.swagger.api.MarkerprofilesApi;
import io.swagger.model.AlleleMatrixDetails;
import io.swagger.model.AlleleMatrixDetailsResponse;
import io.swagger.model.AlleleMatrixDetailsResponseResult;
import io.swagger.model.AlleleMatrixSearchRequest;
import io.swagger.model.AlleleMatrixValues;
import io.swagger.model.AlleleMatrixValuesResponse;
import io.swagger.model.AlleleMatrixValuesResponse1;
import io.swagger.model.MarkerProfile;
import io.swagger.model.MarkerProfileDescription;
import io.swagger.model.MarkerProfileDescriptionsResponse;
import io.swagger.model.MarkerProfileDescriptionsResponseResult;
import io.swagger.model.MarkerProfilesResponse;
import io.swagger.model.Metadata;

@RestController
public class MarkerProfileController extends BrAPIController
		implements MarkerprofilesApi, AllelematricesApi, AllelematricesSearchApi, AllelematrixSearchApi {
	private MarkerProfileService markerProfileService;

	@Autowired
	public MarkerProfileController(MarkerProfileService markerProfileService) {
		this.markerProfileService = markerProfileService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<AlleleMatrixDetailsResponse> allelematricesGet(@NotNull @Valid String studyDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<AlleleMatrixDetails> data = markerProfileService.getAlleleMatrixDetailsByStudyDbId(studyDbId, metaData);

		AlleleMatrixDetailsResponseResult result = new AlleleMatrixDetailsResponseResult();
		result.setData(data);
		AlleleMatrixDetailsResponse response = new AlleleMatrixDetailsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<AlleleMatrixDetailsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<AlleleMatrixValuesResponse> allelematricesSearchGet(
			@Valid @RequestParam(value = "markerprofileDbId", required = false) ArrayList<String> markerprofileDbId,
			@Valid @RequestParam(value = "markerProfileDbId", required = false) ArrayList<String> markerProfileDbId2,
			@Valid @RequestParam(value = "markerDbId", required = false) ArrayList<String> markerDbId,
			@Valid @RequestParam(value = "matrixDbId", required = false) ArrayList<String> matrixDbId,
			@Valid String format, @Valid Boolean expandHomozygotes, @Valid String unknownString,
			@Valid String sepPhased, @Valid String sepUnphased, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		AlleleFormatParams params = markerProfileService.buildFormatParams(expandHomozygotes, sepPhased, sepUnphased,
				unknownString);

		List<String> markerProfiles = new ArrayList<>();
		if (markerprofileDbId != null) {
			markerProfiles.addAll(markerprofileDbId);
		}
		if (markerProfileDbId2 != null) {
			markerProfiles.addAll(markerProfileDbId2);
		}
		
		List<List<String>> data = markerProfileService.getAlleleMatrix(markerProfiles, markerDbId, matrixDbId,
				params, metaData);

		AlleleMatrixValues result = new AlleleMatrixValues();
		result.setData(data);
		AlleleMatrixValuesResponse response = new AlleleMatrixValuesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<AlleleMatrixValuesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<AlleleMatrixValuesResponse> allelematricesSearchPost(
			@Valid @RequestBody AlleleMatrixSearchRequest request, String authorization) throws BrAPIServerException {

		AsyncMetadata metaData = generateAsynchMetaDataTemplate(request.getPage(), request.getPageSize());
		AlleleFormatParams params = markerProfileService.buildFormatParams(request.isExpandHomozygotes(),
				request.getSepPhased(), request.getSepUnphased(), request.getUnknownString());

		List<List<String>> data = markerProfileService.getAlleleMatrix(request.getMarkerprofileDbId(),
				request.getMarkerDbId(), request.getMatrixDbId(), params, metaData);

		AlleleMatrixValues result = new AlleleMatrixValues();
		result.setData(data);
		AlleleMatrixValuesResponse response = new AlleleMatrixValuesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<AlleleMatrixValuesResponse>(response, HttpStatus.OK);
	}

	@Deprecated
	@CrossOrigin
	@Override
	public ResponseEntity<AlleleMatrixValuesResponse1> allelematrixSearchGet(@Valid ArrayList<String> markerprofileDbId,
			@Valid ArrayList<String> markerDbId, @Valid ArrayList<String> matrixDbId, @Valid String format,
			@Valid Boolean expandHomozygotes, @Valid String unknownString, @Valid String sepPhased,
			@Valid String sepUnphased, @Valid Integer page, @Valid Integer pageSize) throws BrAPIServerException {

		AsyncMetadata metaData = generateAsynchMetaDataTemplate(page, pageSize);
		AlleleFormatParams params = markerProfileService.buildFormatParams(expandHomozygotes, sepPhased, sepUnphased,
				unknownString);

		List<List<String>> data = markerProfileService.getAlleleMatrix(markerprofileDbId, markerDbId, matrixDbId,
				params, metaData);

		AlleleMatrixValues result = new AlleleMatrixValues();
		result.setData(data);
		AlleleMatrixValuesResponse1 response = new AlleleMatrixValuesResponse1();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<AlleleMatrixValuesResponse1>(response, HttpStatus.OK);
	}

	// Deprecated
	@CrossOrigin
	@Override
	public ResponseEntity<AlleleMatrixValuesResponse1> allelematrixSearchPost(@Valid AlleleMatrixSearchRequest request)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		AlleleFormatParams params = markerProfileService.buildFormatParams(request.isExpandHomozygotes(),
				request.getSepPhased(), request.getSepUnphased(), request.getUnknownString());

		List<List<String>> data = markerProfileService.getAlleleMatrix(request.getMarkerprofileDbId(),
				request.getMarkerDbId(), request.getMatrixDbId(), params, metaData);

		AlleleMatrixValues result = new AlleleMatrixValues();
		result.setData(data);
		AlleleMatrixValuesResponse1 response = new AlleleMatrixValuesResponse1();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<AlleleMatrixValuesResponse1>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkerProfileDescriptionsResponse> markerprofilesGet(@Valid String germplasmDbId,
			@Valid String studyDbId, @Valid String sampleDbId, @Valid String extractDbId, @Valid Integer page,
			@Valid Integer pageSize, String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<MarkerProfileDescription> data = markerProfileService.getMarkerProfileSummeries(germplasmDbId, studyDbId,
				sampleDbId, extractDbId, metaData);

		MarkerProfileDescriptionsResponseResult result = new MarkerProfileDescriptionsResponseResult();
		result.setData(data);
		MarkerProfileDescriptionsResponse response = new MarkerProfileDescriptionsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkerProfileDescriptionsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkerProfilesResponse> markerprofilesMarkerProfileDbIdGet(
			@PathVariable("markerProfileDbId") String markerProfileDbId, @Valid Boolean expandHomozygotes,
			@Valid String unknownString, @Valid String sepPhased, @Valid String sepUnphased, @Valid Integer page,
			@Valid Integer pageSize, String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		AlleleFormatParams params = markerProfileService.buildFormatParams(expandHomozygotes, sepPhased, sepUnphased,
				unknownString);
		MarkerProfile result = markerProfileService.getMarkerProfileDetails(markerProfileDbId, params, metaData);

		MarkerProfilesResponse response = new MarkerProfilesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkerProfilesResponse>(response, HttpStatus.OK);
	}
}
