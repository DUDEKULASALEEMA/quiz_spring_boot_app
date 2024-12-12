package org.jsp.quiz.reponsestructure;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseStructure <T>{
	private int httpStatus;
	private String message;
	private T body;
}
