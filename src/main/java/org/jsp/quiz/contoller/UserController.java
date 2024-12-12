package org.jsp.quiz.contoller;


import org.jsp.quiz.dto.AuthUser;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.reponsestructure.ResponseStructure;
import org.jsp.quiz.service.QuestionService;
import org.jsp.quiz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		return service.findAllUsers();
	}
	
	@PostMapping("/login")
	// To achieve secutiry-pm
	public ResponseEntity<?> findStudentByEmailAndPassword(@RequestBody AuthUser auth) {

		return service.findUserByEmailAndPassword(auth);
	}

	

}
