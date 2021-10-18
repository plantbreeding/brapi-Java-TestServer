package org.brapi.test.BrAPITestServer.service.germ;

public class PurdyNode {
	
	private String pedigreeString;
	private PurdyNode parent1;
	private PurdyNode parent2;
	
	public PurdyNode(String pedigreeString) {
		setPedigreeString(pedigreeString);
	}
	
	public String getPedigreeString() {
		return pedigreeString;
	}

	public void setPedigreeString(String pedigreeString) {
		this.pedigreeString = pedigreeString;
	}

	public PurdyNode getParent1() {
		return parent1;
	}
	public void setParent1(PurdyNode parent1) {
		this.parent1 = parent1;
	}
	public PurdyNode getParent2() {
		return parent2;
	}
	public void setParent2(PurdyNode parent2) {
		this.parent2 = parent2;
	}
}
