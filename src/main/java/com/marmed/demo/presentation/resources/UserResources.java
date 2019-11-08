package com.marmed.demo.presentation.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmed.demo.core.services.contract.IUserService;
import com.marmed.demo.data.entities.User;

@RestController
@RequestMapping("/api/users")
public class UserResources {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		return new ResponseEntity<String>("Hola",HttpStatus.OK);
	}
	
	@GetMapping("/verify/username")
	public ResponseEntity<Boolean> usernameIsAlreadyUsed(String username){
		boolean response = userService.usernameIsAlreadyUsed("sairth19");
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<User> create(){
		User userToCreate = new User();
		userToCreate.setUserName("sairth19");
		userToCreate.setEmail("sairth19@gmail.com");
		userToCreate.setPassword("HrryPttr3");
		
		User user;
		try {
			user = userService.create(userToCreate);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(userToCreate, HttpStatus.OK);
		}
	}
}
