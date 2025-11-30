package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayslipRepository extends JpaRepository<Payslip, Integer> {}
