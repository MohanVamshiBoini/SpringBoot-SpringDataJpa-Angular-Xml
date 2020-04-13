package com.cap.anurag.dao;

import java.util.List;

import com.cap.anurag.entities.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Integer id);

	Employee create(Employee employee);

	void deleteEmployeeById(Integer id);

	Employee update(Employee employee);

}
