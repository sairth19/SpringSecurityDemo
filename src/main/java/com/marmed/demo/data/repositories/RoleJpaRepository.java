package com.marmed.demo.data.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marmed.demo.data.entities.Role;

public interface RoleJpaRepository extends JpaRepository<Role, BigInteger>{

}
