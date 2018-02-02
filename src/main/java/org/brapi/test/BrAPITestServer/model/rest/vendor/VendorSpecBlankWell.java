package org.brapi.test.BrAPITestServer.model.rest.vendor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;

public class VendorSpecBlankWell {
    private List<String> positions;
    private Integer numberOfBlanksPerPlate;
	public List<String> getPositions() {
		return positions;
	}
	public void setPositions(List<String> positions) {
		this.positions = positions;
	}
	public Integer getNumberOfBlanksPerPlate() {
		return numberOfBlanksPerPlate;
	}
	public void setNumberOfBlanksPerPlate(Integer numberOfBlanksPerPlate) {
		this.numberOfBlanksPerPlate = numberOfBlanksPerPlate;
	}
}
