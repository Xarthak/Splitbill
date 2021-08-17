package com.sarthak.split2.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class UserAmount {
	
	@Id
	public long id;
	public long gid;
	public double amount;
	
	



	@Override
	public String toString() {
		return "UserAmount [id=" + id + ", gid=" + gid + ", amount=" + amount + "]";
	}


	public UserAmount(long id, long gid, double amount) {
		super();
		this.id = id;
		this.gid=gid;
		this.amount = amount;
	}
	public UserAmount(long id, long gid,String amount) {
		super();
		this.id = id;
		this.gid=gid;
		this.amount=0;
		
	}

	public UserAmount() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
