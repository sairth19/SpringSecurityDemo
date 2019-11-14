package com.marmed.demo.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.marmed.demo.data.entities.Resource;

public interface ResourceJpaRepository extends JpaRepository<Resource, String>{
	
	@EntityGraph(value = "Resource.menus", type = EntityGraphType.LOAD)
    List<Resource> findBySubitemsNotNull();

}
