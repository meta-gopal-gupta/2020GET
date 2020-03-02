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
import com.metacube.training.model.commands.VehicleCommands;
import com.metacube.training.service.VehicleService;

@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@Value("${home.vehicleAdded}")
	private String vehicleAdded;
	
	@GetMapping("/addVehicle")
	public String addVehicle(Model model,HttpSession session) {
		if (session.getAttribute("employee") == null) {
			return "redirect:/signin";
		}
		else {
			EmployeeCommands employee = (EmployeeCommands)session.getAttribute("employee");
			VehicleCommands vehicle = vehicleService.getVehicle(employee.getId());
			if(vehicle == null) {
				model.addAttribute("vehicle",new VehicleCommands());
				return "addVehicle";
			}
			else {
				return "redirect:/pass";
			}
		}
	}

	@PostMapping("/addVehicle")
	public String postAddVehicle(@Validated @ModelAttribute("vehicle") VehicleCommands vehicleCommands,
			Model model,BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addVehicle";
		} else {
			vehicleService.addVehicle(vehicleCommands);
			model.addAttribute("msg",vehicleAdded);
			return "home";
		}
	}
	@GetMapping({"/pass"})
	public String home(Model model,HttpSession session) {
		if (session.getAttribute("employee") == null) {
			return "redirect:/signin";
		}
		else {
			model.addAttribute("vehicleType","Car");
			return "pass";
		}
		
	}
}
