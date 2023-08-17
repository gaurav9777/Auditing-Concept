package com.audit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.dto.InputRequest;
import com.audit.model.Employee;
import com.audit.service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody InputRequest<Employee> request) {
		return employeeService.saveEmployee(request);
	}
	
	@PutMapping("/updateEmployee/{id}/{salary}")
	public String updateEmployee(@PathVariable int id,@PathVariable double salary,@RequestBody InputRequest<Employee> request) {
		return employeeService.updateEmployee(id, salary, request);
	}
}
