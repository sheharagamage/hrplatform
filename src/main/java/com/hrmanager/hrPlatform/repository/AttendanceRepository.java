package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}