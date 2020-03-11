package com.metacube.training.service;


import com.metacube.training.model.commands.VehicleCommands;
/**
 * Service contains methods to employee operations
 * @author Gopal Gupta
 *
 */
public interface VehicleService {

	public int addVehicle(VehicleCommands vehicleCommands);
	
	public VehicleCommands getVehicle(int id) ;

}
