package com.marmed.demo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.marmed.demo.core.services.contract.IRoleService;
import com.marmed.demo.data.entities.Role;
import com.marmed.demo.data.repositories.RoleJpaRepository;

@Service
public class RoleServiceImpl implements IRoleService{
	
	private RoleJpaRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(RoleJpaRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role createRole(Role role) {
		if(roleAlreadyExist(role.getName())) return null;
		
		return roleRepository.save(role);
	}

	@Override
	public boolean roleAlreadyExist(String roleName) {
		ExampleMatcher ROLENAME_MATCHER= ExampleMatcher.matching()
				.withMatcher("name", GenericPropertyMatchers.ignoreCase());
		final Role role = new Role();
		role.setName(roleName);
		Example<Role> example = Example.<Role>of(role, ROLENAME_MATCHER);
		return roleRepository.exists(example);
	}
	
	
	

}
