package com.cni.rest.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cni.rest.dao.EmployeeDAO;
import com.cni.rest.pojo.Employee;
import com.cni.rest.pojo.EmployeeList;

@Controller
public class EmployeeAction {
	private static EmployeeDAO employeeDAO = null;
	static {
		employeeDAO = new EmployeeDAO();
	}

	// Get Employee info support both HTML or RESTClient
	@RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
	public String getEmployee(Model model, @PathVariable String id) {
		Employee employee = employeeDAO.get(id);
		if (employee != null) {
			model.addAttribute("employee", employee);
		}
		return "employee";
	}

	// HTML path to new Employee info support both HTML or RESTClient
	@RequestMapping(method = RequestMethod.GET, value = "/employee")
	public String addEmployee(Model model) throws Exception {
		model.addAttribute("employee", new Employee());
		return "newEmployee";
	}

	// public String addEmployee(Model model, @RequestBody Employee employee)
	// throws Exception {
	// New Employee support both HTML or RESTClient by POST
	@RequestMapping(method = RequestMethod.POST, value = "/employee", headers = "Accept=application/html, application/xhtml+xml")
	public String addEmployee(Model model, Employee employee) throws Exception {
		if (employee != null && employee.getStaffId() != null && !employee.getStaffId().trim().isEmpty()) {
			employeeDAO.add(employee);
			model.addAttribute("employee", employee);
			return "redirect:/content/employee/" + employee.getStaffId();
		}

		return "newEmployee";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee", headers = "Accept=application/xml, application/json")
	public String addEmployeeJSON(Model model, @RequestBody Employee employee) throws Exception {
		return addEmployee(model, employee);
	}

	// HTML path to update Employee info support both HTML or RESTClient
	@RequestMapping(method = RequestMethod.GET, value = "/employee/{id}/edit")
	public String updateEmployee(Model model, @PathVariable String id) throws Exception {
		Employee employee = employeeDAO.get(id);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}

	// Update Employee support both HTML by POST
	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}/edit", headers = "Accept=application/html, application/xhtml+xml")
	public String updateEmployee(Model model, Employee employee, @PathVariable String id) throws Exception {
		if (employee != null && employee.getStaffId() != null && !employee.getStaffId().trim().isEmpty()) {
			employeeDAO.update(employee);
			model.addAttribute("employee", employee);
			return "redirect:/content/employee/" + employee.getStaffId();
		}

		return "updateEmployee";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}", headers = "Accept=application/xml, application/json")
	public String updateEmployeeJSON(Model model, @RequestBody Employee employee, @PathVariable String id) throws Exception {
		return updateEmployee(model, employee, id);
	}

	// Delete Employee support both HTML by DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}", headers = "Accept=application/xml, application/json")
	public String removeEmployeeJSON(@PathVariable String id) {
		if (employeeDAO.get(id) != null) {
			employeeDAO.remove(id);
			return "redirect:/content/employees";
		}
		return "employeeList";
	}

	// List All Employee info support both HTML or RESTClient
	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public String getEmployees(Model model) {
		List<Employee> employees = employeeDAO.getAll();
		EmployeeList list = new EmployeeList(employees);
		model.addAttribute("employeeList", list.getEmployees());
		return "employeeList";
	}

}
