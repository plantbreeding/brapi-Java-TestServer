package org.brapi.test.BrAPITestServer.service.geno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.math.NumberUtils;
import org.brapi.test.BrAPITestServer.model.entity.geno.CallEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.CallSetEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.VariantEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.IndexPagination;
import io.swagger.model.geno.AlleleMatrix;
import io.swagger.model.geno.AlleleMatrixDataMatrices;
import io.swagger.model.geno.AlleleMatrixPagination;
import io.swagger.model.geno.AlleleMatrixPagination.DimensionEnum;
import io.swagger.model.geno.AlleleMatrixSearchRequest;
import io.swagger.model.geno.AlleleMatrixSearchRequestPagination;
import io.swagger.model.geno.Call;
import io.swagger.model.geno.CallSetsSearchRequest;
import io.swagger.model.geno.CallsListResponseResult;
import io.swagger.model.geno.CallsSearchRequest;
import io.swagger.model.geno.DataTypePrimitives;
import io.swagger.model.geno.VariantsSearchRequest;

@Service
public class AlleleMatrixService {

	private final VariantService variantService;
	private final CallSetService callSetService;
	private final CallService callService;

	public AlleleMatrixService(VariantService variantService, CallSetService callSetService, CallService callService) {
		this.variantService = variantService;
		this.callSetService = callSetService;
		this.callService = callService;
	}

	public AlleleMatrix findAlleleMatrix(Integer dimensionVariantPage, Integer dimensionVariantPageSize,
			Integer dimensionAlleleMatrixSetPage, Integer dimensionAlleleMatrixSetPageSize, Boolean preview,
			String dataMatrixNames, String dataMatrixAbbreviations, String positionRange, String germplasmDbId,
			String germplasmName, String germplasmPUI, String callSetDbId, String variantDbId, String variantSetDbId,
			Boolean expandHomozygotes, String unknownString, String sepPhased, String sepUnphased, Metadata metadata) {

		AlleleMatrixSearchRequestPagination variantPage = new AlleleMatrixSearchRequestPagination()
				.dimension(DimensionEnum.VARIANTS);
		if (dimensionVariantPage != null) {
			variantPage.setPage(dimensionVariantPage);
		}
		if (dimensionVariantPageSize != null) {
			variantPage.setPageSize(dimensionVariantPageSize);
		}
		AlleleMatrixSearchRequestPagination callSetPage = new AlleleMatrixSearchRequestPagination()
				.dimension(DimensionEnum.CALLSETS);
		if (dimensionAlleleMatrixSetPage != null) {
			callSetPage.setPage(dimensionAlleleMatrixSetPage);
		}
		if (dimensionAlleleMatrixSetPageSize != null) {
			callSetPage.setPageSize(dimensionAlleleMatrixSetPageSize);
		}

		AlleleMatrixSearchRequest request = new AlleleMatrixSearchRequest();

		request.addPaginationItem(variantPage);
		request.addPaginationItem(callSetPage);
		if (preview != null) {
			request.setPreview(preview);
		}
		if (dataMatrixNames != null) {
			request.addDataMatrixNamesItem(dataMatrixNames);
		}
		if (dataMatrixAbbreviations != null) {
			request.addDataMatrixAbbreviationsItem(dataMatrixAbbreviations);
		}
		if (positionRange != null) {
			request.addPositionRangesItem(positionRange);
		}
		if (germplasmDbId != null) {
			request.addGermplasmDbIdsItem(germplasmDbId);
		}
		if (germplasmName != null) {
			request.addGermplasmNamesItem(germplasmName);
		}
		if (germplasmPUI != null) {
			request.addGermplasmPUIsItem(germplasmPUI);
		}
		if (callSetDbId != null) {
			request.addCallSetDbIdsItem(callSetDbId);
		}
		if (variantDbId != null) {
			request.addVariantDbIdsItem(variantDbId);
		}
		if (variantSetDbId != null) {
			request.addVariantSetDbIdsItem(variantSetDbId);
		}
		if (expandHomozygotes != null) {
			request.setExpandHomozygotes(expandHomozygotes);
		}
		if (unknownString != null) {
			request.setUnknownString(unknownString);
		}
		if (sepPhased != null) {
			request.setSepPhased(sepPhased);
		}
		if (sepUnphased != null) {
			request.setSepUnphased(sepUnphased);
		}
		return findAlleleMatrix(request, metadata);
	}

