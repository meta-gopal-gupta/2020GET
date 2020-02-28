package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dao.Student;
import com.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Value("${home.message}")
	private String message;
	
	
	@GetMapping({"/","/Home"})
	public String home(Model model) {
		model.addAttribute("msg",message);
		return "Home";
	}
	
	@GetMapping("/Signup")
	public String signup(Model model) {
		model.addAttribute("student",new Student());
		return "Signup";
	}
	@PostMapping("/Signup")
	public String doSignup(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors()) {
			return "Signup";
		}
		else {
			studentService.addStudent(student);
		}
		return "redirect:/Students";	
	}
	
	@GetMapping("/Students")
	public ModelAndView viewStudents() {
		List<Student> students = studentService.getAllStudentList();
		//ModelAndView(String viewName, String modelName, Object modelObject)
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("Students");
		 mav.addObject("students", students);
		return mav;
	}
	
}
