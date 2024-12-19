package com.gearing.hellohuman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloHumanController {
	
	@GetMapping("")
	public String index(@RequestParam(required=false) String fname, @RequestParam(required=false) String lname, @RequestParam(required = false) String times) {
		int count = 1;
		String messageString = "";
		if(times != null && isNumber(times))
			count = Integer.parseInt(times);
		
		for(int i = 0;  i < count; i++) {
			if(fname == null)
				messageString += "Hello Human ";
			else if(lname == null)
				messageString += "Hello " + fname + " ";
			else
				messageString += "Hello " + fname + " " + lname + " ";
		}
		return messageString;
	}
	
	public static boolean isNumber(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
}
