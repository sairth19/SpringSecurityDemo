package com.marmed.demo.presentation.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmed.demo.core.services.contract.IRoleService;
import com.marmed.demo.data.dto.ResourceDTO;
import com.marmed.demo.data.entities.Resource;
import com.marmed.demo.data.entities.Role;
import com.marmed.demo.data.repositories.ResourceJpaRepository;
import com.marmed.demo.presentation.model.CreateRoleRequest;

@RestController
@RequestMapping("/api/roles")
public class RoleResources {
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private ResourceJpaRepository resourceJpaRepository;
	
	
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
	
	@GetMapping("/resources")
	public ResponseEntity<?> getResources(){
		Resource resources = resourceJpaRepository.findById("main").orElse(null);
		return new ResponseEntity<ResourceDTO>(mapResources(resources), HttpStatus.OK);
	}

	private static ResourceDTO mapResources(Resource resource) {
		ResourceDTO dto = new ResourceDTO();
		dto.setCode(resource.getCode());
		dto.setName(resource.getName());
		dto.setDescription(resource.getDescription());
		dto.setIconClass(resource.getIconClass());
		dto.setType(resource.getType());
		dto.setUrl(resource.getUrl());
		
		
		if(!resource.getSubitems().isEmpty()) {
			List<ResourceDTO> subitems = resource.getSubitems().stream().map(RoleResources::mapResources).collect(Collectors.toList());
			dto.setSubitems(subitems);
		}
		
		return dto;
		
	}
}
