package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class StudyObservationUnitWrapper {
private String transactionDbId;
private boolean commit;
private List<StudyObservationUnit> data;
public String getTransactionDbId() {
	return transactionDbId;
}
public void setTransactionDbId(String transactionDbId) {
	this.transactionDbId = transactionDbId;
}
public boolean isCommit() {
	return commit;
}
public void setCommit(boolean commit) {
	this.commit = commit;
}
public List<StudyObservationUnit> getData() {
	return data;
}
public void setData(List<StudyObservationUnit> data) {
	this.data = data;
}
}
