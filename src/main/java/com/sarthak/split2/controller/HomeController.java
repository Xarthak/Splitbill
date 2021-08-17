package com.sarthak.split2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	
	
	@RequestMapping
	public String welcome() {
		return "*******************************\n\t\t\tWELCOME\n**********************************";
	}

}
