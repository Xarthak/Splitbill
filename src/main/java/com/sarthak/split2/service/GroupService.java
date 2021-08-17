package com.sarthak.split2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sarthak.split2.entity.Group;
import com.sarthak.split2.repository.GroupRepository;



@Service
public class GroupService {
	
	@Autowired
	GroupRepository repo;
	
	public Group save(Group group) {
		
		return repo.save(group);
	}
	
	
	public String delete(long groupid) {
		
		repo.deleteById(groupid);
		
		String msg="fail";
		if(!(repo.existsById(groupid) )) {
			msg="{'message': 'success'}";
		}
		return msg;
	}
	
	
	public Optional<Group> findById(Long groupid) {
		return repo.findById(groupid);
	}
	
	
	public List<Group> findAll() {
		return repo.findAll();
	}

}
