package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.model.commands.VehicleCommands;

public class VehicleMapper implements RowMapper<VehicleCommands> {

	@Override
	public VehicleCommands mapRow(ResultSet resultSet, int i) throws SQLException {

		VehicleCommands vehicle = new VehicleCommands();
		vehicle.setId(resultSet.getInt("id"));
		vehicle.setVehicleCompanyName(resultSet.getString("vehicleCompanyName"));
		vehicle.setVehicleType(resultSet.getString("vehicleType"));
		vehicle.setVehicleNumber(resultSet.getString("vehicleNumber"));
		vehicle.setEmployeeId(resultSet.getString("employeeId"));
		vehicle.setVehicleDiscription(resultSet.getString("vehileDiscription"));
		return vehicle;
	}
}
