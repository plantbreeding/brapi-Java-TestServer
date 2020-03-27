package org.brapi.test.BrAPITestServer.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="geojson")
public class GeoJSONEntity extends BrAPIBaseEntity{	
	@Column
	private String type;
	@OneToMany(mappedBy="geoJSON")
	private List<CoordinateEntity> coordinates;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<CoordinateEntity> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<CoordinateEntity> coordinates) {
		this.coordinates = coordinates;
	}
	public void addCoordinate(CoordinateEntity coordinate) {
		if(this.coordinates == null) {
			this.coordinates = new ArrayList<>();
		}
		this.coordinates.add(coordinate);
	}
}
