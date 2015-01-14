package com.cni.rest;

import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.cni.rest.pojo.Employee;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	private RestApiClient client;
	private Employee testEmployee; 
	protected void setUp() {
		client = new RestApiClient("http://localhost:8080/RestfulDemo/content/");
		testEmployee = new Employee("0329051","Jacky Wong","jacky.wong@cn-innovations.com");
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testListEmployee() {
		Collection<Employee> list = client.getEmployees();
		assertTrue(list != null);
		assertTrue(list.size() > 0);
	}

	public void testAddEmployee() {
		client.addEmployee(testEmployee);
		Employee result = client.getEmployee(testEmployee.getStaffId());
		assertTrue(result != null);
		assertTrue(testEmployee.equals(result));
	}

	public void testUpdateEmployee() {
		testEmployee.setName("Updated");
		client.updateEmployee(testEmployee);
		Employee result = client.getEmployee(testEmployee.getStaffId());
		assertTrue(result != null);
		assertTrue(testEmployee.equals(result));
	}

	public void testDeleteEmployee() {
		client.delete(testEmployee);
		Employee result = client.getEmployee(testEmployee.getStaffId());
		assertTrue(result == null);
	}

}
