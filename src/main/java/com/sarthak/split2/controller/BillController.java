package com.sarthak.split2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.split2.entity.Bill;
import com.sarthak.split2.service.BillService;

@RestController
@RequestMapping("/user/{userid}/group/{groupid}/bill/")
public class BillController {
	
	
	@Autowired
	BillService billService;
	
	@RequestMapping("/create/{amount}")
	 public ResponseEntity<Bill> createBill(
			 @PathVariable Long userid,
			 @PathVariable Long groupid,
			 @PathVariable Long amount
			) {
		try {
		 String description="Lunch";
		 
		 return new ResponseEntity<Bill>(billService.createBill(description, amount, groupid, userid), HttpStatus.OK);
		// return billService.createBill(description, amount, groupid, userid);
		}
		catch(Exception e) {
			 return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
		}
	 }
	
	
	
	
	
	
	
}
