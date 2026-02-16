
package com.rays.form;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRegistrationForm {

	protected Long id = 0L;

	@NotEmpty(message = "firstName is required")
	private String firstName = null;

	@NotEmpty(message = "lastName is required")
	private String lastName = null;

	@NotEmpty(message = "login is required")
	private String login = null;

	@NotEmpty(message = "password is required")
	private String password = null;

	@NotEmpty(message = "dob is required")
	private String dob;

	@NotEmpty(message = "address is required")
	private String address = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
