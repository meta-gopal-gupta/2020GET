package com.metacube.training.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.commands.EmployeeCommands;


@Repository
public class EmployeeDAOImpl{

	@Autowired
	private EntityManager entityManager;
	
	public EmployeeCommands getEmployeeById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<EmployeeCommands> query = session.createQuery("from EmployeeCommands where id = :empId", EmployeeCommands.class);
		query.setParameter("empId", id);
		EmployeeCommands employee = query.getSingleResult();
		return employee;
	}
	public int addEmployee(EmployeeCommands employee) {
		Session session = entityManager.unwrap(Session.class);
		session.save(employee);
		System.out.println("Employee Id : " + employee.getId());
		return employee.getId();
	}

	public boolean updateEmployee(EmployeeCommands employee) {
		Session session = entityManager.unwrap(Session.class);
		session.update(employee);
		System.out.println("Employee Id : " + employee.getId());
		return true;
	}


	public EmployeeCommands getEmployeeByAuthentication(String email, String password) {		
		Session session = entityManager.unwrap(Session.class);
		Query<EmployeeCommands> query = session.createQuery("from EmployeeCommands where email = :email AND password = :password ", EmployeeCommands.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
            return query.getSingleResult();

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	public List<EmployeeCommands> getAllEmployees(String organization) {
		Session session = entityManager.unwrap(Session.class);
		Query<EmployeeCommands> query = session.createQuery("from EmployeeCommands where organization = :organization ", EmployeeCommands.class);
		query.setParameter("organization",organization );
		List<EmployeeCommands> friends = query.getResultList();
		return friends;
	}
}
