package com.marmed.demo.presentation.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserResources {
	
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		return new ResponseEntity<String>("Hola",HttpStatus.OK);
	}
}
