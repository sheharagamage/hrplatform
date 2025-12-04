package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {
}
