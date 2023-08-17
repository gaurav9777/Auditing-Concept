package com.audit.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.dao.EmployeeRepository;
import com.audit.dto.InputRequest;
import com.audit.model.Employee;

@Service
public class EmployeeService<T> {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String saveEmployee(InputRequest<Employee> request) {
		String currentUser=request.getLoggedInUser();
		request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
		Employee employee=request.getEmployee();
		
		employee.setCreatedBy(currentUser);
		employeeRepository.save(employee);
		return "Employee saved Successfully... ";
		
	}
	
	public String updateEmployee(int id,double salary,InputRequest<Employee> request) {
		Employee employee=employeeRepository.findById(id).get();
		if(employee!=null) {
			employee.setSalary(salary);
			employee.setModifiedBy(request.getLoggedInUser());
			employeeRepository.saveAndFlush(employee);
		}else {
			throw new RuntimeException("Employee not found with id : "+id);
		}
		return "Employee updated successfully!!!";
	}
}
