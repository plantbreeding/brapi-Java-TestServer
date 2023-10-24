package org.brapi.test.BrAPITestServer.model.entity;

import org.brapi.test.BrAPITestServer.converter.JsonbConverter;
import org.brapi.test.BrAPITestServer.converter.JsonbObject;

import javax.persistence.*;

@Entity
@Table(name="additional_info")
public class AdditionalInfoEntity extends BrAPIBaseEntity{
	@Column
	private String key;
//	@Column
//	private byte[] value;
	@Convert(converter=JsonbConverter.class)
	@Column(columnDefinition="jsonb")
	private JsonbObject value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() { return value.value; }
	public void setValue(Object value) { this.value = new JsonbObject(value); }
	
	
}
