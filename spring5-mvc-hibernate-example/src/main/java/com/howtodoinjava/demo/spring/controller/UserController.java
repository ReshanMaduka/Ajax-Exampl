package com.howtodoinjava.demo.spring.controller;

import java.util.Locale;

import com.howtodoinjava.demo.spring.dto.CustomerDTO;
import com.howtodoinjava.demo.spring.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.demo.spring.service.UserService;

//@RestController
//@CrossOrigin
//@RequestMapping("api/v1/pendingRequest")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String userForm(Locale locale, Model model) {
		model.addAttribute("users", userService.findAllUsers());
		return "editUsers";
	}
	
	@ModelAttribute("user")
    public CustomerDTO formBackingObject() {
        return new CustomerDTO();
    }

	@PostMapping("/addUser")
	public String saveUser(@ModelAttribute("user") CustomerDTO customerDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", userService.findAllUsers());
			return "editUsers";
		}
		userService.saveUser(customerDTO);
		return "redirect:/";
	}
}
