/**
 * OOP 2018
 * 
 * @author Udara Samaratunge  Department of Software Engineering, SLIIT 
 * 
 * @version 1.0
 * Copyright: SLIIT, All rights reserved
 * 
 */
package com.oop.service;

import com.oop.model.Employee;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

/**
 * Contract for the implementation of Employee Service .
 * 
 * @author Udara Samaratunge, SLIIT
 * @version 1.0
 */
public interface IEmployeeService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IEmployeeService.class.getName());


	/**
	 * Add employees for employee table
	 * @param employee
	 */
	public void addEmployee(Employee employee);

	/**
	 * Get a particular Employee
	 * 
	 * @param empoyeeID
	 * @return Employee
	 */
	public Employee getEmployeeByID(String empoyeeID);
	
	/**
	 * Get all list of employees
	 * 
	 * @return ArrayList<Employee>
	 */
	public ArrayList<Employee> getEmployees();
	
	/**
	 * Update existing employee
	 * @param employeeID
	 * @param employee
	 * 
	 * @return
	 */
	public Employee updateEmployee(String employeeID, Employee employee);

	/**
	 * Remove existing employee
	 * 
	 * @param employeeID
	 */
	public void removeEmployee(String employeeID);

}
