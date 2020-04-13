package com.cap.anurag.service;

import java.util.List;
import java.util.Optional;
import com.cap.anurag.entities.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();

	Optional<Employee> getEmployeeById(Integer id);

	Employee addNewEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Integer id);

	List<Employee> getLowestSalary();

}
