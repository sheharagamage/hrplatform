package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.AttendanceDto;

import java.util.List;

public interface AttendanceService {
    AttendanceDto create(AttendanceDto dto);
    List<AttendanceDto> getAll();
}
