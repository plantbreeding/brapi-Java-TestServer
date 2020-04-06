package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="germplasm_type_storage_code")
public class GermplasmTypeStorageCodeEntity extends BrAPIBaseEntity{
	@Column(name="storage_code")
	private Integer storageCode;

	public Integer getStorageCode() {
		return storageCode;
	}

	public void setStorageCode(Integer storageCode) {
		this.storageCode = storageCode;
	}
}
