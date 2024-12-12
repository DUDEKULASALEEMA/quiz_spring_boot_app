package org.jsp.quiz.exceptionclasses;

import lombok.Builder;

@Builder
public class NoQuestionFoundException extends RuntimeException {
	
	private String message;
	
	public NoQuestionFoundException(String message) {
		super();
		this.message = message;
	}
	public NoQuestionFoundException() {
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
	

}
