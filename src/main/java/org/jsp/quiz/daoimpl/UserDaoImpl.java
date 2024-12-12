package org.jsp.quiz.daoimpl;


import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.UserDao;

import org.jsp.quiz.entity.User;
import org.jsp.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {
		
		return repository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<User> findUserByEmailAndPassword(String email, String password) {
		
		return repository.findUserByEmailAndPassword(email,password);
	}
	
	
	

}
