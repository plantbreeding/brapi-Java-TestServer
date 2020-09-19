package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.GeoJSONEntity;

@Entity
@Table(name="germplasm_origin")
public class GermplasmOriginEntity extends BrAPIBaseEntity{
	@Column
	private String coordinateUncertainty;
	@OneToOne(cascade = CascadeType.ALL)
	private GeoJSONEntity coordinates;
	@ManyToOne
	private GermplasmEntity germplasm;
	
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public String getCoordinateUncertainty() {
		return coordinateUncertainty;
	}
	public void setCoordinateUncertainty(String coordinateUncertainty) {
		this.coordinateUncertainty = coordinateUncertainty;
	}
	public GeoJSONEntity getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(GeoJSONEntity coordinates) {
		this.coordinates = coordinates;
	}

}
