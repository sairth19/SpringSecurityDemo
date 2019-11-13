package com.marmed.demo.presentation.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmed.demo.core.services.contract.IRoleService;
import com.marmed.demo.data.entities.Role;
import com.marmed.demo.presentation.model.CreateRoleRequest;

@RestController
@RequestMapping("/api/roles")
public class RoleResources {
	
	@Autowired
	private IRoleService roleService;
	
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody CreateRoleRequest createRoleRequest){
		Role role = new Role();
		role.setName(createRoleRequest.getName());
		role = roleService.createRole(role);
		
		return new ResponseEntity<Role>(role, HttpStatus.OK);
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> listAll() {
		final List<Role> rolesList = roleService.findAll();
		return new ResponseEntity<List<Role>>(rolesList, HttpStatus.OK);
	}

}
