package com.vr.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vr.entities.Cart;
import com.vr.entities.Customer;
import com.vr.entities.User;
import com.vr.repositories.CartRepository;
import com.vr.repositories.CustomerRepository;
import com.vr.repositories.UserRepository;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CartRepository cartRepo;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getLoginForm() {
		return "index";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String getNewCustomerForm() {
		return "newcustomer";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String getSignupForm( @ModelAttribute User user, BindingResult errors) {
		return "signup";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") User user, Model model, RedirectAttributes redirectAttributes) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		User check = userRepo.findByUsername(username);
		if(check!=null && check.getUsername().equals(username)&&check.getPassword().equals(password)) {
			return "redirect:/home";
		}
		redirectAttributes.addFlashAttribute("message", "Failed");
	    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		model.addAttribute("invalidCredentials", true);
		return "redirect:/";
	}
	
	@RequestMapping(value="/signupVer", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute User user, BindingResult errors) {
		if(errors.hasErrors()) {
			return "signup";
		}else {
			userRepo.save(user);
			return "redirect:/";
		}
	}
	
	@GetMapping("/home")
	public String showPage(Model model) {
		model.addAttribute("data", custRepo.
				findAll());
		return "home2";
	}
	
	@PostMapping("/save")
	public String save(Customer c, Cart ca) {
		c.setCart(ca);
		ca.setCustomer(c);
		custRepo.save(c);
		return "redirect:/home";
	}

	@PostMapping("/edit")
	public String edit(Customer c, Integer id) {
		Cart ca = cartRepo.findById(id).orElse(null);
		c.setCart(ca);
		ca.setCustomer(c);
		custRepo.save(c);
		return "redirect:/home";
	}
	@GetMapping("/delete")
	public String deleteCustomer(Integer id) {
		custRepo.deleteById(id);
		return "redirect:/home";
	}
	
	@GetMapping("/findOne")
	public String findOne(Integer id,Model model) {
		model.addAttribute("data", custRepo.findById(id).orElse(null));
		model.addAttribute("cartdata", cartRepo.findById(id+1).orElse(null));
		return "editcustomer";
	}
	
	@GetMapping("/search")
	public String searchCustomer(String keyword, Model model) {
		if(keyword != null) {
			model.addAttribute("data", custRepo.
					findByKeyword(keyword));
		}
		return "home2";
	}
	
}
