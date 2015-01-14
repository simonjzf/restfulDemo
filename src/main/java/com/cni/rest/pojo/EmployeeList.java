package com.cni.rest.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
public class EmployeeList
{
	private int count;
	private List<Employee> employees;

	public EmployeeList()
	{
	}

	public EmployeeList(List<Employee> employees)
	{
		this.employees = employees;
		this.count = employees.size();
	}

	public int getCount()
	{
		return count;
	}
	
	@XmlElement
	public void setCount(int count)
	{
		this.count = count;
	}

	public List<Employee> getEmployees()
	{
		return employees;
	}

	@XmlElement
	public void setEmployees(List<Employee> employees)
	{
		this.employees = employees;
	}

}
