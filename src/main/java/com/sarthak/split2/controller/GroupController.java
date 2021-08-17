package com.sarthak.split2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.split2.entity.Group;
import com.sarthak.split2.entity.User;
import com.sarthak.split2.repository.GroupRepository;
import com.sarthak.split2.repository.UserRepository;
import com.sarthak.split2.service.BillService;
import com.sarthak.split2.service.GroupService;
import com.sarthak.split2.service.Users_groupsService;



@RestController
@RequestMapping("/groups")
public class GroupController {
	
	@Autowired
	GroupService service;
	
	
	@Autowired
	BillService billService;
	
	
	
	
	
	@Autowired
	Users_groupsService usergroupService;
	
	
	@PostMapping("/create")
	public Group create(@RequestBody Group group) {
		
		return service.save(group);
	}
	
	
	@PostMapping("/{groupid}/update")
	public Group update(@RequestBody Group group) {
		
		return service.save(group);
	}
	
	
	@RequestMapping("/{groupid}/delete")
	public String delete(
			@PathVariable long groupid) {
		
		return service.delete(groupid);
	}
	
	@RequestMapping("/read/{groupid}")
	public Optional<Group> read(
			@PathVariable Long groupid){
		return service.findById(groupid);
	}
	
	@RequestMapping("/all")
	public List<Group> readAll(){
		return service.findAll();
	}
	
	
//	@RequestMapping("/test")
//	public Optional<Group> test(){
//		long uid=17,gid=4;
//		
//		 ugService.addUser(uid, gid);
//		 return repo.findById(gid);
//		
//	}
	
	
	
	@RequestMapping("/{groupid}/adduser/{userid}")
	public Group addUser(
			@PathVariable Long groupid,
			@PathVariable Long userid) {
		System.out.println("g>"+groupid+" u>"+userid);
		long u=12,g=2;
		
		return usergroupService.addUser(userid, groupid);
		

	
	}
	
	
	
	@RequestMapping("/{groupid}/splitbill")
	public String calculate(
			@PathVariable long groupid) {
		
		return billService.splitBill(groupid);
		
		
		
		
		
	}
	
		
	
	
	

}
