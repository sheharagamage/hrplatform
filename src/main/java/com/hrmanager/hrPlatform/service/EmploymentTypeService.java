package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.EmploymentTypeDto;

import java.util.List;

public interface EmploymentTypeService {
    EmploymentTypeDto create(EmploymentTypeDto dto);
    EmploymentTypeDto update(Integer id, EmploymentTypeDto dto);
    EmploymentTypeDto findById(Integer id);
    List<EmploymentTypeDto> findAll();
    void delete(Integer id);
}
