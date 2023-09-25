package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name = "seed_lot_transaction")
public class SeedLotTransactionEntity extends BrAPIPrimaryEntity {
	@Column
	private BigDecimal amount;
	@ManyToOne(fetch = FetchType.LAZY)
	private SeedLotEntity toSeedLot;
	@ManyToOne(fetch = FetchType.LAZY)
	private SeedLotEntity fromSeedLot;
	@Column
	private String description;
	@Column
	private Date timestamp;
	@Column
	private String units;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public SeedLotEntity getToSeedLot() {
		return toSeedLot;
	}
	public void setToSeedLot(SeedLotEntity toSeedLot) {
		this.toSeedLot = toSeedLot;
	}
	public SeedLotEntity getFromSeedLot() {
		return fromSeedLot;
	}
	public void setFromSeedLot(SeedLotEntity fromSeedLot) {
		this.fromSeedLot = fromSeedLot;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
}
