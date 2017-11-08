package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "call_method")
public class CallMethodEntity extends BaseEntity {
	@Column(name="call_dbid")
	private String callDbId;
	@Column
	private String method;
	public String getCallDbId() {
		return callDbId;
	}
	public void setCallDbId(String callDbId) {
		this.callDbId = callDbId;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	

}
