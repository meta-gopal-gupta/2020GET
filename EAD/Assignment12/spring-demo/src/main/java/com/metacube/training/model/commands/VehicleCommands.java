package com.metacube.training.model.commands;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Vehicle")
public class VehicleCommands {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@NotBlank
	@Column(name="vehicleCompanyName")
	private String vehicleCompanyName;
	
	@Column(name="vehicleType")
	private String vehicleType;

	@NotBlank
	@Column(name="vehicleNumber")
	private String vehicleNumber;

	@NotBlank(message = "Please enter vehicle identification")
	@Column(name="vehicleDiscription")
	private String vehicleDiscription;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	private EmployeeCommands employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicleCompanyName() {
		return vehicleCompanyName;
	}

	public void setVehicleCompanyName(String vehicleCompanyName) {
		this.vehicleCompanyName = vehicleCompanyName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleDiscription() {
		return vehicleDiscription;
	}

	public void setVehicleDiscription(String vehicleDiscription) {
		this.vehicleDiscription = vehicleDiscription;
	}

	public EmployeeCommands getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeCommands employee) {
		this.employee = employee;
	}	
	
	
}
