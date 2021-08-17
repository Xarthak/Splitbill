package com.sarthak.split2.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.split2.entity.User;
import com.sarthak.split2.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	
	
	
	
	
	public List<User> getAll() {
		
		
		return repo.findAll();
		
	}
	
	
	
	public User save(User user) {
		
		return repo.save(user);
		
	}
	
	
public User update(User user) {
		
		return repo.save(user);
		
	}
	
	
	public String delete(User user) {
		
		
		 repo.delete(user);
		 return "message:success";
		
	}
	
	
	public Optional<User> read(long id) {
		 
		Optional<User> ulist= repo.findById(id);
		return ulist;
	}
	
	
	
}
