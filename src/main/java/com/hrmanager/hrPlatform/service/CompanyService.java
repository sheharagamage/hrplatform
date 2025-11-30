package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto create(CompanyDto dto);
    CompanyDto update(Integer id, CompanyDto dto);
    CompanyDto findById(Integer id);
    List<CompanyDto> findAll();
    void delete(Integer id);
}

