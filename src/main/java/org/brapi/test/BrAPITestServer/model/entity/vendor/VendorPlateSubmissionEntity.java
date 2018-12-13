package org.brapi.test.BrAPITestServer.model.entity.vendor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import io.swagger.model.VendorOrderRequest.SampleTypeEnum;

@Entity
@Table(name="plate_submission")
public class VendorPlateSubmissionEntity extends BaseEntity{
	
	@Column
	private String clientId;
	@Column
	private Integer numberOfSamples;
	@Column
	private SampleTypeEnum sampleType;
	@OneToMany(mappedBy="submission", cascade = CascadeType.ALL)
    private List<PlateEntity> plates;
	@OneToOne(cascade = CascadeType.ALL)
	private VendorOrderEntity order;
	
	
	public VendorOrderEntity getOrder() {
		return order;
	}
	public void setOrder(VendorOrderEntity order) {
		this.order = order;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Integer getNumberOfSamples() {
		return numberOfSamples;
	}
	public void setNumberOfSamples(Integer numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
	}
	public SampleTypeEnum getSampleType() {
		return sampleType;
	}
	public void setSampleType(SampleTypeEnum sampleType) {
		this.sampleType = sampleType;
	}
	public List<PlateEntity> getPlates() {
		return plates;
	}
	public void setPlates(List<PlateEntity> plates) {
		this.plates = plates;
	}
	
}
