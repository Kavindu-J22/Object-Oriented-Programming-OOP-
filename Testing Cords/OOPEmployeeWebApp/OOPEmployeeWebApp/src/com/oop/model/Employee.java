/**
 * OOP 2018
 * 
 * @author Udara Samaratunge  Department of Software Engineering, SLIIT 
 * 
 * @version 1.0
 * Copyright: SLIIT, All rights reserved
 * 
 */
package com.oop.model;

/**
 * This is the Employee model class
 * 
 * @author Udara Samaratunge, SLIIT
 * @version 1.0
 */
public class Employee {

	private String EmployeeID;
	
	private String Name;

	private String Designation;

	private String FacultyName;

	private String Department;

	private String Address;
	
	private String Qualifications;
	
	private String Gender;

	/**
	 * @return the employeeID
	 */
	public String getEmployeeID() {
		return EmployeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return Designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		Designation = designation;
	}

	/**
	 * @return the facultyName
	 */
	public String getFacultyName() {
		return FacultyName;
	}

	/**
	 * @param facultyName the facultyName to set
	 */
	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return Department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		Department = department;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * @return the qualifications
	 */
	public String getQualifications() {
		return Qualifications;
	}

	/**
	 * @param qualifications the qualifications to set
	 */
	public void setQualifications(String qualifications) {
		Qualifications = qualifications;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		
		return "Employee ID = " + EmployeeID + "\n" + "Emplyee Name = " + Name + "\n" + "Address = " + Address + "\n"
				+ "Faculty Name = " + FacultyName + "\n" + "Department = " + Department + "\n" + "Designation = "
				+ Designation + "\n" + "Qualifications = " + Qualifications + "\n" + "Gender = " + Gender;
	}
}
