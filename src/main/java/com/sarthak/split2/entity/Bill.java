package com.sarthak.split2.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import com.sarthak.split2.entity.Group;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String description;
	
	
	private double amount;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="gid",referencedColumnName = "g_id")
	private Group group;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="payedBy_uid",referencedColumnName = "id")
	private User user;





	public Bill(String description, double amount, Group group, User user) {
		super();
		this.description = description;
		this.amount = amount;
		this.group = group;
		this.user = user;
	}


	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public long getId() {
		return id;
	}
	
	
	
	
	
	
	
}
