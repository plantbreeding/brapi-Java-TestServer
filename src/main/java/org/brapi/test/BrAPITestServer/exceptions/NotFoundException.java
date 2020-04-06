package org.brapi.test.BrAPITestServer.exceptions;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class NotFoundException extends ApiException {
	private static final long serialVersionUID = -8000903005649088467L;
	private int code;

	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
