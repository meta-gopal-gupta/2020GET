package com.metacube.training.model.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeCommands {

	@NotBlank
	private String name;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	@Email(message = "{badEmail}")
	private String email;
	
	@NotBlank 
	@Size(min = 6, max =  20)
	private String password;
	
	@NotBlank 
	@Size(min = 6, max =  20)
	private String confirmPassword;
	
	@NotBlank(message = "Enter without country code") 
	@Size(min = 10, max =  10)
	private String mobileNumber;
	
	@NotBlank
	private String organization;
	
	private Integer id;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
}
