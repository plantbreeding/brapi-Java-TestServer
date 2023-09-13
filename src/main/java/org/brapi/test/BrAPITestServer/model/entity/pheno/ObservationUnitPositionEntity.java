package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.GeoJSONEntity;

import io.swagger.model.pheno.EntryTypeEnum;
import io.swagger.model.pheno.ObservationUnitHierarchyLevelEnum;
import io.swagger.model.pheno.PositionCoordinateTypeEnum;

@Entity
@Table(name = "observation_unit_position")
public class ObservationUnitPositionEntity extends BrAPIBaseEntity {
	@Column
	private EntryTypeEnum entryType;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private GeoJSONEntity geoCoordinates;
	@Column
	private String levelCode;
	@Column
	private ObservationUnitHierarchyLevelEnum levelName;
	@Column
	private Integer levelOrder;
	@OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
	private List<ObservationUnitLevelRelationshipEntity> observationLevelRelationships;
	@Column
	private String positionCoordinateX;
	@Column
	private PositionCoordinateTypeEnum positionCoordinateXType;
	@Column
	private String positionCoordinateY;
	@Column
	private PositionCoordinateTypeEnum positionCoordinateYType;
	@OneToOne(fetch = FetchType.LAZY)
	private ObservationUnitEntity observationUnit;

	public ObservationUnitEntity getObservationUnit() {
		return observationUnit;
	}

	public void setObservationUnit(ObservationUnitEntity observationUnit) {
		this.observationUnit = observationUnit;
	}

	public EntryTypeEnum getEntryType() {
		return entryType;
	}

	public void setEntryType(EntryTypeEnum entryType) {
		this.entryType = entryType;
	}

	public GeoJSONEntity getGeoCoordinates() {
		return geoCoordinates;
	}

	public void setGeoCoordinates(GeoJSONEntity geoCoordinates) {
		this.geoCoordinates = geoCoordinates;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public ObservationUnitHierarchyLevelEnum getLevelName() {
		return levelName;
	}

	public void setLevelName(ObservationUnitHierarchyLevelEnum levelName) {
		this.levelName = levelName;
	}

	public Integer getLevelOrder() {
		return levelOrder;
	}

	public void setLevelOrder(Integer levelOrder) {
		this.levelOrder = levelOrder;
	}

	public List<ObservationUnitLevelRelationshipEntity> getObservationLevelRelationships() {
		return observationLevelRelationships;
	}

	public void setObservationLevelRelationships(
			List<ObservationUnitLevelRelationshipEntity> observationLevelRelationships) {
		this.observationLevelRelationships = observationLevelRelationships;
	}

	public String getPositionCoordinateX() {
		return positionCoordinateX;
	}

	public void setPositionCoordinateX(String positionCoordinateX) {
		this.positionCoordinateX = positionCoordinateX;
	}

	public PositionCoordinateTypeEnum getPositionCoordinateXType() {
		return positionCoordinateXType;
	}

	public void setPositionCoordinateXType(PositionCoordinateTypeEnum positionCoordinateXType) {
		this.positionCoordinateXType = positionCoordinateXType;
	}

	public String getPositionCoordinateY() {
		return positionCoordinateY;
	}

	public void setPositionCoordinateY(String positionCoordinateY) {
		this.positionCoordinateY = positionCoordinateY;
	}

	public PositionCoordinateTypeEnum getPositionCoordinateYType() {
		return positionCoordinateYType;
	}

	public void setPositionCoordinateYType(PositionCoordinateTypeEnum positionCoordinateYType) {
		this.positionCoordinateYType = positionCoordinateYType;
	}

	public String getFieldCode() {
		return getRelationshipCode(ObservationUnitHierarchyLevelEnum.FIELD);
	}

	public String getBlockCode() {
		return getRelationshipCode(ObservationUnitHierarchyLevelEnum.BLOCK);
	}

	public String getEntryCode() {
		return getRelationshipCode(ObservationUnitHierarchyLevelEnum.ENTRY);
	}

	public String getRepCode() {
		return getRelationshipCode(ObservationUnitHierarchyLevelEnum.REP);
	}

	public String getPlotCode() {
		return getRelationshipCode(ObservationUnitHierarchyLevelEnum.PLOT);
	}

	public String getPlantCode() {
		return getRelationshipCode(ObservationUnitHierarchyLevelEnum.PLANT);
	}
	
	private String getRelationshipCode(ObservationUnitHierarchyLevelEnum level) {
		if(getLevelName() == level) {
			return getLevelCode();
		}else {
			for(ObservationUnitLevelRelationshipEntity rel : getObservationLevelRelationships()) {
				if(rel.getLevelName() == level) {
					return rel.getLevelCode();
				}
			}
		}
		return null;
	}
}
