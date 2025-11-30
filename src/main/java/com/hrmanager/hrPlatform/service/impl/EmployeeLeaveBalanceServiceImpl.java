package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.EmployeeLeaveBalanceDto;
import com.hrmanager.hrPlatform.mapper.EmployeeLeaveBalanceMapper;
import com.hrmanager.hrPlatform.model.Employee;
import com.hrmanager.hrPlatform.model.EmployeeLeaveBalance;
import com.hrmanager.hrPlatform.model.LeaveType;
import com.hrmanager.hrPlatform.repository.EmployeeLeaveBalanceRepository;
import com.hrmanager.hrPlatform.repository.EmployeeRepository;
import com.hrmanager.hrPlatform.repository.LeaveTypeRepository;
import com.hrmanager.hrPlatform.service.EmployeeLeaveBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeLeaveBalanceServiceImpl implements EmployeeLeaveBalanceService {

    private final EmployeeLeaveBalanceRepository repo;
    private final EmployeeRepository employeeRepo;
    private final LeaveTypeRepository leaveTypeRepo;
    private final EmployeeLeaveBalanceMapper mapper;

    @Override
    public EmployeeLeaveBalanceDto create(EmployeeLeaveBalanceDto dto) {
        EmployeeLeaveBalance ent = mapper.toEntity(dto);
        if (dto.getEmployeeId() != null) {
            Employee emp = employeeRepo.findById(Math.toIntExact(dto.getEmployeeId())).orElseThrow(() -> new RuntimeException("Employee not found"));
            ent.setEmployee(emp);
        }
        if (dto.getLeaveTypeId() != null) {
            LeaveType lt = leaveTypeRepo.findById(dto.getLeaveTypeId()).orElseThrow(() -> new RuntimeException("LeaveType not found"));
            ent.setLeaveType(lt);
        }
        return mapper.toDto(repo.save(ent));
    }

    @Override
    public EmployeeLeaveBalanceDto update(Long id, EmployeeLeaveBalanceDto dto) {
        EmployeeLeaveBalance existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Balance not found"));
        existing.setAllocatedDays(dto.getAllocatedDays());
        existing.setUsedDays(dto.getUsedDays());
        existing.setRemainingDays(dto.getRemainingDays());
        existing.setYear(dto.getYear());
        if (dto.getEmployeeId() != null) {
            Employee emp = employeeRepo.findById(Math.toIntExact(dto.getEmployeeId())).orElseThrow(() -> new RuntimeException("Employee not found"));
            existing.setEmployee(emp);
        } else {
            existing.setEmployee(null);
        }
        if (dto.getLeaveTypeId() != null) {
            LeaveType lt = leaveTypeRepo.findById(dto.getLeaveTypeId()).orElseThrow(() -> new RuntimeException("LeaveType not found"));
            existing.setLeaveType(lt);
        } else {
            existing.setLeaveType(null);
        }
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public EmployeeLeaveBalanceDto findById(Long id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Balance not found"));
    }

    @Override
    public List<EmployeeLeaveBalanceDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new RuntimeException("Balance not found");
        repo.deleteById(id);
    }
}
