package com.metacube.training.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.VehicleDAO;
import com.metacube.training.mapper.VehicleMapper;
import com.metacube.training.model.commands.VehicleCommands;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

	private JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_VEHICLE = "select * from vehicledata where employeeId = ?";
	private final String SQL_INSERT_VEHICLE = "insert into vehicledata(vehicleCompanyName,vehicleType,vehicleNumber,employeeId,vehileDiscription) values(?,?,?,?,?)";

	@Autowired
	public VehicleDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addVehicle(VehicleCommands vehicleCommands) {
		return jdbcTemplate.update(SQL_INSERT_VEHICLE, vehicleCommands.getVehicleCompanyName(),vehicleCommands.getVehicleType(),vehicleCommands.getVehicleNumber(),vehicleCommands.getEmployeeId(),vehicleCommands.getVehicleDiscription());
	}

	@Override
	public VehicleCommands getVehicle(int id) {
		try {
            return jdbcTemplate.queryForObject(SQL_FIND_VEHICLE, new Object[] { id }, new VehicleMapper());

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
}
