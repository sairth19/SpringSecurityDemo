package com.marmed.demo.data.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resources")
public class Resource implements Serializable {
	
	private static final long serialVersionUID = 3128109918271826258L;
	
	private String id;
	private String name;
	private String description;
	private String type;
	private String iconClass;
	private Resource parent;
	private Set<Resource> subitems;
	
	public Resource() {}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Id
	@Column(name = "resource_id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "icon_class")
	public String getIconClass() {
		return iconClass;
	}
	
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	@OneToMany(mappedBy="parent", cascade = CascadeType.PERSIST)
	public Set<Resource> getSubitems() {
		return subitems;
	}
	
	public void setSubitems(Set<Resource> subitems) {
		this.subitems = subitems;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type
				+ ", iconClass=" + iconClass + ", parent=" + parent + ", subitems=" + subitems + "]";
	}
	
	
}
