package com.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assessment.models.Country;
import com.assessment.models.Member;
import com.assessment.services.CountryService;
import com.assessment.services.MemberService;


@Controller
public class HomeController {

	@Autowired
	CountryService conService;
	@Autowired
	MemberService memService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		try {
		return "index";
		}
		catch(Exception ex) {
			System.out.println("Failed to connect DB !!!!!!");
			return null;
		}
	}
	
	@RequestMapping(value="/error",method=RequestMethod.GET)
	public String error() {
		return "error";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView getLoginInfo(@RequestParam("uname") String uname,@RequestParam("pass") String password) {
		ModelAndView mp;
		try {
		if(uname.equalsIgnoreCase("bappy") && password.equalsIgnoreCase("1234")) {
		mp =new ModelAndView("manageMember");
		Iterable<Member> memList =  memService.findAllMembers();
		mp.addObject("memberList", memList);
		Iterable<Country> conList =  conService.findAllCountries();
		mp.addObject("conList", conList);
		mp.addObject("user", uname);
		return mp;
		}
		else {
	    mp =new ModelAndView("error");
	    mp.addObject("msg", "Incorrect Credentials!!!!");
	    return mp;
		}
	  }
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	
}
