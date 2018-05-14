package com.ak.skillsclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;

import com.ak.skillsclient.domain.SkillDTO;
import com.ak.skillsclient.domain.SkillNewDTO;
import com.ak.skillsclient.service.SkillService;

@Controller
@RequestMapping("/skills")
public class SkillController {
	
	@Autowired
	private SkillService skillService;

	@ExceptionHandler(HttpClientErrorException.class)
	public String handleAllException(HttpClientErrorException ex, Model model) {
		if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
		model.addAttribute("error", "You have to be logged");
		return "notLoggedIn";
		}
		else {
			return "error";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("skills", skillService.findAllSkills());
        model.addAttribute("newSkill", new SkillDTO());
        return "skills";
    }
	
	 @RequestMapping(value = "/addskill",method = RequestMethod.GET)
	 public String getAddSkill(Model model) {
		 SkillNewDTO newSkill = new SkillNewDTO();
		 model.addAttribute("newSkill", newSkill);
		 return "addSkill";
	 }
	 
	 @RequestMapping(value = "/addskill", method = RequestMethod.POST)
	 public String processAddNewSkill(@ModelAttribute("newSkill") SkillNewDTO newSkill) {
		 skillService.addNewSkill(newSkill.getSkillName());
		 return "redirect:/skills";
	 }
	 
}
