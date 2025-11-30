package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceStatusRepository extends JpaRepository<AttendanceStatus, Long> {
}
