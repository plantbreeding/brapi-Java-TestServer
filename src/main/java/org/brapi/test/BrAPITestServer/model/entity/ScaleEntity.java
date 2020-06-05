package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="scale")
public class ScaleEntity extends BaseEntity implements OntologyInterface{
	@Column
	private String name;
	@Column
	private String dataType;
	@Column
	private Integer decimalPlaces;
	@Column
	private String xref;


	@Column
	private Integer validValueMin;
	@Column
	private Integer validValueMax;
	@ElementCollection
	private List<String> validValueCategories;
	
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
	public List<String> getValidValueCategories() {
		return validValueCategories;
	}
	public void setValidValueCategories(List<String> validValueCategories) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public String getXref() {
		return xref;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}
}
