package org.jsp.quiz.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.UserDao;
import org.jsp.quiz.dto.AuthUser;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.reponsestructure.ResponseStructure;
import org.jsp.quiz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user = dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder()
				.httpStatus(HttpStatus.OK.value()).message("question added sucessful").body(user).build());

		
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> users=dao.findAllUsers();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All questions found").body(users).build());
	}

	@Override
	public ResponseEntity<?> findUserByEmailAndPassword(AuthUser auth) {
		Optional<User> optional = dao.findUserByEmailAndPassword(auth.getEmail(), auth.getPassword());

		
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid Credentials");

		}
		return  ResponseEntity.status(HttpStatus.OK)
										.body(ResponseStructure.builder()
										.httpStatus(HttpStatus.OK.value())
										.message("Submission succesfull")
										.body(optional.get()).build());


		

	}
	


}
