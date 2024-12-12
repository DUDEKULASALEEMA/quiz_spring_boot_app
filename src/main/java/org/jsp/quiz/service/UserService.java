package org.jsp.quiz.service;


import org.jsp.quiz.dto.AuthUser;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.reponsestructure.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findAllUsers();

	

	ResponseEntity<?> findUserByEmailAndPassword(AuthUser auth);


}
