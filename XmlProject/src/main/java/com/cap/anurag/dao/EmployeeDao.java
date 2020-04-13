package com.cap.anurag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.anurag.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
