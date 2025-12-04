package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {}

