package com.marmed.demo.data.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marmed.demo.data.dto.ResourceDTO;
import com.marmed.demo.data.entities.Resource;

@Component
public class ResourceJSONRepository {
	@Autowired
	ResourceJpaRepository jpaRepository;
	
	
	public List<Resource> getResourcesFromJSON(){
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<ResourceDTO>> typeReference = new TypeReference<List<ResourceDTO>>() {};		
		
		try {
			InputStream inputStream = TypeReference.class.getResourceAsStream("/resources.json");
			List<ResourceDTO> resourceDTOList = mapper.readValue(inputStream, typeReference);
			List<Resource> resources = resourceDTOList.stream().map(item -> dtoToEntity(item, null)).collect(Collectors.toList());
			
			jpaRepository.saveAll(resources);
			
			
			System.out.println(resources.toString());
		}catch (IOException e) {
			System.out.println("Unable load resources: " + e.getMessage());
		}
		return null;
	}
	
	private static Resource dtoToEntity(ResourceDTO resource, String parentId){
		final Resource entity = new Resource();
		if(parentId != null) {
			Resource parent = new Resource();
			parent.setId(parentId);
			entity.setParent(parent);
		}
		
		entity.setId(resource.getId());
		entity.setName(resource.getName());
		entity.setDescription(resource.getDescription());
		entity.setIconClass(resource.getIconClass());
		entity.setType(resource.getType());
		if(resource.getSubitems() != null) {
			Set<Resource> subitems = resource.getSubitems().stream().map(subitem -> dtoToEntity(subitem, resource.getId())).collect(Collectors.toSet());
			entity.setSubitems(subitems);
		}
		
		
		return entity;
	}
}
