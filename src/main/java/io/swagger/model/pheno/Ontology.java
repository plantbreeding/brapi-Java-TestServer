package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ontology extends OntologyNewRequest {

	@JsonProperty("ontologyDbId")
	private String ontologyDbId = null;

	public Ontology ontologyDbId(String ontologyDbId) {
		this.ontologyDbId = ontologyDbId;
		return this;
	}

	public String getOntologyDbId() {
		return ontologyDbId;
	}

	public void setOntologyDbId(String ontologyDbId) {
		this.ontologyDbId = ontologyDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ontology ontology = (Ontology) o;
		return Objects.equals(this.additionalInfo, ontology.additionalInfo)
				&& Objects.equals(this.ontologyDbId, ontology.ontologyDbId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, ontologyDbId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Ontology {\n");
		sb.append("    ontologyDbId: ").append(toIndentedString(ontologyDbId)).append("\n");
		sb.append(super.toString());
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
