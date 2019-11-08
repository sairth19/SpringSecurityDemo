package com.marmed.demo.core.services.contract;

import com.marmed.demo.data.entities.User;

public interface IUserService {
	User create(User user) throws Exception;
	User findByUsername(String username);
	boolean usernameIsAlreadyUsed(String username);

}
