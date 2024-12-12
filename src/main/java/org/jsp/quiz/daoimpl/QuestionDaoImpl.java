package org.jsp.quiz.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	@Autowired
	private QuestionRepository repository;

	@Override
	public Question saveQuestion(Question question) {
		return repository.save(question);
	}

	@Override
	public List<Question> findAllQuestions() {
		return repository.findAll();
	}

	@Override
	public Optional<Question> findQuestionById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
//To find active questions
	@Override
	public List<Question> findAllActiveQuestions() {
		return repository.findAllActiveQuestions();
	}


	@Override
	public List<Question> findAllByOrderByIdAsc() {
		return repository.findAllByOrderByIdAsc();
	}
	

}
