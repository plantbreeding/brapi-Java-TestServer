package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponseResult;
import java.util.ArrayList;
import java.util.List;

public class EventsResponseResult implements BrAPIResponseResult<Event> {
	@JsonProperty("data")

	private List<Event> data = new ArrayList<Event>();

	public EventsResponseResult data(List<Event> data) {
		this.data = data;
		return this;
	}

	public EventsResponseResult addDataItem(Event dataItem) {
		this.data.add(dataItem);
		return this;
	}

	public List<Event> getData() {
		return data;
	}

	public void setData(List<Event> data) {
		this.data = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EventsResponseResult eventsResponseResult = (EventsResponseResult) o;
		return Objects.equals(this.data, eventsResponseResult.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EventsResponseResult {\n");

		sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
