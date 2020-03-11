package com.metacube.training.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.VehicleDAO;
import com.metacube.training.dao.impl.VehicleDAOImpl;
import com.metacube.training.model.commands.VehicleCommands;
import com.metacube.training.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO vehilceDAO;
	
	@Override
	public int addVehicle(VehicleCommands vehicleCommands) {
		return vehilceDAO.save(vehicleCommands).getId();
	}
	
	@Override
	public VehicleCommands getVehicle(int id) {
		return vehilceDAO.findById(id).orElse(null);
	}
}
