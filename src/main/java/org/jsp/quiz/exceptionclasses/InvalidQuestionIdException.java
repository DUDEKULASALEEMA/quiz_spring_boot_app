package org.jsp.quiz.exceptionclasses;

import lombok.Builder;

@Builder
public class InvalidQuestionIdException extends RuntimeException{
private String message;
	
	public InvalidQuestionIdException(String message) {
		super();
		this.message = message;
	}
	public InvalidQuestionIdException() {
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
	

}
