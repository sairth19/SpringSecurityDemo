package com.marmed.demo.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marmed.demo.core.services.contract.IUserService;
import com.marmed.demo.data.entities.User;
import com.marmed.demo.data.repositories.UserJpaRepository;

@Service
public class UserServiceImpl implements IUserService{
	private UserJpaRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserJpaRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public User create(User user) throws Exception {
		if(usernameIsAlreadyUsed(user.getUserName())) throw new Exception();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user = userRepository.save(user);
		return user;
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public boolean usernameIsAlreadyUsed(String username) {
		ExampleMatcher USERNAME_MATCHER= ExampleMatcher.matching()
				.withMatcher("userName", GenericPropertyMatchers.ignoreCase());
		final User user = new User();
		user.setUserName(username);
		Example<User> example = Example.<User>of(user, USERNAME_MATCHER);
		return userRepository.exists(example);
	}
	
	
	
}
