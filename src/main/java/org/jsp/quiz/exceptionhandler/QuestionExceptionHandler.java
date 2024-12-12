package org.jsp.quiz.exceptionhandler;

import org.jsp.quiz.exceptionclasses.InvalidQuestionIdException;
import org.jsp.quiz.exceptionclasses.NoQuestionFoundException;
import org.jsp.quiz.reponsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuestionExceptionHandler {
	@ExceptionHandler(NoQuestionFoundException.class)
	public ResponseEntity<?> NoQuestionFoundExceptionHandler(NoQuestionFoundException e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .body(ResponseStructure
							 .builder()
							 .httpStatus(HttpStatus.NOT_FOUND.value())
							 .message("No Question Found")
							 .body("No questions found in the database").build());
	}
	@ExceptionHandler(InvalidQuestionIdException.class)
	public ResponseEntity<?> InvalidQuestionIdExceptionHandler(InvalidQuestionIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				 .body(ResponseStructure
				 .builder()
				 .httpStatus(HttpStatus.NOT_FOUND.value())
				 .message("Id Not Found")
				 .body("Id Not found in the database").build());
	}
}
