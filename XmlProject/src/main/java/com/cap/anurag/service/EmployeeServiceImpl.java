package com.cap.anurag.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.EmployeeDao;
import com.cap.anurag.entities.Employee;

@Service // @Component
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee addNewEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return dao.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		dao.deleteById(id);

	}
}
