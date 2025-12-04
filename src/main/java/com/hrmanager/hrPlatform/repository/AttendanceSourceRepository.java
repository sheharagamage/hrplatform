package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.AttendanceSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceSourceRepository extends JpaRepository<AttendanceSource, Long> {
}
