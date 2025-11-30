package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.LeaveApplicationDto;

import java.util.List;

public interface LeaveApplicationService {
    LeaveApplicationDto create(LeaveApplicationDto dto);
    LeaveApplicationDto update(Long id, LeaveApplicationDto dto);
    LeaveApplicationDto findById(Long id);
    List<LeaveApplicationDto> findAll();
    void delete(Long id);
}
