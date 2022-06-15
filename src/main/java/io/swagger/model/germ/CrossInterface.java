package io.swagger.model.germ;

public interface CrossInterface {

	public String getPlannedCrossName();

	public void setPlannedCrossName(String plannedCrossName);

	public CrossType getCrossType();

	public void setCrossType(CrossType crossType);

	public String getCrossingProjectDbId();

	public void setCrossingProjectDbId(String crossingProjectDbId);

	public String getCrossingProjectName();

	public void setCrossingProjectName(String crossingProjectName);

	public CrossParent getParent1();

	public void setParent1(CrossParent parent1);

	public CrossParent getParent2();

	public void setParent2(CrossParent parent2);

}
