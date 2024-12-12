package org.jsp.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.entity.User;

public interface UserDao {

	User saveUser(User user);

	List<User> findAllUsers();

	

	Optional<User> findUserByEmailAndPassword(String email, String password);




}
