package edjdc.portfolio.exception.response;

import java.io.Serializable;
import java.util.List;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = -2107208322067111734L;
	
	private String errorMessage;
	private List<String> errors;

	public ExceptionResponse() {

	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
