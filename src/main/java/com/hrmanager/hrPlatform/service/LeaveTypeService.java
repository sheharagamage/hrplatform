package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.LeaveTypeDto;

import java.util.List;

public interface LeaveTypeService {
    LeaveTypeDto create(LeaveTypeDto dto);
    LeaveTypeDto update(Long id, LeaveTypeDto dto);
    LeaveTypeDto findById(Long id);
    List<LeaveTypeDto> findAll();
    void delete(Long id);
}

