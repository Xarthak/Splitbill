package com.sarthak.split2.pojos;

import org.springframework.stereotype.Component;

@Component
public class Users_groups {
	
	private long uid;
	
	public String des;
	
	private long gid;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getGid() {
		return gid;
	}

	public void setGid(long gid) {
		this.gid = gid;
	}

	public Users_groups(long uid, String des) {
		super();
		this.uid = uid;
		this.des = des;
	}

	public Users_groups() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
//	public users_groups() {
//		
//	}
//	
//	
//	
//	
//	public  users_groups(long uid,long gid) {
//		
//		this.uid=uid;
//		this.gid=gid;
//		
//	}
//	

	
	
	
	
	
	
}
