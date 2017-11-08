package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="call")
public class CallEntity extends BaseEntity{
	@Column(name="call", nullable=false)
	private String call;
	@OneToMany(mappedBy="callDbId", targetEntity=CallDataTypeEntity.class)
	private List<CallDataTypeEntity> dataTypes;
	@OneToMany(mappedBy="callDbId")
	private List<CallMethodEntity> methods;

	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public List<CallDataTypeEntity> getDataTypes() {
		return dataTypes;
	}
	public void setDataTypes(List<CallDataTypeEntity> dataTypes) {
		this.dataTypes = dataTypes;
	}
	public List<CallMethodEntity> getMethods() {
		return methods;
	}
	public void setMethods(List<CallMethodEntity> methods) {
		this.methods = methods;
	}
	
	
	
	
}
