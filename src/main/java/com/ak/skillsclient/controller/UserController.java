package com.ak.skillsclient.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;

import com.ak.skillsclient.domain.DetailsDTO;
import com.ak.skillsclient.domain.DetailsFullDTO;
import com.ak.skillsclient.domain.DetailsNewDTO;
import com.ak.skillsclient.domain.SaveSkillsRequest;
import com.ak.skillsclient.domain.UserFullDTO;
import com.ak.skillsclient.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
	
	@RequestMapping(value ="/addskills" ,method = RequestMethod.GET)
	public String getSaveSkillsToUser(Model model) {
		SaveSkillsRequest saveSkillsRequest = new SaveSkillsRequest();
		String userId = "";
		String skillsIds = "";
		model.addAttribute("userId", userId);
		model.addAttribute("skillsIds", skillsIds);
		model.addAttribute("saveSkillsRequest", saveSkillsRequest);
		return "addSkillsToUser";
	}
	
	@RequestMapping(value ="/addskills" ,method = RequestMethod.POST)
	public String saveSkillsToUser(@ModelAttribute("userId") String userId, @ModelAttribute("skillsIds") String skillsIds, Model model, UserFullDTO userFullDTO) {
		List<String> list = Arrays.asList(skillsIds.split("\\s"));
		List<Long> skills = new ArrayList<Long>();
		for (String id : list) {
			skills.add(Long.parseLong(id));
		}
		userService.saveSpecifiedSkills(userId, skills);
		return "redirect:/users/alldetails/"+userId;
	}
	
	@RequestMapping(value ="/getdesc" ,method = RequestMethod.GET)
	public String getSearchDesc(Model model) {
		DetailsDTO detailsDTO = new DetailsDTO();
		model.addAttribute("detailsDTO", detailsDTO);
		return "searchDescription";
	}
	
	@RequestMapping(value = "/getdesc", method = RequestMethod.POST)
	public String processSearchDesc(@ModelAttribute("detailsDTO") DetailsDTO detailsDTO) {
		userService.getUserDetails(detailsDTO.getId());
		String id = detailsDTO.getId();
		return "redirect:/users/details/"+id;
	}
	
	@RequestMapping(value ="/details/{id}" ,method = RequestMethod.GET)
	public String showDetails(@PathVariable(value="id") String id, Model model, DetailsDTO detailsDTOs) {
		DetailsDTO detailsDTO = new DetailsDTO();
		detailsDTO = userService.getUserDetails(id);
		model.addAttribute("detailsDTO", detailsDTO);
		return "details";
	}
	
	@RequestMapping(value ="/getuserdetails" ,method = RequestMethod.GET)
	public String getSearchUser(Model model) {
		UserFullDTO userFullDTO = new UserFullDTO();
		model.addAttribute("userFullDTO", userFullDTO);
		return "searchUser";
	}
	
	@RequestMapping(value = "/getuserdetails", method = RequestMethod.POST)
	public String processSearchUser(@ModelAttribute("userFullDTO") UserFullDTO userFullDTO) {
		userService.getByUserId(userFullDTO.getId());
		String id = userFullDTO.getId();
		return "redirect:/users/alldetails/"+id;
	}
	
	@RequestMapping(value ="/alldetails/{id}" ,method = RequestMethod.GET)
	public String showAllUserDetails(@PathVariable(value="id") String id, Model model, DetailsFullDTO detailsFullDTOs) {
		DetailsFullDTO detailsFullDTO = new DetailsFullDTO();
		detailsFullDTO = userService.getByUserId(id);
		model.addAttribute("detailsFullDTO", detailsFullDTO);
		return "allUserDetails";
	}
	
	@RequestMapping(value ="/updatedetails" ,method = RequestMethod.GET)
	public String getUpdateDetails(Model model) {
		DetailsNewDTO detailsNewDTO = new DetailsNewDTO();
		model.addAttribute("detailsNewDTO", detailsNewDTO);
		return "changeDetails";
	}
	
	@RequestMapping(value = "/updatedetails", method = RequestMethod.POST)
	public String processUpdateDetails(@ModelAttribute(value="detailsNewDTO") @Valid DetailsNewDTO detailsNewDTO, BindingResult res) {
		if (res.hasErrors()) {
			return "changeDetails";
		}
		userService.updateDetails(detailsNewDTO);
		return "redirect:/skills";
	}
	
}
