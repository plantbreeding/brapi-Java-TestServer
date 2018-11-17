package org.brapi.test.BrAPITestServer.controller;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.SearchApi;
import io.swagger.model.GermplasmResponse;
import io.swagger.model.GermplasmSearchRequest;
import io.swagger.model.ImagesResponse;
import io.swagger.model.ImagesSearchRequest;
import io.swagger.model.MarkersResponse;
import io.swagger.model.MarkersSearchRequest;
import io.swagger.model.ObservationUnitsResponse1;
import io.swagger.model.ObservationUnitsTableResponse1;
import io.swagger.model.ObservationVariableSearchRequest;
import io.swagger.model.ObservationVariablesResponse;
import io.swagger.model.PhenotypesSearchRequest;
import io.swagger.model.ProgramsResponse;
import io.swagger.model.ProgramsSearchRequest;
import io.swagger.model.SampleSearchRequest;
import io.swagger.model.SamplesResponse;
import io.swagger.model.StudiesResponse;
import io.swagger.model.StudySearchRequest;
import io.swagger.model.SuccessfulSearchResponse;
import io.swagger.model.WSMIMEDataTypes;

@RestController
public class SearchController extends BrAPIController implements SearchApi {

	@Autowired
	public SearchController() {
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchGermplasmPost(@Valid GermplasmSearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<GermplasmResponse> searchGermplasmSearchResultsDbIdGet(@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchImagesPost(@Valid ImagesSearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ImagesResponse> searchImagesSearchResultsDbIdGet(@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchMarkersPost(@Valid MarkersSearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<MarkersResponse> searchMarkersSearchResultsDbIdGet(@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchObservationtablesPost(@Valid PhenotypesSearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ObservationUnitsTableResponse1> searchObservationtablesSearchResultsDbIdGet(
			WSMIMEDataTypes accept, String searchResultsDbId, String authorization, @Valid Integer page,
			@Valid Integer pageSize) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchObservationunitsPost(@Valid PhenotypesSearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ObservationUnitsResponse1> searchObservationunitsSearchResultsDbIdGet(
			String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchProgramsPost(@Valid ProgramsSearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ProgramsResponse> searchProgramsSearchResultsDbIdGet(@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchSamplesPost(@Valid SampleSearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SamplesResponse> searchSamplesSearchResultsDbIdGet(@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchStudiesPost(@Valid StudySearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StudiesResponse> searchStudiesSearchResultsDbIdGet(@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchVariablesPost(@Valid ObservationVariableSearchRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ObservationVariablesResponse> searchVariablesSearchResultsDbIdGet(@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

}
