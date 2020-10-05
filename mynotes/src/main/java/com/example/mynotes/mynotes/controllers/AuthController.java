package com.example.mynotes.mynotes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mynotes.mynotes.models.User;
import com.example.mynotes.mynotes.services.CustomUserDetailsService;

@Controller
public class AuthController {
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login () {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("signup");
		
		return modelAndView;
		
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView createNewUser (@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		User userExists = userService.findUserByEmail(user.getEmail());
		
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"Já existe o usuário com este nome");
		}
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("signup");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage","Usuário registrado com sucesso!");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	
}
