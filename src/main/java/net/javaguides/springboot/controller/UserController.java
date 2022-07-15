package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path="/", produces = { "application/xml", "text/xml" })
	User all() {
		return userRepository.findAll().get(0);
	}

	@PostMapping(path="/" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createUser(@RequestBody User user){
		userRepository.save(user);
	}

}
