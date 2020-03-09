package com.metacube.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.Signin;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.impl.EmployeeServiceImpl;
/***
 * 
 * @author Gopal
 * Code For HomeController
 *
 */
@Controller
public class HomeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Value("${home.message}")
	private String message;
	@Value("${logout.message}")
	private String logoutMessage;
	@Value("${home.alreadyLogin}")
	private String alreadyLogin;
	@Value("${home.updated}")
	private String updated;
	
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("msg",message);
		return "home";
	}

	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("msg","this is for user");
		return "home";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("msg","this is for admin");
		return "home";
	}

	
	@GetMapping("/logout")
	public String logout(Model model,HttpSession session) {
		if (session.getAttribute("employee") != null) {
			session.removeAttribute("employee");
			session.invalidate();
			model.addAttribute("logoutMessage",logoutMessage);
			return "logout";
		}
		else {
			return "redirect:/signin";
		}
	}
	
	@GetMapping("/signup")
	public String signup(Model model,HttpSession session) {
		if (session.getAttribute("employee") != null) {
			model.addAttribute("msg",alreadyLogin);
			return "home";
		}
		else {
			model.addAttribute("employee",new EmployeeCommands());
			return "signup";
		}
	}

	@PostMapping("/signup")
	public String doSignup(@Validated @ModelAttribute("employee") EmployeeCommands employeeCommands
			,BindingResult bindingResult,Model model) {

		if (bindingResult.hasErrors()) {
			return "signup";
		} else {

			if (employeeCommands.getId() == null) {
				employeeService.addEmpolyee(employeeCommands);
				return "redirect:/signin";
			} else {
				employeeService.updateEmployee(employeeCommands);
				model.addAttribute("msg",updated);
				return "home";
			}
			
		}	
	}
	
	@GetMapping("/signin")
	public String signin(Model model,HttpSession session) {
		if (session.getAttribute("employee") != null) {
			model.addAttribute("msg",alreadyLogin);
			return "home";
		}
		else {
			model.addAttribute("signin",new Signin());
			return "signin";
		}
		
	}
	
	@PostMapping("/signin")
	public String doSignin(@Validated @ModelAttribute("signin") Signin signin,
			BindingResult bindingResult,HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "signin";
		} else {
			boolean isUserValid = createSession(signin,session);
			if(isUserValid) {
				return "redirect:/addVehicle";
			}
			return "redirect:/home";
		}	
	}
	private boolean createSession(Signin signin,HttpSession session) {
		EmployeeCommands employee = employeeService.isValidUser(signin);
		if(employee!=null) {
			session.setAttribute("employee", employee);
			return true;
		}
		return false;
	}
}
