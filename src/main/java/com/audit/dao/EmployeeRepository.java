package com.audit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.audit.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
