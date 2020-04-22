package org.brapi.test.BrAPITestServer.model.entity.geno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name="callset")
public class CallSetEntity extends BrAPIPrimaryEntity {
	@Column
	private String callSetName;

	public String getCallSetName() {
		return callSetName;
	}

	public void setCallSetName(String callSetName) {
		this.callSetName = callSetName;
	}

}
