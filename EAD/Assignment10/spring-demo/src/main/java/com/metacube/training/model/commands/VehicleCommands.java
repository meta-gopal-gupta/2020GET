package com.metacube.training.model.commands;

import javax.validation.constraints.NotBlank;

public class VehicleCommands {

	@NotBlank
	private String vehicleCompanyName;
	
	@NotBlank
	private String vehicleType;
	
	@NotBlank
	private String vehicleNumber;
	
	@NotBlank 
	private String employeeId;
	
	@NotBlank 
	private String vehicleDiscription;
	
	private Integer id;

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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getVehicleDiscription() {
		return vehicleDiscription;
	}

	public void setVehicleDiscription(String vehicleDiscription) {
		this.vehicleDiscription = vehicleDiscription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
