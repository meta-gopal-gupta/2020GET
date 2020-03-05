package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.commands.EmployeeCommands;

public interface EmployeeDAO {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addEmpolyee(EmployeeCommands employeeCommands);

	/**
	 * 
	 * @param id
	 * @return
	 */
	EmployeeCommands getEmpolyee(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteEmployee(int id);

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	boolean updateEmployee(EmployeeCommands employeeCommands);
	
	/**
	 * 
	 * @return
	 */
	public List<EmployeeCommands> getAllEmployees(String organization);

	EmployeeCommands getEmployeeByAuthentication(String email, String password);

}
