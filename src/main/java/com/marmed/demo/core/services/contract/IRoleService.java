package com.marmed.demo.core.services.contract;

import java.util.List;

import com.marmed.demo.data.entities.Role;

public interface IRoleService {
	List<Role> findAll();
	Role createRole(Role role);
	boolean roleAlreadyExist(String roleName);
}
