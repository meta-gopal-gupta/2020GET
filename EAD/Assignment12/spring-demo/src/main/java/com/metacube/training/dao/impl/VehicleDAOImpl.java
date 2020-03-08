package com.metacube.training.dao.impl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.commands.VehicleCommands;


@Repository
public class VehicleDAOImpl {

	@Autowired
	private EntityManager entityManager;
	
	public int addVehicle(VehicleCommands vehicle) {
		Session session = entityManager.unwrap(Session.class);
		System.out.println(vehicle);
		session.save(vehicle);
		System.out.println("Vehicle Id : " + vehicle.getId());
		return vehicle.getId();
	}

	
	public VehicleCommands getVehicle(int id) {
		Session session = entityManager.unwrap(Session.class);
		try {
            return session.get(VehicleCommands.class, id);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

}
