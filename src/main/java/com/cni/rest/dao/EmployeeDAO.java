package com.cni.rest.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cni.rest.pojo.Employee;

public class EmployeeDAO {

	private static Map<String, Employee> allEmployees;
	static {
		allEmployees = new HashMap<String, Employee>();
		Employee e1 = new Employee("VBT14608", "Eric.Zhu", "Eric.Zhu@cni.local");
		Employee e2 = new Employee("VBT12825", "Robert.Hu", "Robert.Hu@cni.local");
		allEmployees.put(e1.getStaffId(), e1);
		allEmployees.put(e2.getStaffId(), e2);
	}

	public void add(Employee e) throws Exception {
		Collection<String> ids = allEmployees.keySet();
		for (String id : ids) {
			if (e.getStaffId().equalsIgnoreCase(id)) {
				throw new Exception("Staff id exists!");
			}
		}
		allEmployees.put(e.getStaffId(), e);
	}

	public Employee get(String id) {
		return allEmployees.get(id);
	}

	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		for (Iterator<Employee> it = allEmployees.values().iterator(); it.hasNext();) {
			Employee e = it.next();
			employees.add(e);
		}
		return employees;
	}

	public void remove(String id) {
		allEmployees.remove(id);
	}

	public void update(Employee e) {
		allEmployees.put(e.getStaffId(), e);
	}
}
