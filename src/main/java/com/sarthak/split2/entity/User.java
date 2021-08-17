package com.sarthak.split2.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


//WORKING: Creating table

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@ManyToMany(mappedBy ="users",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Group> groups;
	
	
	@OneToMany(mappedBy ="user",fetch = FetchType.LAZY )
	private List<Bill> bills; 
	
	
	public void addGroups(Group group) {
		groups.add(group);
	}


	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	//temp
	public List<Group> getGroups() {
		return groups;
	}


	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	//temp
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String name) {
		super();
		this.name = name;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
