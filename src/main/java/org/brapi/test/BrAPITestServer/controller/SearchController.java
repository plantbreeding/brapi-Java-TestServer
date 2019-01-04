package org.brapi.test.BrAPITestServer.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.GermplasmService;
import org.brapi.test.BrAPITestServer.service.ImageService;
import org.brapi.test.BrAPITestServer.service.MarkersService;
import org.brapi.test.BrAPITestServer.service.ObservationVariableService;
import org.brapi.test.BrAPITestServer.service.PhenotypeService;
import org.brapi.test.BrAPITestServer.service.ProgramService;
import org.brapi.test.BrAPITestServer.service.SampleService;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.SearchApi;
import io.swagger.model.Germplasm;
import io.swagger.model.GermplasmResponse;
import io.swagger.model.GermplasmResponseResult;
import io.swagger.model.GermplasmSearchRequest;
import io.swagger.model.Image;
import io.swagger.model.ImagesResponse;
import io.swagger.model.ImagesResponseResult;
import io.swagger.model.ImagesSearchRequest;
import io.swagger.model.Marker;
import io.swagger.model.MarkersResponse;
import io.swagger.model.MarkersResponseResult;
import io.swagger.model.MarkersSearchRequest;
import io.swagger.model.Metadata;
import io.swagger.model.ObservationUnit;
import io.swagger.model.ObservationUnitsResponse1;
import io.swagger.model.ObservationUnitsResponse1Result;
import io.swagger.model.ObservationUnitsTableResponse;
import io.swagger.model.ObservationUnitsTableResponse1;
import io.swagger.model.ObservationVariable;
import io.swagger.model.ObservationVariableSearchRequest;
import io.swagger.model.ObservationVariablesResponse;
import io.swagger.model.ObservationVariablesResponseResult;
import io.swagger.model.PhenotypesSearchRequest;
import io.swagger.model.Program;
import io.swagger.model.ProgramsResponse;
import io.swagger.model.ProgramsResponseResult;
import io.swagger.model.ProgramsSearchRequest;
import io.swagger.model.Sample;
import io.swagger.model.SampleSearchRequest;
import io.swagger.model.SamplesResponse;
import io.swagger.model.SamplesResponseResult;
import io.swagger.model.StudiesResponse;
import io.swagger.model.StudiesResponseResult;
import io.swagger.model.StudySearchRequest;
import io.swagger.model.StudySummary;
import io.swagger.model.SuccessfulSearchResponse;
import io.swagger.model.SuccessfulSearchResponseResult;
import io.swagger.model.WSMIMEDataTypes;

@RestController
public class SearchController extends BrAPIController implements SearchApi {

	private SearchService searchService;
	private GermplasmService germplasmService;
	private ImageService imageService;
	private MarkersService markerService;
	private ProgramService programService;
	private SampleService sampleService;
	private StudyService studyService;
	private ObservationVariableService observationVariableService;
	private PhenotypeService phenotypeService;

	@Autowired
	public SearchController(SearchService searchService, GermplasmService germplasmService, ImageService imageService,
			MarkersService markerService, PhenotypeService phenotypeService, ProgramService programService,
			SampleService sampleService, StudyService studyService,
			ObservationVariableService observationVariableService) {
		this.searchService = searchService;
		this.germplasmService = germplasmService;
		this.imageService = imageService;
		this.markerService = markerService;
		this.phenotypeService = phenotypeService;
		this.programService = programService;
		this.sampleService = sampleService;
		this.studyService = studyService;
		this.observationVariableService = observationVariableService;
	}

	private ResponseEntity<SuccessfulSearchResponse> generateSearchRequestResponse(String searchResultDbId) {
		SuccessfulSearchResponseResult result = new SuccessfulSearchResponseResult();
		result.setSearchResultDbId(searchResultDbId);
		SuccessfulSearchResponse response = new SuccessfulSearchResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<SuccessfulSearchResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchGermplasmPost(@Valid @RequestBody GermplasmSearchRequest body,
			String authorization) throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.GERMPLASM);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmResponse> searchGermplasmSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		GermplasmSearchRequest request = searchService.findById(searchResultsDbId).getParameters(GermplasmSearchRequest.class);
		Metadata metadata = generateMetaDataTemplateForSearch(request.getPage(), page, request.getPageSize(), pageSize);
		
		List<Germplasm> data = germplasmService.search(request, metadata);