	public AlleleMatrix findAlleleMatrix(AlleleMatrixSearchRequest request, Metadata metadata) {
		AlleleMatrix matrixResponse = new AlleleMatrix();
		AlleleMatrixPagination variantPage = new AlleleMatrixPagination().dimension(DimensionEnum.VARIANTS);
		AlleleMatrixPagination callSetPage = new AlleleMatrixPagination().dimension(DimensionEnum.CALLSETS);

		List<CallSetEntity> callSets = findCallSets(request, callSetPage);
		matrixResponse.setCallSetDbIds(callSets.stream().map(callSet -> callSet.getId()).collect(Collectors.toList()));

		List<VariantEntity> variants = findVariants(request, variantPage);
		matrixResponse.setVariantDbIds(variants.stream().map(variant -> variant.getId()).collect(Collectors.toList()));

		matrixResponse.setVariantSetDbIds(variants.stream().unordered().map(variant -> variant.getVariantSet().getId())
				.distinct().collect(Collectors.toList()));

		matrixResponse
				.setExpandHomozygotes(request.isExpandHomozygotes() == null ? true : request.isExpandHomozygotes());
		matrixResponse.setSepPhased(request.getSepPhased() == null ? CallService.SEP_PHASED_DEFAULT : request.getSepPhased());
		matrixResponse.setSepUnphased(request.getSepUnphased() == null ? CallService.SEP_UNPHASED_DEFAULT : request.getSepUnphased());
		matrixResponse.setUnknownString(request.getUnknownString() == null ? CallService.UNKNOWN_STRING_DEFAULT : request.getUnknownString());
		matrixResponse.addPaginationItem(callSetPage);
		matrixResponse.addPaginationItem(variantPage);

		if (!request.isPreview()) {
			Map<String, Integer> callSetIndex = new HashMap<>();
			Map<String, Integer> variantIndex = new HashMap<>();
			prepareMatrices(request, matrixResponse, callSetIndex, variantIndex);

			List<CallEntity> calls = findCalls(matrixResponse, request);
			for (CallEntity call : calls) {
				int callSetPos = callSetIndex.get(call.getCallSet().getId());
				int variantPos = variantIndex.get(call.getVariant().getId());
				for (AlleleMatrixDataMatrices matrix : matrixResponse.getDataMatrices()) {
					String value = "";
					if (matrix.getDataMatrixAbbreviation() == "GT") {
						value = call.getGenotype() == null ? CallService.UNKNOWN_STRING_DEFAULT : call.getGenotype();
					} else if (matrix.getDataMatrixAbbreviation() == "RD") {
						value = call.getReadDepth() == null ? CallService.UNKNOWN_STRING_DEFAULT : call.getReadDepth().toString();
					} else if (matrix.getDataMatrixAbbreviation() == "GL") {
						value = call.getGenotypeLikelihood() == null ? CallService.UNKNOWN_STRING_DEFAULT : call.getGenotypeLikelihood().toString();
					}

					matrix.getDataMatrix().get(variantPos).set(callSetPos, value);
				}
			}
		}
		return matrixResponse;
	}

	private void prepareMatrices(AlleleMatrixSearchRequest request, AlleleMatrix matrixResponse,
			Map<String, Integer> callSetIndex, Map<String, Integer> variantIndex) {
		// produces empty matrices for GT, RD, and GL as applicable
		boolean showGT = true;
		boolean showRD = true;
		boolean showGL = true;

		if (request.getDataMatrixAbbreviations() != null) {
			showGT = request.getDataMatrixAbbreviations().contains("GT");
			showRD = request.getDataMatrixAbbreviations().contains("RD");
			showGL = request.getDataMatrixAbbreviations().contains("GL");
		}
		if (request.getDataMatrixNames() != null) {
			showGT = request.getDataMatrixNames().contains("Genotype");
			showRD = request.getDataMatrixNames().contains("Read Depth");
			showGL = request.getDataMatrixNames().contains("Genotype Likelihood");
		}

		if (showGT) {
			AlleleMatrixDataMatrices gt = new AlleleMatrixDataMatrices();
			gt.setDataMatrixAbbreviation("GT");
			gt.setDataMatrixName("Genotype");
			gt.setDataType(DataTypePrimitives.STRING);
			matrixResponse.addDataMatricesItem(gt);
		}

		if (showRD) {
			AlleleMatrixDataMatrices rd = new AlleleMatrixDataMatrices();
			rd.setDataMatrixAbbreviation("RD");
			rd.setDataMatrixName("Read Depth");
			rd.setDataType(DataTypePrimitives.INTEGER);
			matrixResponse.addDataMatricesItem(rd);
		}

		if (showGL) {
			AlleleMatrixDataMatrices gl = new AlleleMatrixDataMatrices();
			gl.setDataMatrixAbbreviation("GL");
			gl.setDataMatrixName("Genotype Likelihood");
			gl.setDataType(DataTypePrimitives.FLOAT);
			matrixResponse.addDataMatricesItem(gl);
		}

		for (AlleleMatrixDataMatrices matrix : matrixResponse.getDataMatrices()) {
			int variantCount = 0;
			for (String variantDbId : matrixResponse.getVariantDbIds()) {
				int callSetCount = 0;

				List<String> row = new ArrayList<>();
				for (String callSetDbId : matrixResponse.getCallSetDbIds()) {
					row.add(CallService.UNKNOWN_STRING_DEFAULT);

					callSetIndex.put(callSetDbId, callSetCount);
					callSetCount++;
				}
				matrix.addDataMatrixItem(row);

				variantIndex.put(variantDbId, variantCount);
				variantCount++;
			}
		}
	}

