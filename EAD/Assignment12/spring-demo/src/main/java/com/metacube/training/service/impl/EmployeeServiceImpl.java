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
	private EmployeeDAO employeeDAO;
	
	
	public int addEmpolyee(EmployeeCommands employeeCommands) {
		EmployeeCommands employee = employeeDAO.save(employeeCommands);
		return employee.getId();
	}
	
	public EmployeeCommands isValidUser(Signin signin) {
		EmployeeCommands employeeCommands = employeeDAO.findByEmailAndPassword(signin.getEmail(), signin.getPassword());
		return employeeCommands;
	}

	public boolean updateEmployee(EmployeeCommands employeeCommands) {
		return employeeDAO.save(employeeCommands) != null;
	}

	public List<EmployeeCommands> getAllEmployees(String organization) {
		return employeeDAO.findAllByOrganization(organization);
	}

}
