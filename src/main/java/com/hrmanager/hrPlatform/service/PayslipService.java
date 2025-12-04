package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.PayslipDto;

import java.util.List;

public interface PayslipService {
    PayslipDto create(PayslipDto dto);
    PayslipDto findById(Integer id);
    List<PayslipDto> findAll();
    void delete(Integer id);
}
