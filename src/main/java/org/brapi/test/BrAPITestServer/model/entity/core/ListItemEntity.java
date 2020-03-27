package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "list_item")
public class ListItemEntity extends BrAPIBaseEntity {
	@ManyToOne(cascade = CascadeType.ALL)
	private ListEntity list;
	@Column
	private String item;
	
	public ListEntity getList() {
		return list;
	}
	public void setList(ListEntity list) {
		this.list = list;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
}
