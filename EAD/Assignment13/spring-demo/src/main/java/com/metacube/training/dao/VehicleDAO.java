package com.metacube.training.dao;

import org.springframework.data.repository.CrudRepository;

import com.metacube.training.model.commands.VehicleCommands;

public interface VehicleDAO extends CrudRepository<VehicleCommands, Integer> {
	
}
