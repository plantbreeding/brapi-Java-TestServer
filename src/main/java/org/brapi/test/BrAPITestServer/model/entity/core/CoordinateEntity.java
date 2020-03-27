package org.brapi.test.BrAPITestServer.model.entity.core;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="coordinate")
public class CoordinateEntity extends BrAPIBaseEntity{
	@Column(precision = 9, scale = 6)
	private BigDecimal longitude;
	@Column(precision = 9, scale = 6)
	private BigDecimal latitude;
	@Column(precision = 9, scale = 6)
	private BigDecimal altitude;
	@ManyToOne
	private GeoJSONEntity geoJSON;
	
	public GeoJSONEntity getGeoJSON() {
		return geoJSON;
	}
	public void setGeoJSON(GeoJSONEntity geoJSON) {
		this.geoJSON = geoJSON;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getAltitude() {
		return altitude;
	}
	public void setAltitude(BigDecimal altitude) {
		this.altitude = altitude;
	}
}
