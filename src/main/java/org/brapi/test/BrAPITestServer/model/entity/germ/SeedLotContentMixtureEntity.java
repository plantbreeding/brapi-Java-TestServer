package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "seed_lot_content_mixture")
public class SeedLotContentMixtureEntity extends BrAPIBaseEntity {
	@Column
	private Integer mixturePercentage;
	@ManyToOne(fetch = FetchType.LAZY)
	private GermplasmEntity germplasm;
	@ManyToOne(fetch = FetchType.LAZY)
	private CrossEntity cross;
	@ManyToOne(fetch = FetchType.LAZY)
	private SeedLotEntity seedLot;
	
	public Integer getMixturePercentage() {
		return mixturePercentage;
	}
	public void setMixturePercentage(Integer mixturePercentage) {
		this.mixturePercentage = mixturePercentage;
	}
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public CrossEntity getCross() {
		return cross;
	}
	public void setCross(CrossEntity cross) {
		this.cross = cross;
	}
	public SeedLotEntity getSeedLot() {
		return seedLot;
	}
	public void setSeedLot(SeedLotEntity seedLot) {
		this.seedLot = seedLot;
	}

}