		GermplasmResponseResult result = new GermplasmResponseResult();
		result.setData(data);
		GermplasmResponse response = new GermplasmResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<GermplasmResponse>(response, HttpStatus.OK);

	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchImagesPost(@Valid @RequestBody ImagesSearchRequest body,
			String authorization) throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.IMAGES);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ImagesResponse> searchImagesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		ImagesSearchRequest request = searchService.findById(searchResultsDbId).getParameters(ImagesSearchRequest.class);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);

		List<Image> data = imageService.search(request, metadata);

		ImagesResponseResult result = new ImagesResponseResult();
		result.setData(data);
		ImagesResponse response = new ImagesResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<ImagesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchMarkersPost(@Valid @RequestBody MarkersSearchRequest body,
			String authorization) throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.MARKERS);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkersResponse> searchMarkersSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		MarkersSearchRequest request = searchService.findById(searchResultsDbId).getParameters(MarkersSearchRequest.class);
		Metadata metadata = generateMetaDataTemplateForSearch(request.getPage(), page, request.getPageSize(), pageSize);

		List<Marker> data = markerService.search(request, metadata);

		MarkersResponseResult result = new MarkersResponseResult();
		result.setData(data);
		MarkersResponse response = new MarkersResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchObservationtablesPost(
			@Valid @RequestBody PhenotypesSearchRequest body, String authorization) throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.OBSERVATION_TABLES);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<Object> searchObservationtablesSearchResultsDbIdGet(WSMIMEDataTypes accept,
			@PathVariable("searchResultsDbId") String searchResultsDbId, String authorization, @Valid Integer page, @Valid Integer pageSize)
			throws BrAPIServerException {
		
		PhenotypesSearchRequest request = searchService.findById(searchResultsDbId).getParameters(PhenotypesSearchRequest.class);
		Metadata metadata = generateMetaDataTemplateForSearch(request.getPage(), page, request.getPageSize(), pageSize);

		if (accept == WSMIMEDataTypes.TEXT_CSV) {
			String response = phenotypeService.getPhenotypesCsv(request, metadata);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else if (accept == WSMIMEDataTypes.TEXT_TSV) {
			String response = phenotypeService.getPhenotypesTsv(request, metadata);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}
		
		ObservationUnitsTableResponse result = phenotypeService.getPhenotypesTable(request, metadata);
		ObservationUnitsTableResponse1 response = new ObservationUnitsTableResponse1().metadata(metadata).result(result);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchObservationunitsPost(
			@Valid @RequestBody PhenotypesSearchRequest body, String authorization) throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.OBSERVATION_UNITS);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitsResponse1> searchObservationunitsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {
		PhenotypesSearchRequest request = searchService.findById(searchResultsDbId).getParameters(PhenotypesSearchRequest.class);
		Metadata metadata = generateMetaDataTemplateForSearch(request.getPage(), page, request.getPageSize(), pageSize);

		List<ObservationUnit> data = phenotypeService.getPhenotypes(request, metadata)
				.stream()
				.map(phenotypeService::convertUnit)
				.collect(Collectors.toList());

		ObservationUnitsResponse1Result result = new ObservationUnitsResponse1Result();
		result.setData(data);
		ObservationUnitsResponse1 response = new ObservationUnitsResponse1();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<ObservationUnitsResponse1>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchProgramsPost(@Valid @RequestBody ProgramsSearchRequest body,
			String authorization) throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.PROGRAMS);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramsResponse> searchProgramsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		ProgramsSearchRequest request = searchService.findById(searchResultsDbId).getParameters(ProgramsSearchRequest.class);
		Metadata metadata = generateMetaDataTemplateForSearch(request.getPage(), page, request.getPageSize(), pageSize);

		List<Program> data = programService.search(request, metadata);

		ProgramsResponseResult result = new ProgramsResponseResult();
		result.setData(data);
		ProgramsResponse response = new ProgramsResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<ProgramsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchSamplesPost(@Valid @RequestBody SampleSearchRequest body,
			String authorization) throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.SAMPLES);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SamplesResponse> searchSamplesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		SampleSearchRequest request = searchService.findById(searchResultsDbId).getParameters(SampleSearchRequest.class);
		Metadata metadata = generateMetaDataTemplateForSearch(request.getPage(), page, request.getPageSize(), pageSize);

		List<Sample> data = sampleService.searchSamples(request, metadata);

		SamplesResponseResult result = new SamplesResponseResult();
		result.setData(data);
		SamplesResponse response = new SamplesResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<SamplesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchStudiesPost(@Valid @RequestBody StudySearchRequest body,
			String authorization) throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.STUDIES);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<StudiesResponse> searchStudiesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		StudySearchRequest request = searchService.findById(searchResultsDbId).getParameters(StudySearchRequest.class);
		Metadata metadata = generateMetaDataTemplateForSearch(request.getPage(), page, request.getPageSize(), pageSize);

		List<StudySummary> data = studyService.searchStudies(request, metadata);

		StudiesResponseResult result = new StudiesResponseResult();
		result.setData(data);
		StudiesResponse response = new StudiesResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<StudiesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SuccessfulSearchResponse> searchVariablesPost(
			@Valid @RequestBody ObservationVariableSearchRequest body, String authorization)
			throws BrAPIServerException {
		String searchResultDbId = searchService.saveSearchRequest(body, SearchRequestTypes.VARIABLES);
		return generateSearchRequestResponse(searchResultDbId);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariablesResponse> searchVariablesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		
		ObservationVariableSearchRequest request = searchService.findById(searchResultsDbId).getParameters(ObservationVariableSearchRequest.class);
		Metadata metadata = generateMetaDataTemplateForSearch(request.getPage(), page, request.getPageSize(), pageSize);
		
		List<ObservationVariable> data = observationVariableService.search(request, metadata);

		ObservationVariablesResponseResult result = new ObservationVariablesResponseResult();
		result.setData(data);
		ObservationVariablesResponse response = new ObservationVariablesResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<ObservationVariablesResponse>(response, HttpStatus.OK);
	}

}
