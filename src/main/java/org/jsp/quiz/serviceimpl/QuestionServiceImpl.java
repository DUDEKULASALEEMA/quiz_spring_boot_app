package org.jsp.quiz.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.dto.QuestionDto;
import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.dto.TakeQuiz;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.exceptionclasses.InvalidQuestionIdException;
import org.jsp.quiz.exceptionclasses.NoQuestionFoundException;
import org.jsp.quiz.reponsestructure.ResponseStructure;
import org.jsp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao dao;

	@Override
	public ResponseEntity<?> saveQuestion(Question question) {
		question = dao.saveQuestion(question);
//		ResponseStructure<Question> structure = new ResponseStructure<>();
//		structure.setHttpStatus(HttpStatus.OK.value());
//		structure.setMessage("Question Added Succesfully");
//		structure.setBody(question);
//		return new ResponseEntity<>(structure, HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder()
				.httpStatus(HttpStatus.OK.value()).message("question added sucessful").body(question).build());

	}

	@Override
	public ResponseEntity<?> findAllQuestions() {
//		List<Question> questions = dao.findAllActiveQuestions();

		List<Question> questions = dao.findAllActiveQuestions();
		List<QuestionDto> dtolist = new ArrayList<>();
		for (Question q : questions) {
//			QuestionDto qdto=new QuestionDto();
//			qdto.setTitle(q.getTitle());
//			qdto.setA();
//			qdto.setB(q.getB());
//			qdto.setC(q.getC());
//			qdto.setD(q.getD());

			dtolist.add(new QuestionDto(q.getTitle(), q.getA(), q.getB(), q.getC(), q.getD()));

		}

		if (dtolist.isEmpty()) {
			// throw NoQuestionFoundException.builder.build("No questions found in
			// database");
			throw NoQuestionFoundException.builder().message("No questions found in database").build();
		}
//		ResponseStructure structure = ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
//				.message("All questions found").body(questions).build();
//		return ResponseEntity.status(HttpStatus.OK).body(structure);

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All questions found").body(dtolist).build());
	}

	@Override
	public ResponseEntity<?> findQuestionById(int id) {
		// TODO Auto-generated method stub
		Optional<Question> optional = dao.findQuestionById(id);
		if (optional.isEmpty()) {
			throw InvalidQuestionIdException.builder().message("Invalid id").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("Id found sucessful").body(optional.get()).build());

	}
        
	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizresponses) {
		int c = 0;
		for (QuizResponse qr : quizresponses) {
			Optional<Question> q = dao.findQuestionById(qr.getId());
			if (q.isEmpty()) {
				throw InvalidQuestionIdException.builder().message("Invalid Question Id unable to calulate the result")
						.build();
			}
			Question question = q.get();
			if (question.getAns().equalsIgnoreCase(qr.getAns())) {
				c++;
			}
		}
		return ResponseEntity.status(HttpStatus.OK)
										.body(ResponseStructure.builder()
										.httpStatus(HttpStatus.OK.value())
										.message("Submission succesfull")
										.body("Your score:"+c).build());

	}

	@Override
	public ResponseEntity<?> takeQuiz() {
		List<Question> questions = dao.findAllActiveQuestions();
		List<TakeQuiz> dtolist = new ArrayList<>();
		for (Question q : questions) {


			dtolist.add(new TakeQuiz(q.getId(),q.getTitle(), q.getA(), q.getB(), q.getC(), q.getD()));

		}

		if (dtolist.isEmpty()) {
			
			throw NoQuestionFoundException.builder().message("No questions found in database").build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All questions found").body(dtolist).build());
	}

	@Override
	public ResponseEntity<?> getRandomQuestions(int count) {
		List<Question> questions = dao.findAllByOrderByIdAsc();
		List<TakeQuiz> dtolist = new ArrayList<>();
		for (Question q : questions) {


			dtolist.add(new TakeQuiz(q.getId(),q.getTitle(), q.getA(), q.getB(), q.getC(), q.getD()));

		}

		if (dtolist.isEmpty()) {
			
			throw NoQuestionFoundException.builder().message("No questions found in database").build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All questions found").body(dtolist).build());
	}
	
	
	
	
	
	
//	 public List<Question> getRandomQuestions(int count) {
//	        List<Question> allQuestions = dao.findAllByOrderByIdAsc();
//	        Collections.shuffle(allQuestions);  // Shuffle the list to randomize the order
//	        return allQuestions.subList(0, Math.min(count, allQuestions.size()));  // Return up to 'count' random questions
//	    }
//	
	 
//	 public List<QuestionDTO> getRandomQuestions(int count) {
//	        List<Question> allQuestions = questionRepository.findAllByOrderByIdAsc();
//	        Collections.shuffle(allQuestions);  // Shuffle the list to randomize the order
//	        
//	        // Convert List<Question> to List<QuestionDTO> and return
//	        return allQuestions.stream()
//	                           .limit(count)
//	                           .map(question -> new QuestionDTO(
//	                                   question.getQuestionText(),
//	                                   question.getOptionA(),
//	                                   question.getOptionB(),
//	                                   question.getOptionC(),
//	                                   question.getOptionD()))
//	                           .collect(Collectors.toList());
//	    }

}

//
//@Override
//public ResponseEntity<?> findAllQuestions() {
//	List<Question> questions = dao.findAllQuestions();
//	if(questions.isEmpty()) {
//		//throw  NoQuestionFoundException.builder.build("No questions found in database");
//		throw NoQuestionFoundException.builder().message("No questions found in database ").build();
//	}
//	ResponseStructure<List<Question>> structure =new ResponseStructure<>();
//	structure.setHttpStatus(HttpStatus.OK.value());
//	structure.setBody(questions);
//	structure.setMessage("All Questions found ");
//	return new ResponseEntity<>(structure,HttpStatus.OK);
//}

//@Override
//public ResponseEntity<?> findQuestionById(int id) {
//	Optional<Question> optional = dao.findQuestionById(id);
//	if (optional.isEmpty()) {
//		throw InvalidQuestionIdException.builder().message("Invalid id").build();
//	}
//	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
//			.message("Id found sucessful").body(optional.get()).build());
//
//}
//@Override
//public ResponseEntity<?> findAllQuestions() {
//	List<Question> questions = dao.findAllQuestions();
//
//	if (questions.isEmpty()) {
//		// throw NoQuestionFoundException.builder.build("No questions found in
//		// database");
//		throw NoQuestionFoundException.builder().message("No questions found in database").build();
//	}
////	ResponseStructure structure = ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
////			.message("All questions found").body(questions).build();
////	return ResponseEntity.status(HttpStatus.OK).body(structure);
//
//	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
//			.message("All questions found").body(questions).build());
//}
