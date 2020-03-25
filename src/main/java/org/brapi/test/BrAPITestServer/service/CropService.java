package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.CropEntity;
import org.brapi.test.BrAPITestServer.repository.CropRepository;
import org.springframework.data.domain.Page;
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

}
