package com.hibernate.map.m2m;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	private int pId;
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany(mappedBy="projects")
	List<Emp> empNames;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int pId, String projectName, List<Emp> empNames) {
		super();
		this.pId = pId;
		this.projectName = projectName;
		this.empNames = empNames;
	}

	public int getPId() {
		return pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmpNames() {
		return empNames;
	}

	public void setEmpNames(List<Emp> empNames) {
		this.empNames = empNames;
	}
	
	

}
