package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.EmployeeLeaveBalanceDto;

import java.util.List;

public interface EmployeeLeaveBalanceService {
    EmployeeLeaveBalanceDto create(EmployeeLeaveBalanceDto dto);
    EmployeeLeaveBalanceDto update(Long id, EmployeeLeaveBalanceDto dto);
    EmployeeLeaveBalanceDto findById(Long id);
    List<EmployeeLeaveBalanceDto> findAll();
    void delete(Long id);
}
