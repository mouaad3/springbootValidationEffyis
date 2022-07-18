package net.javaguides.springboot.controller;


import com.fasterxml.jackson.annotation.JsonView;
import net.javaguides.springboot.model.CollectionWrapper;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.UserView;
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
	@JsonView(UserView.Summary.class)
	public CollectionWrapper all() {
		return new CollectionWrapper(userRepository.findAll());
	}

	@PostMapping(path="/" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createUser(@RequestBody User user){
		userRepository.save(user);
	}

}
