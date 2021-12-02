package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.ImageEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.repository.ImageRepository;
import org.brapi.test.BrAPITestServer.repository.ObservationUnitRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.GeoJSON;
import io.swagger.model.GeoJSON.TypeEnum;
import io.swagger.model.Image;
import io.swagger.model.ImagesSearchRequest;
import io.swagger.model.Metadata;
import io.swagger.model.NewImageRequest;

@Service
public class ImageService {

	private ImageRepository imageRepository;
	private ObservationUnitRepository observationUnitRepository;
	private SearchService searchService;

	@Value("${app.baseurl}")
	private String baseUrlProperty;

	public ImageService(ImageRepository imageRepository, ObservationUnitRepository observationUnitRepository,
			SearchService searchService) {
		this.imageRepository = imageRepository;
		this.observationUnitRepository = observationUnitRepository;
		this.searchService = searchService;
	}

	public Image getImage(String imageDbId) {
		Image image = null;

		if (imageDbId != null && !imageDbId.isEmpty()) {
			Optional<ImageEntity> imageOption = imageRepository.findById(imageDbId);
			if (imageOption.isPresent()) {
				image = convertFromEntiy(imageOption.get());
			}
		}

		return image;
	}

	public List<Image> findImages(String imageDbId, String imageName, String observationUnitDbId,
			String observationDbId, String descriptiveOntologyTerm, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		ImagesSearchRequest request = new ImagesSearchRequest();
		if (observationUnitDbId != null)
			request.addObservationUnitDbIdsItem(observationUnitDbId);
		if (observationDbId != null)
			request.addObservationDbIdsItem(observationDbId);
		if (descriptiveOntologyTerm != null)
			request.addDescriptiveOntologyTermsItem(descriptiveOntologyTerm);

		Page<ImageEntity> imagePage = imageRepository.findBySearch(request, pageReq);
		PagingUtility.calculateMetaData(metaData, imagePage);

		List<Image> images = imagePage.map(this::convertFromEntiy).getContent();

		return images;
	}

	public byte[] getImageData(String imageDbId) {
		byte[] bytes = null;
		if (imageDbId != null && !imageDbId.isEmpty()) {
			Optional<ImageEntity> imageOption = imageRepository.findById(imageDbId);
			if (imageOption.isPresent()) {
				bytes = imageOption.get().getImageData();
			}
		}
		return bytes;
	}

	public Image saveImageMetaData(NewImageRequest imageMetadata) {
		ImageEntity newEntity = new ImageEntity();
		updateEntity(newEntity, imageMetadata);

		ImageEntity saved = imageRepository.save(newEntity);
		Image result = convertFromEntiy(saved);

		return result;
	}

	public Image saveImageData(String imageDbId, byte[] imageData) throws BrAPIServerException {
		Image result = null;
		if (imageDbId != null && !imageDbId.isEmpty()) {
			Optional<ImageEntity> imageOption = imageRepository.findById(imageDbId);
			if (imageOption.isPresent()) {
				ImageEntity newEntity = imageOption.get();
				newEntity.setImageData(imageData);
				newEntity.setImageURL(constructURL(newEntity));

				ImageEntity saved = imageRepository.save(newEntity);

				result = convertFromEntiy(saved);
			} else {
				throw new BrAPIServerException(HttpStatus.NOT_FOUND, "ImageDbId not found");
			}

		}
		return result;
	}

	private String constructURL(ImageEntity newEntity) {
		String name = "image";
		if (newEntity.getImageFileName() != null && !newEntity.getImageFileName().isEmpty()) {
			name = newEntity.getImageFileName().replaceAll(" ", "_");
		} else {
			if (newEntity.getName() != null && !newEntity.getName().isEmpty()) {
				name = newEntity.getName().replaceAll(" ", "_");
			}
			if (newEntity.getImageType() != null && !newEntity.getImageType().isEmpty()) {
				name = name + "." + newEntity.getImageType();
			}
		}
		return baseUrlProperty + "/images/" + newEntity.getId() + "/" + name;
	}

