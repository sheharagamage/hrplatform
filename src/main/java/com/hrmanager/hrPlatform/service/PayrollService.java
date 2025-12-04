package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.PayrollDto;

import java.util.List;

public interface PayrollService {
    PayrollDto create(PayrollDto dto);
    PayrollDto findById(Integer id);
    List<PayrollDto> findAll();
    PayrollDto update(Integer id, PayrollDto dto);
    void delete(Integer id);
}
