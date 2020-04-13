package com.cap.anurag.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.entities.Employee;
import com.cap.anurag.service.EmployeeService;
@RestController
//For mapping
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@PostMapping("/create")
	public ResponseEntity<Boolean> create(@RequestBody Employee employee) {
		System.out.println(employee.getId());
		System.out.println("hey");
		employee = service.addNewEmployee(employee);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}
	@GetMapping("/find/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		return service.getEmployeeById(id);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = service.getEmployees();
		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	@PostMapping("/updating")
	public ResponseEntity<Boolean> updating(@RequestBody Employee employee) {
		employee.setId(employee.getId());
		employee = service.updateEmployee(employee);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
		service.deleteEmployeeById(id);
		return "Deleted";
	}
}
