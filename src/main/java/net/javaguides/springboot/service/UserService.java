package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers(){ return userRepository.findAll();}
	public User createUser(User user) {
		return userRepository.save(user);
	}


	public void addNewUser(User user) {
		System.out.println(user);
	}
}
