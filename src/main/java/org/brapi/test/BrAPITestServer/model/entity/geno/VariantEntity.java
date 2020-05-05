package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name = "variant")
public class VariantEntity extends BrAPIPrimaryEntity {
	@ElementCollection
	private List<String> alternateBases;
	@ElementCollection
	private List<Integer> ciend;
	@ElementCollection
	private List<Integer> cipos;
	@Column
	private Date created;
	@Column(name = "variantEnd")
	private Integer end;
	@Column
	private Boolean filtersApplied;
	@ElementCollection
	private List<String> filtersFailed;
	@Column
	private Boolean filtersPassed;
	@Column
	private String referenceBases;
	@ManyToOne
	private ReferenceSetEntity referenceSet;
	@Column(name = "variantStart")
	private Integer start;
	@Column
	private Integer svlen;
	@Column
	private Date updated;
	@Column
	private String variantName;
	@ManyToOne
	private VariantSetEntity variantSet;
	@Column
	private String variantType;

	public VariantEntity() {
		super();
	}

	public VariantEntity(VariantEntity variant) {
		this.setAlternateBases(new ArrayList<>());
		this.getAlternateBases().addAll(variant.getAlternateBases());
		this.setCiend(new ArrayList<>());
		this.getCiend().addAll(variant.getCiend());
		this.setCipos(new ArrayList<>());
		this.getCipos().addAll(variant.getCipos());
		this.setCreated(variant.getCreated());
		this.setEnd(variant.getEnd());
		this.setFiltersApplied(variant.getFiltersApplied());
		this.setFiltersFailed(new ArrayList<>());
		this.getFiltersFailed().addAll(variant.getFiltersFailed());
		this.setFiltersPassed(variant.getFiltersPassed());
		this.setId(variant.getId());
		this.setReferenceBases(variant.getReferenceBases());
		this.setReferenceSet(variant.getReferenceSet());
		this.setStart(variant.getStart());
		this.setSvlen(variant.getSvlen());
		this.setUpdated(variant.getUpdated());
		this.setVariantName(variant.getVariantName());
		this.setVariantSet(variant.getVariantSet());
		this.setVariantType(variant.getVariantType());
	}

	public List<String> getAlternateBases() {
		return alternateBases;
	}

	public void setAlternateBases(List<String> alternateBases) {
		this.alternateBases = alternateBases;
	}

	public List<Integer> getCiend() {
		return ciend;
	}

	public void setCiend(List<Integer> ciend) {
		this.ciend = ciend;
	}

	public List<Integer> getCipos() {
		return cipos;
	}

	public void setCipos(List<Integer> cipos) {
		this.cipos = cipos;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Boolean getFiltersApplied() {
		return filtersApplied;
	}

	public void setFiltersApplied(Boolean filtersApplied) {
		this.filtersApplied = filtersApplied;
	}

	public List<String> getFiltersFailed() {
		return filtersFailed;
	}

	public void setFiltersFailed(List<String> filtersFailed) {
		this.filtersFailed = filtersFailed;
	}

	public Boolean getFiltersPassed() {
		return filtersPassed;
	}

	public void setFiltersPassed(Boolean filtersPassed) {
		this.filtersPassed = filtersPassed;
	}

	public String getReferenceBases() {
		return referenceBases;
	}

	public void setReferenceBases(String referenceBases) {
		this.referenceBases = referenceBases;
	}

	public ReferenceSetEntity getReferenceSet() {
		return referenceSet;
	}

	public void setReferenceSet(ReferenceSetEntity referenceSet) {
		this.referenceSet = referenceSet;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getSvlen() {
		return svlen;
	}

	public void setSvlen(Integer svlen) {
		this.svlen = svlen;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getVariantType() {
		return variantType;
	}

	public void setVariantType(String variantType) {
		this.variantType = variantType;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public VariantSetEntity getVariantSet() {
		return variantSet;
	}

	public void setVariantSet(VariantSetEntity variantSet) {
		this.variantSet = variantSet;
	}

}
