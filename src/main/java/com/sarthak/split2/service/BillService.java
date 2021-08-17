package com.sarthak.split2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sarthak.split2.entity.Bill;
import com.sarthak.split2.entity.Group;
import com.sarthak.split2.entity.User;
import com.sarthak.split2.pojos.UserAmount;
import com.sarthak.split2.repository.BillRepository;
import com.sarthak.split2.repository.GroupRepository;
import com.sarthak.split2.repository.UserRepository;

@Service
public class BillService {
	
	@Autowired 
	BillRepository billRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	GroupRepository groupRepo;
	
	HashMap<Long, Double> amountMap=new HashMap<Long, Double>();
	
	
	public Bill createBill(String description,long amount,long gid,long uid) {
		
		Bill bill=new Bill();
		Group group=groupRepo.findById(gid).get();
		User user=userRepo.findById(uid).get();
		
		bill.setDescription(description);
		bill.setAmount(amount);
		bill.setGroup(group);
		bill.setUser(user);
		return billRepo.save(bill);
		
		//return billRepo.getById((long)12);
		
	}
	
	
	public String splitBill(long gid) {
		
		
		List<UserAmount> ulist=billRepo.getlist2(gid);
		System.out.println("size>"+ulist.size());
		for(int i=0;i<ulist.size();i++){
			System.out.println(ulist.get(i));
		}
		
		
		
		
		
		
		for(int i=0;i<ulist.size();i++){

			long key=ulist.get(i).id;
			if(amountMap.containsKey(key))
			{
				amountMap.put(key , (amountMap.get(key) + ulist.get(i).amount) );
			}
			else
			{
				amountMap.put(ulist.get(i).id , ulist.get(i).amount );
			}
		}
		System.out.println( amountMap.values().stream().mapToDouble(i->i).sum());
		double average=amountMap.values().stream().mapToDouble(i->i).sum()/amountMap.size();
		
		for (long key : amountMap.keySet()) {
			
			amountMap.put(key , (amountMap.get(key)-average) );
		}
		
		System.out.println("average>"+average);
		String msg="";
		 for(Map.Entry entry : amountMap.entrySet())
		 {
			 msg+=entry.getKey()+" value> "+ entry.getValue()+"\n";
			 System.out.println(entry.getKey()+" value> "+ entry.getValue());
			 
		 }
		 
		
		
			   return msg;
			
		 
				 
		
		 
		 
		  
		//return null;
		
		
	}
	

}
