package com.cap.anurag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.dao.RecordNotFoundException;
import com.cap.anurag.entities.Employee;
import com.cap.anurag.service.EmployeeService;

@RestController
//For mapping
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	//get requests for all employees maps here
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	//get request to find a employee by id maps here
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		Employee entity = service.getEmployeeById(id);
		return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	//post request to insert a employee details map here
	@PostMapping("/create")
	   public ResponseEntity<Boolean> create(@RequestBody Employee employee) {
	        employee = service.create(employee);
	        @SuppressWarnings({ "rawtypes", "unchecked" })
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
	        System.out.println("response entity=" + responseEntity);
	        return responseEntity;
	    }
	//post request to update a employee details map here
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody Employee employee) throws RecordNotFoundException {
		employee = service.update(employee);
		ResponseEntity<Boolean> responseEntity= new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}
	//delete request to delete a employee details map here
	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return "Deleted";
	}
	

}