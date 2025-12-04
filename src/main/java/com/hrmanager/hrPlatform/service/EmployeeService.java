package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto dto);
    EmployeeDto update(Integer id, EmployeeDto dto);
    EmployeeDto findById(Integer id);
    List<EmployeeDto> findAll();
    void delete(Integer id);
}
