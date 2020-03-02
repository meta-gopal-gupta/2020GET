package com.metacube.training.dao;

import com.metacube.training.model.commands.VehicleCommands;

public interface VehicleDAO {

	public int addVehicle(VehicleCommands vehicleCommands);

	public VehicleCommands getVehicle(int id) ;
}
