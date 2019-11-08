package com.marmed.demo.data.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marmed.demo.data.entities.User;

public interface UserJpaRepository extends JpaRepository<User, BigInteger>{
	User findByUserName(String userName);
}
