package org.jsp.quiz.repository;

import java.util.Optional;

import org.jsp.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findUserByEmailAndPassword(String email, String password);


}
