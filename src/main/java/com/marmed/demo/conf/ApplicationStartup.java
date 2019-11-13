package com.marmed.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.marmed.demo.data.repositories.ResourceJSONRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	private ResourceJSONRepository resourceRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println("Cargando menus");
		resourceRepository.getResourcesFromJSON();
	}
}
