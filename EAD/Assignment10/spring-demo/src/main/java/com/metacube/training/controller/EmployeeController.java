package com.metacube.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	
/*	@GetMapping("/employees")
	public String employees(Model model) {
		List<EmployeeCommands> employees =  employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		
		return "employees";
	}*/
	
	@GetMapping("/employees")
	public ModelAndView employees( HttpSession session) {
		if (session.getAttribute("employee") != null) {
			EmployeeCommands employee = (EmployeeCommands)session.getAttribute("employee");
			List<EmployeeCommands> employees =  employeeService.getAllEmployees(employee.getOrganization());
			
			return new ModelAndView("employees","employees",employees);
		}
		else {
			return new ModelAndView("redirect:/signin");
		}
	}
	
	
	

	@GetMapping("/update")
	public ModelAndView update(HttpSession session) {
		if (session.getAttribute("employee") != null) {
			EmployeeCommands employee = (EmployeeCommands)session.getAttribute("employee");
			return new ModelAndView("signup","employee",employeeService.getEmpolyee(employee.getId()));
		}
		return new ModelAndView("redirect:/signin");
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
			employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}

}
