package org.jsp.quiz.service;

import java.util.List;

import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.dto.TakeQuiz;
import org.jsp.quiz.entity.Question;
import org.springframework.http.ResponseEntity;

public interface QuestionService {

	ResponseEntity<?> saveQuestion(Question question);

	ResponseEntity<?> findAllQuestions();

	ResponseEntity<?> findQuestionById(int id);

	ResponseEntity<?> submitQuiz(List<QuizResponse> quizresponses);

	ResponseEntity<?> takeQuiz();

	ResponseEntity<?> getRandomQuestions(int count);
	
	

	



	

	
	

}