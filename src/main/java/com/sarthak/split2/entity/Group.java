package com.sarthak.split2.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="groups")
public class Group {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long g_id;
	
	private String name;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinTable(name = "users_groups", joinColumns={@JoinColumn(name="gid")}, inverseJoinColumns={@JoinColumn(name="uid")  } )
	@JsonIgnore
	private List<User> users;
	
	@OneToMany(mappedBy ="group",fetch = FetchType.LAZY )
	private List<Bill> bills;
	

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Group(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	
	public void addUser(User user) {
		
		users.add(user);
		
	}
	

	public long getG_id() {
		return g_id;
	}

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

	
	///temporary
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	////temporary
	
	
	
	
	
	
	

}
