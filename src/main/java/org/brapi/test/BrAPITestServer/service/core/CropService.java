package org.brapi.test.BrAPITestServer.service.core;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.repository.core.CropRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;

@Service
public class CropService {

	private CropRepository cropRepository;

	public CropService(CropRepository cropRepository) {
		this.cropRepository = cropRepository;
	}

	public List<String> getCrops(Metadata metaData) {

		Page<CropEntity> cropsPage = cropRepository.findAll(PagingUtility.getPageRequest(metaData));
		List<String> crops = cropsPage.stream().map(c -> {
			return c.getCropName();
		}).collect(Collectors.toList());

		PagingUtility.calculateMetaData(metaData, cropsPage);
		return crops;
	}

	public CropEntity findCropEntity(String commonCropName) throws BrAPIServerException {
		CropEntity entity = null;
		if (commonCropName != null) {
			List<CropEntity> cropsPage = cropRepository.findByCropName(commonCropName, PageRequest.of(0, 1))
					.getContent();

			if (cropsPage.size() >= 1) {
				entity = cropsPage.get(0);
			}
		}
		return entity;
	}

	public CropEntity getCropEntity(String commonCropName) throws BrAPIServerException {
		CropEntity entity = null;
		if (commonCropName != null) {
			List<CropEntity> cropsPage = cropRepository.findByCropName(commonCropName, PageRequest.of(0, 1))
					.getContent();

			if (cropsPage.size() == 1) {
				entity = cropsPage.get(0);
			} else {
				throw new BrAPIServerDbIdNotFoundException("crop name", commonCropName, "crop name", HttpStatus.NOT_FOUND);
			}
		}
		return entity;
	}

	public CropEntity saveCropEntity(String commonCropName)  throws BrAPIServerException {
		CropEntity entity = null;
		if (commonCropName != null) {
			entity = new CropEntity();
			entity.setCropName(commonCropName);
			entity = cropRepository.saveAndFlush(entity);
		}
		return entity;
	}

}
