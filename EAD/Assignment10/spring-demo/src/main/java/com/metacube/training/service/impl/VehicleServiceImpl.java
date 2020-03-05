package com.metacube.training.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.VehicleDAO;
import com.metacube.training.model.commands.VehicleCommands;
import com.metacube.training.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO vehilceDAO;
	
	@Override
	public int addVehicle(VehicleCommands vehicleCommands) {
		vehilceDAO.addVehicle(vehicleCommands);
		return 0;
	}
	
	@Override
	public VehicleCommands getVehicle(int id) {
		return vehilceDAO.getVehicle(id);
	}
}
