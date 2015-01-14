package com.cni.rest.pojo;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class Employee {
	@Override
	public boolean equals(Object obj) {
		return getStaffId().equals(((Employee)obj).getStaffId()) &&
				getName().equals(((Employee)obj).getName()) &&
				getEmail().equals(((Employee)obj).getEmail()) ;
	}

	@NotNull
	private String staffId;
	private String name;
	private String email;

	public Employee() {
	}

	public Employee(String staffId, String name, String email) {
		this.staffId = staffId;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "staffId :" + staffId + " name :" + name + " email :" + email;
	}

	public String getStaffId() {
		return staffId;
	}

	@XmlElement
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
}