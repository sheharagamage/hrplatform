package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.SalaryStructureDto;
import java.util.List;

public interface SalaryStructureService {

    SalaryStructureDto create(SalaryStructureDto dto);
    SalaryStructureDto update(Integer id, SalaryStructureDto dto);
    SalaryStructureDto findById(Integer id);
    List<SalaryStructureDto> findAll();
    void delete(Integer id);
}
