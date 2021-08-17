package com.sarthak.split2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.split2.entity.Group;
import com.sarthak.split2.entity.User;
import com.sarthak.split2.pojos.Users_groups;
import com.sarthak.split2.repository.GroupRepository;
import com.sarthak.split2.repository.UserRepository;


@Service
public class Users_groupsService {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	GroupRepository groupRepo;
	
	
	
	public Group addUser(Long uid,Long gid) {
		
		try {	
			User user=userRepo.findById(uid).get();
			Group group=groupRepo.findById(gid).get();
			group.addUser(user);
		
		return groupRepo.save(group);
	}
	catch(Exception e) {
	System.out.println(e);;}
		return null;
		
	}

	
	
	
	
	

}