	private List<CallEntity> findCalls(AlleleMatrix matrixResponse, AlleleMatrixSearchRequest request) {
		CallsSearchRequest callSearchReq = new CallsSearchRequest();
		callSearchReq.setCallSetDbIds(matrixResponse.getCallSetDbIds());
		callSearchReq.setVariantDbIds(matrixResponse.getVariantDbIds());
		callSearchReq.setExpandHomozygotes(request.isExpandHomozygotes());
		callSearchReq.setSepPhased(request.getSepPhased());
		callSearchReq.setSepUnphased(request.getSepUnphased());
		callSearchReq.setUnknownString(request.getUnknownString());
		

		int totalPageSize = 1;
		for(AlleleMatrixSearchRequestPagination pagination : request.getPagination()) {
			totalPageSize = totalPageSize * pagination.getPageSize();
		}
		Metadata metadata = new Metadata();
		metadata.setPagination(new IndexPagination());
		metadata.getPagination().setPageSize(totalPageSize);
		return callService.findCallEntities(callSearchReq, metadata);
	}

	private List<VariantEntity> findVariants(AlleleMatrixSearchRequest request, AlleleMatrixPagination page) {
		VariantsSearchRequest variantSearchReq = new VariantsSearchRequest();
		variantSearchReq.setCallSetDbIds(request.getCallSetDbIds());
		variantSearchReq.setVariantDbIds(request.getVariantDbIds());
		variantSearchReq.setVariantSetDbIds(request.getVariantSetDbIds());
		if (request.getPositionRanges() != null && request.getPositionRanges().size() > 0) {
			String[] positionSplit = request.getPositionRanges().get(0).split(":|-");

			variantSearchReq.setReferenceDbIds(Arrays.asList(positionSplit[0]));
			variantSearchReq.setStart(NumberUtils.toInt(positionSplit[1]));
			variantSearchReq.setEnd(NumberUtils.toInt(positionSplit[2]));
		}

		Metadata metadata = new Metadata();
		metadata.setPagination(page);
		if (request.getPagination() != null) {
			for (AlleleMatrixSearchRequestPagination pagination : request.getPagination()) {
				if (pagination.getDimension().equals(DimensionEnum.VARIANTS)) {
					metadata.getPagination().setCurrentPage(pagination.getPage());
					metadata.getPagination().setPageSize(pagination.getPageSize());
					break;
				}
			}
		}
		List<VariantEntity> variants = variantService.findVariantEntities(variantSearchReq, metadata);
		return variants;
	}

	private List<CallSetEntity> findCallSets(AlleleMatrixSearchRequest request, AlleleMatrixPagination page) {
		CallSetsSearchRequest callSetSearchReq = new CallSetsSearchRequest();
		callSetSearchReq.setCallSetDbIds(request.getCallSetDbIds());
		callSetSearchReq.setGermplasmDbIds(request.getGermplasmDbIds());
		callSetSearchReq.setGermplasmNames(request.getGermplasmNames());
		callSetSearchReq.setSampleDbIds(request.getSampleDbIds());
		callSetSearchReq.setVariantSetDbIds(request.getVariantSetDbIds());

		Metadata metadata = new Metadata();
		metadata.setPagination(page);
		if (request.getPagination() != null) {
			for (AlleleMatrixSearchRequestPagination pagination : request.getPagination()) {
				if (pagination.getDimension().equals(DimensionEnum.CALLSETS)) {
					metadata.getPagination().setCurrentPage(pagination.getPage());
					metadata.getPagination().setPageSize(pagination.getPageSize());
					break;
				}
			}
		}
		List<CallSetEntity> callSets = callSetService.findCallSetEntities(callSetSearchReq, metadata);
		return callSets;
	}

}
