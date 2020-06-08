package com.Soriana4All.springbootsorianasystem.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Soriana4All.springbootsorianasystem.domain.User;
import com.Soriana4All.springbootsorianasystem.repositories.UserRepository;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepo;
	
	//methods for index
	@GetMapping("/index")
	public String indexView() {
		return "index";
	}
	
	@GetMapping("/createCustomer")
	public String createCustomerView() {
		return "createCustomer";
	}
	
	@GetMapping("/viewInformation")
	public String viewInformationView() {
		return "viewInformation";
	}

	@GetMapping("/loyalty")
	public String loyalty(Model model) {
		List<User> eligible = userRepo.findAll();
		eligible = eligible.stream().filter(each -> each.getCustomerAge() >= 60).collect(Collectors.toList());		
		
		model.addAttribute("eligibles",eligible);
		
		return "loyalty";
	}
	
	
	//method to retrieve user information and display on page
	@GetMapping("/view")
	public String view(@RequestParam Integer customerId, Model model) {
		
		if(userRepo.existsById(customerId)) {
			model.addAttribute("users",userRepo.findById(customerId).get());
			System.out.println(model.getAttribute("users").toString());
		}
		
		return "viewInformation";
		
	}
	
	
	//method to create customer
	@PostMapping("/crear")
	public String crearUsuario(
			@RequestParam String customerName,
			@RequestParam int customerAge, 
			@RequestParam String customerNumber,
			@RequestParam String customerEmail
 			) {
		
		User user = new User();
		user.setCustomerName(customerName);
		user.setCustomerAge(customerAge);
		user.setCustomerNumber(customerNumber);
		user.setCustomerEmail(customerEmail);
		userRepo.save(user);
		
		return "index";
		
	}
	
	
	
}
