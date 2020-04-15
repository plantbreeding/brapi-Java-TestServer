package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

import io.swagger.model.pheno.TraitDataType;

@Entity
@Table(name="scale")
public class ScaleEntity extends BrAPIPrimaryEntity implements OntologyReferenceHolder{
	@Column
	private String scaleName;
	@Column
	private TraitDataType dataType;
	@Column
	private Integer decimalPlaces;
	@Column
	private Integer validValueMin;
	@Column
	private Integer validValueMax;
	@OneToMany(mappedBy="scale", cascade = CascadeType.ALL)
	private List<ScaleValidValueCategoryEntity> validValueCategories;
	@OneToMany(mappedBy="scale", cascade = CascadeType.DETACH)
	private List<VariableBaseEntity> variables;
	@OneToOne
	private OntologyEntity ontology;
	@JoinTable
	@OneToMany(cascade = CascadeType.ALL)
	private List<OntologyReferenceEntity> ontologyReference;
	

	public Integer getValidValueMin() {
		return validValueMin;
	}
	public void setValidValueMin(Integer validValueMin) {
		this.validValueMin = validValueMin;
	}
	public Integer getValidValueMax() {
		return validValueMax;
	}
	public void setValidValueMax(Integer validValueMax) {
		this.validValueMax = validValueMax;
	}
	public List<ScaleValidValueCategoryEntity> getValidValueCategories() {
		return validValueCategories;
	}
	public void setValidValueCategories(List<ScaleValidValueCategoryEntity> validValueCategories) {
		this.validValueCategories = validValueCategories;
	}
	public OntologyEntity getOntology() {
		return ontology;
	}
	public void setOntology(OntologyEntity ontology) {
		this.ontology = ontology;
	}
	public List<OntologyReferenceEntity> getOntologyReference() {
		return ontologyReference;
	}
	public void setOntologyReference(List<OntologyReferenceEntity> ontologyReference) {
		this.ontologyReference = ontologyReference;
	}
	public List<VariableBaseEntity> getVariables() {
		return variables;
	}
	public void setVariables(List<VariableBaseEntity> variables) {
		this.variables = variables;
	}

	public TraitDataType getDataType() {
		return dataType;
	}

	public void setDataType(TraitDataType dataType) {
		this.dataType = dataType;
	}

	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}
	public String getScaleName() {
		return scaleName;
	}
	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}
}
