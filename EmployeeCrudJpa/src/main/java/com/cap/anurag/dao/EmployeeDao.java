package com.cap.anurag.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cap.anurag.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	//Query annotation is used for user defined methods for implementing 
@Query("select min(salary) from Employee")
	List<Employee> getLowestSalary();

}
