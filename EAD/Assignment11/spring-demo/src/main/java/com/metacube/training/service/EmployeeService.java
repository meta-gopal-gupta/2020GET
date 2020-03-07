package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.Signin;
/**
 * Service contains methods to employee operations
 * @author Gopal Gupta
 *
 */
public interface EmployeeService {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addEmpolyee(EmployeeCommands employeeCommands);


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
	List<EmployeeCommands> getAllEmployees(String organization);

	EmployeeCommands isValidUser(Signin signin);


}
