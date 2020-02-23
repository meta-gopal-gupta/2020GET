package com.springmvc.dao;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Gopal
 * Studnent POJO class
 */
public class Student {

	@NotBlank(message = "Name can not be empty")
	private String firstName;
	
	@NotBlank
	private String lastName ;
	
	@NotBlank
	private String fatherName;
	
	@NotNull @Min(1) @Max(24)
	private Integer className;
	
	@NotNull(message = "{badAge}") @Min(1) @Max(100)
	private Integer age;
	
	@NotBlank
	@Email(message = "{badEmail}")
	private String email;
	
	private Integer id;
	


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Integer getClassName() {
		return className;
	}

	public void setClassName(Integer className) {
		this.className = className;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
