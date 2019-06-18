package com.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.assessment.models.Country;
import com.assessment.services.CountryService;

@Controller
public class CountryController {

	
	@Autowired
	CountryService conService;
	
	
	@RequestMapping(value="/manageCountry",method=RequestMethod.GET)
	public ModelAndView getManageCountry() {
		
		try {
		ModelAndView mp =new ModelAndView("manageCountry");
		
		Iterable<Country> conList =  conService.findAllCountries();
		mp.addObject("conList", conList);
		return mp;
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	
	@RequestMapping(value="/addCountry",method=RequestMethod.GET)
	public ModelAndView addCountry() {
		
        ModelAndView mp =new ModelAndView("addCountry");
		
		return mp;
	}
	
	@RequestMapping(value="/addCountry",method=RequestMethod.POST)
	public String addOrganizationInfo(@RequestParam("name") String name,RedirectAttributes attr) {
		
		try {
		Country con = new Country();
		con.setName(name);
		Country newcon = conService.createCountry(con);
		
        attr.addFlashAttribute("msg","Country added successfully!!!!");
		return "redirect:/manageCountry";
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
		
	}
	

	@RequestMapping(value="/deleteCountry/{id}",method=RequestMethod.GET)
	public String deleteCountryInfo(@PathVariable(value="id") String id,RedirectAttributes attr) {
		
		try {
		Country con = new Country();
		con.setId(Integer.parseInt(id));
		conService.deleteCountry(con);
		attr.addFlashAttribute("msg","Country deleted successfully!!!!");
		
		return "redirect:/manageCountry";
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	
	
	@RequestMapping(value="/updateCountry/{id}",method=RequestMethod.GET)
	public ModelAndView editCountry(@PathVariable(value="id") String id) {
		
		try {
		Country con =  conService.getCountryInfo(Integer.parseInt(id));
		ModelAndView mp =new ModelAndView("editCountry");
		mp.addObject("con", con);
		
		return mp;
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	@RequestMapping(value="/updateCountry",method=RequestMethod.POST)
	public String updateOrganizationInfo(@RequestParam("id") String id,@RequestParam("name") String name,RedirectAttributes attr) {
		
		try {
		Country con = conService.getCountryInfo(Integer.parseInt(id));
		con.setName(name);
		Country newcon = conService.createCountry(con);
		attr.addFlashAttribute("msg","Country updated successfully!!!!");
		
		return "redirect:/manageCountry";
		}
		catch(Exception ex) {
			System.out.println("Something went wrong!!!!");
			return null;
		}
	}
	
	
	
}