package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.PayslipDto;
import com.hrmanager.hrPlatform.mapper.RecruitmentPayrollMapper;
import com.hrmanager.hrPlatform.model.Payslip;
import com.hrmanager.hrPlatform.model.Payroll;
import com.hrmanager.hrPlatform.repository.PayslipRepository;
import com.hrmanager.hrPlatform.repository.PayrollRepository;
import com.hrmanager.hrPlatform.service.PayslipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayslipServiceImpl implements PayslipService {

    private final PayslipRepository repo;
    private final PayrollRepository payrollRepo;
    private final RecruitmentPayrollMapper mapper;

    @Override
    public PayslipDto create(PayslipDto dto) {
        Payslip ent = mapper.toEntity(dto);
        if (dto.getPayrollId() != null) {
            Payroll p = payrollRepo.findById(dto.getPayrollId()).orElseThrow(() -> new RuntimeException("Payroll not found"));
            ent.setPayroll(p);
        }
        Payslip saved = repo.save(ent);
        return mapper.toDto(saved);
    }

    @Override
    public PayslipDto findById(Integer id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Payslip not found"));
    }

    @Override
    public List<PayslipDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id)) throw new RuntimeException("Payslip not found");
        repo.deleteById(id);
    }
}
