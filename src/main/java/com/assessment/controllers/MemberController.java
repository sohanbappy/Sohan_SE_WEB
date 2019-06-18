package com.assessment.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.assessment.dao.MemberDao;
import com.assessment.models.Country;
import com.assessment.models.Member;
import com.assessment.services.CountryService;
import com.assessment.services.MemberService;

@Controller
public class MemberController {

	
	@Autowired
	MemberService memService;
	@Autowired
	CountryService conService;
	
	
	@RequestMapping(value="/manageMember",method=RequestMethod.GET)
	public ModelAndView getManageMember() {
		
		try {
		ModelAndView mp =new ModelAndView("manageMember");
		Iterable<Member> memList =  memService.findAllMembers();
		mp.addObject("memberList", memList);
		Iterable<Country> conList =  conService.findAllCountries();
		mp.addObject("conList", conList);
		return mp;
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	
	@RequestMapping(value="/addMember",method=RequestMethod.GET)
	public ModelAndView addMember() {
		try {
        ModelAndView mp =new ModelAndView("addMember");
        Iterable<Country> conList =  conService.findAllCountries();
		mp.addObject("conList", conList);
		return mp;
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	@RequestMapping(value="/addMember",method=RequestMethod.POST)
	public String addOrganizationInfo(@RequestParam("country_id") String country,@RequestParam("name") String name,@RequestParam("dob") String dob,@RequestParam("role") String role,@RequestParam("contact") String contact,RedirectAttributes attr) throws ParseException {
		
		try {
	//age calculation
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        Date now=new Date();
        formatter.format(now); 
        Date temp_dob=formatter.parse(dob);
        int temp_age = Math.abs(now.getYear() - temp_dob.getYear());
        String age = Integer.toString(temp_age);
        
      //check members number already in database
        int registered = 0;
        registered = memService.countMember(country);
        System.out.print(registered);
        
        if(registered<15) {
		Member mem = new Member();
		mem.setCountry(country);
		mem.setName(name);
		mem.setDob(dob);
		mem.setAge(age.toString());
		mem.setRole(role);
		mem.setContact(contact);
		Member newmem = memService.createMember(mem);
		
        attr.addFlashAttribute("msg","Member added successfully!!!!");
        }else {
        attr.addFlashAttribute("msg","Already Registered 15 Members!!!!");
        }
		return "redirect:/";
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
		
	}
	

	@RequestMapping(value="/deleteMember/{id}",method=RequestMethod.GET)
	public String deleteMemberInfo(@PathVariable(value="id") String id,RedirectAttributes attr) {
		
		try {
		Member mem = new Member();
		mem.setId(Integer.parseInt(id));
		memService.deleteMember(mem);
		attr.addFlashAttribute("msg","Member deleted successfully!!!!");
		
		return "redirect:/manageMember";
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	
	
	@RequestMapping(value="/updateMember/{id}",method=RequestMethod.GET)
	public ModelAndView editMember(@PathVariable(value="id") String id) {
		
		try {
		Member mem =  memService.getMemberInfo(Integer.parseInt(id));
		ModelAndView mp =new ModelAndView("editMember");
		Iterable<Country> conList =  conService.findAllCountries();
		mp.addObject("conList", conList);
		mp.addObject("member", mem);
		
		return mp;
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	@RequestMapping(value="/updateMember",method=RequestMethod.POST)
	public String updateOrganizationInfo(@RequestParam("id") String id,@RequestParam("country_id") String country,@RequestParam("name") String name,@RequestParam("dob") String dob,@RequestParam("role") String role,@RequestParam("contact") String contact,RedirectAttributes attr) throws ParseException {
		
		try {
		Member mem = memService.getMemberInfo(Integer.parseInt(id));
		
	//age calculation
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        Date now=new Date();
        formatter.format(now); 
        Date temp_dob=formatter.parse(dob);
        int temp_age = Math.abs(now.getYear() - temp_dob.getYear());
        String age = Integer.toString(temp_age);
        
     
		mem.setCountry(country);
		mem.setName(name);
		mem.setDob(dob);
		mem.setAge(age.toString());
		mem.setRole(role);
		mem.setContact(contact);
		Member newmem = memService.createMember(mem);
        attr.addFlashAttribute("msg","Member updated successfully!!!!");
       
		return "redirect:/manageMember";
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	
	
}