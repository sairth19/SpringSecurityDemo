package com.marmed.demo.data.dto;

import java.io.Serializable;
import java.util.List;

public class ResourceDTO implements Serializable{
	
	private static final long serialVersionUID = -1905280777384029726L;
	
	private Long id;
	private String code;
	private String name;
	private String description;
	private String type;
	private String iconClass;
	private String url;
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
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ResourceDTO [name=" + name + ", description=" + description + ", id=" + id + ", type=" + type
				+ ", classIcon=" + iconClass + ", subitems: \n" + subitems + "]";
	}
}
