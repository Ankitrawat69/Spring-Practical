package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "st_student" )
public class StudentDTO {
	
	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk",strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)
	protected Long id;
	
	@Column(name = "STUDENT_NAME", length = 50)
	private String studentName;
	
	@Column(name = "LOGIN", length = 50)
	private String login;
	
	@Column(name = "PASSWORD",length = 50)
	private String password;
	
	@Column(name = "ADDRESS",length = 50)
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
	
	

	