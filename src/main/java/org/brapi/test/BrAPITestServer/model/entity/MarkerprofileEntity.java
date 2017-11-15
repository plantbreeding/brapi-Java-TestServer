package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="markerprofile")
public class MarkerprofileEntity extends BaseEntity {
	@Column
	private String germplasmDbId;
	@Column
	private String uniqueDisplayName;
	@Column
	private String sampleDbId;
	@Column
	private String extractDbId;
	@Column
	private String analysisMethod;
	@Column
	private int resultCount;
	
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public String getUniqueDisplayName() {
		return uniqueDisplayName;
	}
	public void setUniqueDisplayName(String uniqueDisplayName) {
		this.uniqueDisplayName = uniqueDisplayName;
	}
	public String getSampleDbId() {
		return sampleDbId;
	}
	public void setSampleDbId(String sampleDbId) {
		this.sampleDbId = sampleDbId;
	}
	public String getExtractDbId() {
		return extractDbId;
	}
	public void setExtractDbId(String extractDbId) {
		this.extractDbId = extractDbId;
	}
	public String getAnalysisMethod() {
		return analysisMethod;
	}
	public void setAnalysisMethod(String analysisMethod) {
		this.analysisMethod = analysisMethod;
	}
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
}
