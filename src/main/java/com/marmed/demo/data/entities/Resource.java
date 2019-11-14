package com.marmed.demo.data.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resources")
@NamedEntityGraph(name = "Resource.menus",
attributeNodes = @NamedAttributeNode("subitems")
)
public class Resource implements Serializable {
	
	private static final long serialVersionUID = 3128109918271826258L;
	
	private String code;
	private String name;
	private String description;
	private String type;
	private String iconClass;
	private String url;
	private Resource parent;
	private Set<Resource> subitems;
	
	public Resource() {}
	
	@Id
	@Column(name = "code", unique = true,nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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
	
	public String getUrl() {
		return url;
	}
	
	@Column(name = "url")
	public void setUrl(String url) {
		this.url = url;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	@OneToMany(mappedBy="parent", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	public Set<Resource> getSubitems() {
		return subitems;
	}
	
	public void setSubitems(Set<Resource> subitems) {
		this.subitems = subitems;
	}

	@Override
	public String toString() {
		return "Resource [code=" + code + ", name=" + name + ", description=" + description + ", type=" + type
				+ ", iconClass=" + iconClass + ", parent=" + parent + ", subitems=" + subitems + "]";
	}
	
	
}
