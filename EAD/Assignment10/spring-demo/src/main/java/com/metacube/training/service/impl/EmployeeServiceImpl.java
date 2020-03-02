package com.metacube.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.Signin;
import com.metacube.training.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@Override
	public int addEmpolyee(EmployeeCommands employeeCommands) {
		employeeDAO.addEmpolyee(employeeCommands);
		return 0;
	}
	
	@Override
	public EmployeeCommands isValidUser(Signin signin) {
		EmployeeCommands employeeCommands = employeeDAO.getEmployeeByAuthentication(signin.getEmail(),signin.getPassword());
		return employeeCommands;
	}

	@Override
	public EmployeeCommands getEmpolyee(int id) {
		return employeeDAO.getEmpolyee(id);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public boolean updateEmployee(EmployeeCommands employeeCommands) {
		
		return employeeDAO.updateEmployee(employeeCommands);
	}

	@Override
	public List<EmployeeCommands> getAllEmployees(String organization) {
		return employeeDAO.getAllEmployees(organization);
	}

}
