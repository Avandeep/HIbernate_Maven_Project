package com.hibernate.map.m2m;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	
	@Id
	private int id;
	private String name;
	
	@ManyToMany
	@JoinTable(name="emp_learn",
	joinColumns= {@JoinColumn(name="eid")},
	inverseJoinColumns= {@JoinColumn(name="pid")})
	
	List<Project> projects;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int id, String name, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	

}
