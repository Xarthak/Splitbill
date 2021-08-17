package com.sarthak.split2.controller;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.websocket.PojoHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.split2.entity.User;
import com.sarthak.split2.repository.UserRepository;
import com.sarthak.split2.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository testrepo;
	
	
	
	
	@GetMapping("/all")
	public List<User> getAll() {
		
		return userService.getAll();
	}
	

	@PostMapping("/create")
	@ResponseBody
public User create(@RequestBody User user ) {
		
		return userService.save(user);
	}
	
	
	@PutMapping("/update")
	@ResponseBody
public User update(@RequestBody User user ) {
		
		return userService.update(user);
	}
	
	
	@GetMapping("/{userid}")
	public Optional<User> read(
			@PathVariable long userid) {
		
		
		return userService.read(userid);
	}
	
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody User user) {
		
		return userService.delete(user);
	}
	
	
	@GetMapping("/test")
	public List<User> test(@RequestBody User user){
		
		System.out.println(user.getName());
		
		return testrepo.findByName(user.getName());
	}
	
	
	
	@GetMapping("/groups")
	public void getGroups() {
		
	}
	
	
	

	
	
	
	

}
