package org.brapi.test.BrAPITestServer.service;

import io.swagger.model.BrAPIDataModel;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

import java.util.Optional;

public class UpdateUtility {

	public static <T> T replaceField(Optional<T> newValue, T oldValue) {
		if (newValue == null) {
			return oldValue;
		} else {
			if (newValue.isPresent()) {
				return newValue.get();
			} else {
				return null;
			}
		}
	}

	public static <T> Optional<T> setField(T value) {
		if (value == null) {
			return Optional.empty();
		} else {
			return Optional.of(value);
		}
	}

	public static <T extends BrAPIDataModel> T convertFromEntity(BrAPIPrimaryEntity entity, T model) {
		model.setAdditionalInfo(entity.getAdditionalInfo());
		model.setExternalReferences(entity.getExternalReferencesMap());
		return model;
	}

	public static <T extends BrAPIPrimaryEntity> T updateEntity(BrAPIDataModel model, T entity) {
		if (model.getAdditionalInfo() != null) {
			entity.setAdditionalInfo(model.getAdditionalInfo());
		}
		if (model.getExternalReferences() != null) {
			entity.setExternalReferences(model.getExternalReferences());
		}
		return entity;
	}
}
