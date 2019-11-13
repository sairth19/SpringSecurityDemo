package com.marmed.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marmed.demo.data.entities.Resource;

public interface ResourceJpaRepository extends JpaRepository<Resource, String>{

}