	private void updateEntity(ImageEntity entity, NewImageRequest image) {
		if (image.getAdditionalInfo() != null)
			entity.setAdditionalInfo(image.getAdditionalInfo());

		if (image.getObservationUnitDbId() != null && !image.getObservationUnitDbId().isEmpty()) {
			Optional<ObservationUnitEntity> unitOption = this.observationUnitRepository
					.findById(image.getObservationUnitDbId());
			if (unitOption.isPresent()) {
				entity.setObservationUnit(unitOption.get());
			}
		}

		if (image.getCopyright() != null)
			entity.setCopyright(image.getCopyright());
		if (image.getDescription() != null)
			entity.setDescription(image.getDescription());
		if (image.getDescriptiveOntologyTerms() != null)
			entity.setDescriptiveOntologyTerms(arrayToString(image.getDescriptiveOntologyTerms()));
		if (image.getImageFileName() != null)
			entity.setImageFileName(image.getImageFileName());
		if (image.getImageFileSize() != null)
			entity.setImageFileSize(image.getImageFileSize());
		if (image.getImageHeight() != null)
			entity.setImageHeight(image.getImageHeight());
		if (image.getImageName() != null)
			entity.setName(image.getImageName());
		if (image.getMimeType() != null)
			entity.setImageType(image.getMimeType());
		if (image.getImageWidth() != null)
			entity.setImageWidth(image.getImageWidth());
		if (image.getObservationDbIds() != null)
			entity.setObservationDbIds(arrayToString(image.getObservationDbIds()));
		if (image.getImageTimeStamp() != null)
			entity.setTimeStamp(DateUtility.toDate(image.getImageTimeStamp()));
		entity.setImageURL("");

		if (image.getImageLocation() != null && image.getImageLocation().getGeometry() != null
				&& image.getImageLocation().getGeometry() instanceof Map) {
			try {
				Map<String, Object> geo = (Map<String, Object>) image.getImageLocation().getGeometry();
				ArrayList<Double> coords = (ArrayList<Double>) geo.get("coordinates");
				entity.setLatitude(coords.get(0).floatValue());
				entity.setLongitude(coords.get(1).floatValue());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private Image convertFromEntiy(ImageEntity entity) {
		Image img = new Image();
		img.setAdditionalInfo(entity.getAdditionalInfo());
		img.setCopyright(entity.getCopyright());
		img.setDescription(entity.getDescription());
		img.setImageDbId(entity.getId());
		img.setImageFileName(entity.getImageFileName());
		img.setImageFileSize(entity.getImageFileSize());
		img.setImageHeight(entity.getImageHeight());
		img.setImageName(entity.getName());
		img.setMimeType(entity.getImageType());
		img.setImageURL(entity.getImageURL());
		img.setImageWidth(entity.getImageWidth());
		img.setImageTimeStamp(DateUtility.toOffsetDateTime(entity.getTimeStamp()));

		if (entity.getLatitude() != null && entity.getLongitude() != null) {
			img.setImageLocation(new GeoJSON().type(TypeEnum.FEATURE)
					.geometry(new Geometry(entity.getLatitude(), entity.getLongitude())));
		} else {
			img.setImageLocation(new GeoJSON().type(TypeEnum.FEATURE).geometry(new Geometry(0F, 0F)));
		}

		if (entity.getDescriptiveOntologyTerms() != null && !entity.getDescriptiveOntologyTerms().isEmpty()) {
			img.setDescriptiveOntologyTerms(Arrays.asList(entity.getDescriptiveOntologyTerms().split(",")));
		}

		if (entity.getObservationDbIds() != null && !entity.getObservationDbIds().isEmpty()) {
			img.setObservationDbIds(Arrays.asList(entity.getObservationDbIds().split(",")));
		}

		if (entity.getObservationUnit() != null) {
			img.setObservationUnitDbId(entity.getObservationUnit().getId());
		}
		return img;
	}

	private String arrayToString(List<String> list) {
		String str = "";
		if (list != null && !list.isEmpty()) {
			for (String item : list) {
				str = str + item + ",";
			}
		}
		return str;
	}

	public Image updateImageMetaData(String imageDbId, @Valid NewImageRequest imageMetadata) {
		Image result = null;

		if (imageDbId != null) {
			Optional<ImageEntity> imageOption = imageRepository.findById(imageDbId);
			if (imageOption.isPresent()) {
				ImageEntity newEntity = imageOption.get();
				updateEntity(newEntity, imageMetadata);
				ImageEntity saved = imageRepository.save(newEntity);
				result = convertFromEntiy(saved);
			}
		}

		return result;
	}

	private class Geometry {
		@JsonProperty("type")
		private String type;
		@JsonProperty("coordinates")
		private List<Float> coordinates;

		public Geometry() {
			type = "Point";
			coordinates = new ArrayList<>();
		}

		public Geometry(Float latitude, Float longitude) {
			type = "Point";
			coordinates = Arrays.asList(latitude, longitude);
		}

		@JsonIgnore
		public Float getLat() {
			if (coordinates != null && coordinates.size() >= 1) {
				return coordinates.get(0);
			}
			return null;
		}

		@JsonIgnore
		public Float getLong() {
			if (coordinates != null && coordinates.size() >= 2) {
				return coordinates.get(1);
			}
			return null;
		}
	}

	public List<Image> search(ImagesSearchRequest request, Metadata metadata) throws BrAPIServerException {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<ImageEntity> imagesPage = imageRepository.findBySearch(request, pageReq);
		PagingUtility.calculateMetaData(metadata, imagesPage);
		List<Image> images = imagesPage.map(this::convertFromEntiy).getContent();

		return images;
	}
}
