package org.brapi.test.BrAPITestServer.service;

import java.util.Optional;

public class UpdateUtility {
	
	public static <T> T replaceField(Optional<T> newValue, T oldValue) {
		if(newValue == null) {
			return oldValue;
		}else {
			if(newValue.isPresent()) {
				return newValue.get();
			}else {
				return null;
			}
		}
	}
	
	public static <T> Optional<T> setField(T value){
		if (value == null) {
			return Optional.empty();
		} else {
			return Optional.of(value);
		}
	}
}
