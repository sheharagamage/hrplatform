package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.AttendanceSourceDto;

import java.util.List;

public interface AttendanceSourceService {
    AttendanceSourceDto create(AttendanceSourceDto dto);
    List<AttendanceSourceDto> getAll();
}
