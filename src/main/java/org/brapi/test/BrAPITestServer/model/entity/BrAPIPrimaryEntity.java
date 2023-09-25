package org.brapi.test.BrAPITestServer.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.*;

import io.swagger.model.ExternalReferences;
import io.swagger.model.ExternalReferencesInner;

@MappedSuperclass
public class BrAPIPrimaryEntity extends BrAPIBaseEntity {

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "id") })
	private List<AdditionalInfoEntity> additionalInfo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "id") })
	private List<ExternalReferenceEntity> externalReferences;
	
	@Column
	private String authUserId;

	public String getAuthUserId() {
		return authUserId;
	}

	public void setAuthUserId(String authUserId) {
		this.authUserId = authUserId;
	}

	public List<AdditionalInfoEntity> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(List<AdditionalInfoEntity> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Map<String, Object> getAdditionalInfoMap() {
		Map<String, Object> info = new HashMap<>();
		if (getAdditionalInfo() != null) {
			for (AdditionalInfoEntity entity : getAdditionalInfo()) {
				info.put(entity.getKey(), entity.getValue());
			}
		}
		return info;
	}

	public void setAdditionalInfo(Map<String, Object> map) {
		if (map != null) {
			setAdditionalInfo(new ArrayList<>());
			for (Entry<String, Object> entry : map.entrySet()) {
				AdditionalInfoEntity entity = new AdditionalInfoEntity();
				entity.setKey(entry.getKey());
				entity.setValue(entry.getValue());
				getAdditionalInfo().add(entity);
			}
		}
	}

	public List<ExternalReferenceEntity> getExternalReferences() {
		return externalReferences;
	}

	public void setExternalReferences(List<ExternalReferenceEntity> externalReferences) {
		this.externalReferences = externalReferences;
	}

	public ExternalReferences getExternalReferencesMap() {
		ExternalReferences exRefs = new ExternalReferences();
		if (getExternalReferences() != null) {
			for (ExternalReferenceEntity entity : getExternalReferences()) {
				ExternalReferencesInner exRef = new ExternalReferencesInner();
				exRef.setReferenceID(entity.getExternalReferenceId());
				exRef.setReferenceSource(entity.getExternalReferenceSource());
				exRefs.add(exRef);
			}
		}
		return exRefs;
	}

	public void setExternalReferences(ExternalReferences exRefs) {
		if (exRefs != null) {
			setExternalReferences(new ArrayList<>());
			for (ExternalReferencesInner exRef : exRefs) {
				ExternalReferenceEntity entity = new ExternalReferenceEntity();
				entity.setExternalReferenceId(exRef.getReferenceID());
				entity.setExternalReferenceSource(exRef.getReferenceSource());
				getExternalReferences().add(entity);
			}
		}
	}

}
