package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.dao.impl.EmployeeDAOImpl;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.Signin;

@Service
public class EmployeeServiceImpl{

	@Autowired
	private EmployeeDAOImpl employeeDAO;
	
	
	public int addEmpolyee(EmployeeCommands employeeCommands) {
		int i = employeeDAO.addEmployee(employeeCommands);
		return 0;
	}
	
	public EmployeeCommands isValidUser(Signin signin) {
		EmployeeCommands employeeCommands = employeeDAO.getEmployeeByAuthentication(signin.getEmail(),signin.getPassword());
		return employeeCommands;
	}

	public boolean updateEmployee(EmployeeCommands employeeCommands) {
		return employeeDAO.updateEmployee(employeeCommands);
	}

	public List<EmployeeCommands> getAllEmployees(String organization) {
		return employeeDAO.getAllEmployees(organization);
	}

}
