package org.jsp.quiz.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.jsp.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
@Component
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	@Query("select q from Question q where q.status='ACTIVE'")
	List<Question> findAllActiveQuestions();
	 @Query("SELECT q FROM Question q ORDER BY RAND()")
	 List<Question> findAllByOrderByIdAsc(); 
//	@Query("SELECT q FROM Question q ORDER BY fUNCTION('RAND') ASC")
//	List<Question> findRandaomQuestions(Pageable pageable);

}
