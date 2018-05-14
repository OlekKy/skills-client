package com.ak.skillsclient.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ak.skillsclient.domain.UserCreatedDTO;
import com.ak.skillsclient.domain.UserNewDTO;
import com.ak.skillsclient.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Skill-Manager website");
		model.addAttribute("tagline", "What would you like to do?");
		return "welcome";
	}

	@RequestMapping(value = "/newaccount", method = RequestMethod.GET)
	public String getNewAccount (Model model) {
		UserNewDTO userNew = new UserNewDTO();
		model.addAttribute("userNew", userNew);
		return "createAcc";
	}
	
	@RequestMapping(value = "/newaccount", method = RequestMethod.POST)
	public String processNewAcc (@ModelAttribute(value="userNew") @Valid UserNewDTO userNew, Model model, BindingResult bres) {
		if(bres.hasErrors()) {
			return "createAcc";
		}
		UserCreatedDTO userCreatedDTO = userService.createNewUser(userNew.getName(), userNew.getEmail());
		model.addAttribute("userFull", userCreatedDTO);
		return "userCreated";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin (Model model) {
		UserCreatedDTO userCreated = new UserCreatedDTO();
		model.addAttribute("userCreated", userCreated);
		return "loginPage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin ( @ModelAttribute(value="userCreated") UserCreatedDTO userCreated ,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("userName",userCreated.getName());
		session.setAttribute("password", userCreated.getPassword());
		return "redirect:/skills";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/";
	}

}
