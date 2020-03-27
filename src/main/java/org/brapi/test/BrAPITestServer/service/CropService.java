package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.repository.core.CropRepository;
import org.brapi.test.BrAPITestServer.utility.PagingUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.common.Metadata;

@Service
public class CropService {
	
	private CropRepository cropRepository;
	
	public CropService(CropRepository cropRepository) {
		this.cropRepository = cropRepository;
	}

	public List<String> getCrops(Metadata metaData) {
		
		Page<CropEntity> cropsPage = cropRepository.findAll(PagingUtility.getPageRequest(metaData));
		List<String> crops = cropsPage.stream()
				.map(c -> {return c.getCropName();})
				.collect(Collectors.toList());
		
		PagingUtility.calculateMetaData(metaData, cropsPage);
		return crops;
	}

	public CropEntity getCropEntity(String commonCropName) throws BrAPIServerException {
		List<CropEntity> cropsPage = cropRepository.findByCropName(commonCropName, PageRequest.of(0, 1)).getContent();
		CropEntity entity = null;
		if (cropsPage.size() == 1) {
			entity = cropsPage.get(0);
		}else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "crop name not found!");
		}
		return entity;
	}

}
