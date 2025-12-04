package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.SalaryComponentDto;
import java.util.List;

public interface SalaryComponentService {

    SalaryComponentDto create(SalaryComponentDto dto);
    SalaryComponentDto update(Integer id, SalaryComponentDto dto);
    SalaryComponentDto findById(Integer id);
    List<SalaryComponentDto> findAll();
    void delete(Integer id);
}
