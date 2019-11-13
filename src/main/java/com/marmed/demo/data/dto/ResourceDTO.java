package com.marmed.demo.data.dto;

import java.io.Serializable;
import java.util.List;

public class ResourceDTO implements Serializable{
	
	private static final long serialVersionUID = -1905280777384029726L;
	
	private String name;
	private String description;
	private String id;
	private String type;
	private String iconClass;
	private List<ResourceDTO> subitems;
	
	public ResourceDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public List<ResourceDTO> getSubitems() {
		return subitems;
	}

	public void setSubitems(List<ResourceDTO> subitems) {
		this.subitems = subitems;
	}

	@Override
	public String toString() {
		return "ResourceDTO [name=" + name + ", description=" + description + ", id=" + id + ", type=" + type
				+ ", classIcon=" + iconClass + ", subitems: \n" + subitems + "]";
	}
}
