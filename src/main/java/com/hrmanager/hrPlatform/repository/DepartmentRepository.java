package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
