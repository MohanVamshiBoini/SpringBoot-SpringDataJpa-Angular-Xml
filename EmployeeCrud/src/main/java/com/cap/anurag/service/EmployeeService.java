package com.cap.anurag.service;

import java.util.List;

import com.cap.anurag.entities.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Integer id);

	Employee create(Employee employee);

	void deleteEmployeeById(Integer id);

	Employee update(Employee employee);


}
