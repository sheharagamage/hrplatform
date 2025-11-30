package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.LeaveStatusDto;

import java.util.List;

public interface LeaveStatusService {
    LeaveStatusDto create(LeaveStatusDto dto);
    LeaveStatusDto findById(Long id);
    List<LeaveStatusDto> findAll();
    void delete(Long id);
}
