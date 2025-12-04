package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
