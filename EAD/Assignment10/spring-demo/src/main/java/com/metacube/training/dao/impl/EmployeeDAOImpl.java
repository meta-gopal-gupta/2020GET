package com.metacube.training.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.commands.EmployeeCommands;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_USER = "select * from user where id = ?";
	private final String SQL_FIND_USER_BY_AUTHENTICATION = "select * from user where email = ? and password = ?";
	private final String SQL_DELETE_USER = "delete from user where id = ?";
	private final String SQL_UPDATE_USER = "update user set name = ?, email = ?, password  = ? where id = ?";
	private final String SQL_GET_ALL = "select * from user where organization = ?";
	private final String SQL_INSERT_USER = "insert into user(name,email,mobile,password,gender,organization) values(?,?,?,?,?,?)";

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addEmpolyee(EmployeeCommands employeeCommands) {
		return jdbcTemplate.update(SQL_INSERT_USER, employeeCommands.getName(), employeeCommands.getEmail(),
				employeeCommands.getMobileNumber(),employeeCommands.getPassword(),employeeCommands.getGender(),
				employeeCommands.getOrganization());
	}

	@Override
	public EmployeeCommands getEmpolyee(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { id }, new EmployeeMapper());
	}
	@Override
	public EmployeeCommands getEmployeeByAuthentication(String email, String password) {		
		try {
            return jdbcTemplate.queryForObject(SQL_FIND_USER_BY_AUTHENTICATION, new Object[] {email,password}, new EmployeeMapper());

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	
	@Override
	public boolean deleteEmployee(int id) {
		return jdbcTemplate.update(SQL_DELETE_USER, id) > 0;
	}

	@Override
	public boolean updateEmployee(EmployeeCommands employeeCommands) {
		return jdbcTemplate.update(SQL_UPDATE_USER, employeeCommands.getName(), employeeCommands.getEmail(),
				employeeCommands.getPassword(), employeeCommands.getId()) > 0;
	}

	@Override
	public List<EmployeeCommands> getAllEmployees(String organization) {
		return jdbcTemplate.query(SQL_GET_ALL,new Object[] { organization }, new EmployeeMapper());
	}

}
