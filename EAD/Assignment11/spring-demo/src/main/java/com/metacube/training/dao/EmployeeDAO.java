package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.commands.EmployeeCommands;

public interface EmployeeDAO {
	
	public EmployeeCommands getEmployeeById(int id);
	
	public int addEmployee(EmployeeCommands employee) ;
	
	public boolean updateEmployee(EmployeeCommands employee) ;

	public EmployeeCommands getEmployeeByAuthentication(String email, String password);
	
	public List<EmployeeCommands> getAllEmployees(String organization);

}
