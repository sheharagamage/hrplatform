package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.AttendanceStatusDto;

import java.util.List;

public interface AttendanceStatusService {
    AttendanceStatusDto create(AttendanceStatusDto dto);
    List<AttendanceStatusDto> getAll();
}
