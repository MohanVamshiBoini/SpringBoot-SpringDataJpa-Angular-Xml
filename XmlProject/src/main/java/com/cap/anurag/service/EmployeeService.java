package com.cap.anurag.service;

import java.util.List;
import java.util.Optional;

import com.cap.anurag.entities.Employee;

public interface EmployeeService {

	Employee addNewEmployee(Employee employee);

	Optional<Employee> getEmployeeById(Integer id);

	List<Employee> getEmployees();

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Integer id);

}
