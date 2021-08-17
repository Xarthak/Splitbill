package com.sarthak.split2.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.split2.entity.Bill;
import com.sarthak.split2.entity.Group;
import com.sarthak.split2.entity.User;
import com.sarthak.split2.pojos.UserAmount;
import com.sarthak.split2.pojos.Users_groups;
import com.sarthak.split2.repository.BillRepository;
import com.sarthak.split2.repository.GroupRepository;
import com.sarthak.split2.repository.UserRepository;
import com.sarthak.split2.service.BillService;

@RestController
@RequestMapping("/test")
public class testController {
	
	@Autowired
	BillService billService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	GroupRepository groupRepo;
	
	@Autowired
	BillRepository billRepo;
	
//	@RequestMapping("1")
//	public List<User> test() {
//		Group group;
//		long gid=2;
////		group=groupRepo.findById(gid).get();
////		
////		return billRepo.findBygroup(gid);
//		
//		return billService.splitBill((long)2);
//		
//	}
	
	
	@RequestMapping("2")
	public List<UserAmount> test2() {
		
		
		
		 List<UserAmount> list= billRepo.getlist2(2);
		 for(int i=0;i<list.size();i++){
			    System.out.println(list.get(i));
			}
			System.out.println("size> "+list.size());
			return list;
		
	}
	
	@RequestMapping("2/2")
	public List<Users_groups> test2_2() {
		System.out.println();
		List<Users_groups> list= billRepo.getusergroup();
		System.out.println("hello");
		for(int i=0;i<list.size();i++){
		    System.out.println(list.get(i));
		}
		System.out.println("size> "+list.size());
		return list;
		
	}
	
	
	@RequestMapping("3")
	public List<Bill> test3() {
		
		return billRepo.findBydes("Lunch");
		
		//return billRepo.findAll();
		
	}
	
	@RequestMapping("4")
	public List<Bill> test4() {
		
		long uid=13;
		return billRepo.findByuser(uid);
		
		//return billRepo.findAll();
		
	}

}
