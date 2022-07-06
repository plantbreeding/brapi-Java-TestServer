package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.time.OffsetDateTime;

public class EventDateRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("discreteDates")
	private List<OffsetDateTime> discreteDates = null;

	@JsonProperty("endDate")
	private Date endDate = null;

	@JsonProperty("startDate")
	private Date startDate = null;

	public EventDateRange discreteDates(List<OffsetDateTime> discreteDates) {
		this.discreteDates = discreteDates;
		return this;
	}

	public EventDateRange addDiscreteDatesItem(OffsetDateTime discreteDatesItem) {
		if (this.discreteDates == null) {
			this.discreteDates = new ArrayList<>();
		}
		this.discreteDates.add(discreteDatesItem);
		return this;
	}

	public List<OffsetDateTime> getDiscreteDates() {
		return discreteDates;
	}

	public void setDiscreteDates(List<OffsetDateTime> discreteDates) {
		this.discreteDates = discreteDates;
	}

	public EventDateRange endDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public EventDateRange startDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EventDateRange eventEventDateRange = (EventDateRange) o;
		return Objects.equals(this.discreteDates, eventEventDateRange.discreteDates)
				&& Objects.equals(this.endDate, eventEventDateRange.endDate)
				&& Objects.equals(this.startDate, eventEventDateRange.startDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(discreteDates, endDate, startDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EventEventDateRange {\n");

		sb.append("    discreteDates: ").append(toIndentedString(discreteDates)).append("\n");
		sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
