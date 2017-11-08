package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.CropRepository;
import org.springframework.stereotype.Service;

@Service
public class CropService {
	
	private CropRepository cropRepository;
	
	public CropService(CropRepository cropRepository) {
		this.cropRepository = cropRepository;
	}

	public List<String> getCrops(MetaData metaData) {
		
		List<String> crops = cropRepository
				.findAll(PagingUtility.getPageRequest(metaData))
				.stream()
				.map(c -> {return c.getCropName();})
				.collect(Collectors.toList());
		
		metaData.getPagination().setTotalCount((int) cropRepository.count());
		PagingUtility.calculateMetaData(metaData);
		return crops;
	}

}
