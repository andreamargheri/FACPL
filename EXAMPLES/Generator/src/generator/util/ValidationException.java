package generator.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.xtext.validation.Issue;

public class ValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> errors;

	public ValidationException() {
		errors = new LinkedList<String>();
	}

	public void addError(Issue issue) {
		errors.add("Line: " + issue.getLineNumber() + " : " + issue.getMessage());
	}

	@Override
	public String toString() {
		StringBuffer statement = new StringBuffer();
		statement.append("");
		for (String s : errors) {
			statement.append(s + "\n");
		}
		return statement.toString();
	}

}
