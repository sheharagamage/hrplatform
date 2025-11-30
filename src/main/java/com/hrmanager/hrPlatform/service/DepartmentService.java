package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto create(DepartmentDto dto);
    DepartmentDto update(Integer id, DepartmentDto dto);
    DepartmentDto findById(Integer id);
    List<DepartmentDto> findAll();
    void delete(Integer id);
}
