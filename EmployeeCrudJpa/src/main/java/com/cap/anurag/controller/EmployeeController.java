package com.cap.anurag.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cap.anurag.entities.Employee;
import com.cap.anurag.exception.RecordNotFoundException;
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
		List<Employee> list = service.getEmployees();
		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}

    //post request to insert a employee details map here
	@PostMapping("/create")
	public ResponseEntity<Boolean> create(@RequestBody Employee employee) {
		employee = service.addNewEmployee(employee);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}

	// post request to update a employee details map here
	@PostMapping("/updating")
	public ResponseEntity<Boolean> updating(@RequestBody Employee employee) {
		employee.setId(employee.getId());
		employee = service.updateEmployee(employee);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}

	// delete request to delete a employee details map here
	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
		service.deleteEmployeeById(id);
		return "Deleted";
	}

    //get request mapping to find the lowest salary in table
	// Uses query
	@GetMapping("/findsalary")
	public ResponseEntity<List<Employee>> getLowestSalary() {
		List<Employee> list = service.getLowestSalary();
		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	//Method with exception handled
	// get request to find a employee by id maps here
	@SuppressWarnings("rawtypes")
	@GetMapping("/find/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Optional optional = service.getEmployeeById(id);
		Boolean check = optional.isPresent();
		if (!check)
			throw new RecordNotFoundException("Enter Valid id");
		return service.getEmployeeById(id);
	}

//Exceptions
    //ControllerLevel Exception
	//If you want to use ApplicationLevel comment this
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "id not present")
	@ExceptionHandler({ Exception.class })
	public void handleException() {

	}
    //Normal Exception
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> userNotFound(RecordNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
