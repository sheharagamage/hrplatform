package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.PayrollDto;
import com.hrmanager.hrPlatform.mapper.RecruitmentPayrollMapper;
import com.hrmanager.hrPlatform.model.Employee;
import com.hrmanager.hrPlatform.model.Payroll;
import com.hrmanager.hrPlatform.repository.EmployeeRepository;
import com.hrmanager.hrPlatform.repository.PayrollRepository;
import com.hrmanager.hrPlatform.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository payrollRepo;
    private final EmployeeRepository employeeRepo;
    private final RecruitmentPayrollMapper mapper;

    @Override
    public PayrollDto create(PayrollDto dto) {
        Payroll ent = mapper.toEntity(dto);
        if (dto.getEmployeeId() != null) {
            Employee e = employeeRepo.findById(dto.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            ent.setEmployee(e);
        }
        // Basic calculation can be added here if you want to compute netSalary
        Payroll saved = payrollRepo.save(ent);
        return mapper.toDto(saved);
    }

    @Override
    public PayrollDto findById(Integer id) {
        return payrollRepo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Payroll not found"));
    }

    @Override
    public List<PayrollDto> findAll() {
        return payrollRepo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public PayrollDto update(Integer id, PayrollDto dto) {
        Payroll existing = payrollRepo.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
        // update fields
        existing.setMonth(dto.getMonth());
        existing.setYear(dto.getYear());
        existing.setGrossSalary(dto.getGrossSalary());
        existing.setTotalDeductions(dto.getTotalDeductions());
        existing.setNetSalary(dto.getNetSalary());
        existing.setStatus(dto.getStatus());
        if (dto.getEmployeeId() != null) {
            Employee e = employeeRepo.findById(dto.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found"));
            existing.setEmployee(e);
        } else {
            existing.setEmployee(null);
        }
        Payroll saved = payrollRepo.save(existing);
        return mapper.toDto(saved);
    }

    @Override
    public void delete(Integer id) {
        if (!payrollRepo.existsById(id)) throw new RuntimeException("Payroll not found");
        payrollRepo.deleteById(id);
    }
}
