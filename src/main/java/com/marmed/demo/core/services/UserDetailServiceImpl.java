package com.marmed.demo.core.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marmed.demo.data.entities.Role;
import com.marmed.demo.data.entities.User;
import com.marmed.demo.data.repositories.UserJpaRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	private UserJpaRepository userRepository;
	
	@Autowired
	public UserDetailServiceImpl(UserJpaRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user == null) throw new UsernameNotFoundException("No se ha encontrado un usuario");
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for(Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
	}

}
