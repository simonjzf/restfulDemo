package com.cni.rest;

import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.client.RestTemplate;

import com.cni.rest.pojo.Employee;

public class RestApiClient {

	private String base;

	public RestApiClient(String url) {
		this.base = url.trim();
		if (this.base.endsWith("/")) {
			this.base = this.base.substring(0, this.base.length() - 1);
		}
	}

	public Collection<Employee> getEmployees() {
		String url = base + "/employees.json";
		RestTemplate restTp = new RestTemplate();
		JSONObject jsonObject = restTp.getForObject(url, JSONObject.class);
		JSONArray jsonArr = jsonObject.getJSONArray("employeeList");
		Collection<Employee> list = JSONArray.toCollection(jsonArr, Employee.class);
		return list;
	}

	public void addEmployee(Employee employee) {
		String url = base.endsWith("/") ? base + "employee.json" : base + "/employee.json";
		RestTemplate restTp = new RestTemplate();
		restTp.postForObject(url, employee, Employee.class);
	}

	public Employee getEmployee(String staffId) {
		String url = base + "/employee/{id}.json";
		RestTemplate restTp = new RestTemplate();
		JSONObject jsonObject = restTp.getForObject(url, JSONObject.class, staffId);
		JSONObject jo = jsonObject.getJSONObject("employee");
		Employee employee = (Employee) JSONObject.toBean(jo, Employee.class);
		return employee;

	}

	public void updateEmployee(Employee employee) {
		String url = base + "/employee/{id}.json";
		RestTemplate restTp = new RestTemplate();
		restTp.put(url, employee, employee.getStaffId());
	}

	public void delete(Employee employee) {
		String url = base + "/employee/{id}.json";
		RestTemplate restTp = new RestTemplate();
		restTp.delete(url, employee.getStaffId());
	}

	public void delete(String id) {
		delete(new Employee(id,null,null));
	}

}
