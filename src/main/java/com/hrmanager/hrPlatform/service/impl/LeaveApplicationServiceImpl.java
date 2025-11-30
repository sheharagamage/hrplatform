package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.LeaveApplicationDto;
import com.hrmanager.hrPlatform.mapper.LeaveApplicationMapper;
import com.hrmanager.hrPlatform.model.AttendanceStatus;
import com.hrmanager.hrPlatform.model.Employee;
import com.hrmanager.hrPlatform.model.LeaveApplication;
import com.hrmanager.hrPlatform.model.LeaveType;
import com.hrmanager.hrPlatform.repository.AttendanceStatusRepository;
import com.hrmanager.hrPlatform.repository.EmployeeRepository;
import com.hrmanager.hrPlatform.repository.LeaveApplicationRepository;
import com.hrmanager.hrPlatform.repository.LeaveTypeRepository;
import com.hrmanager.hrPlatform.service.LeaveApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveApplicationServiceImpl implements LeaveApplicationService {

    private final LeaveApplicationRepository repo;
    private final LeaveApplicationMapper mapper;
    private final EmployeeRepository employeeRepo;
    private final LeaveTypeRepository leaveTypeRepo;
    private final AttendanceStatusRepository attendanceStatusRepo;

    @Override
    public LeaveApplicationDto create(LeaveApplicationDto dto) {
        LeaveApplication ent = mapper.toEntity(dto);

        if (dto.getEmployeeId() != null) {
            Employee emp = employeeRepo.findById(Math.toIntExact(dto.getEmployeeId())).orElseThrow(() -> new RuntimeException("Employee not found"));
            ent.setEmployee(emp);
        }
        if (dto.getLeaveTypeId() != null) {
            LeaveType lt = leaveTypeRepo.findById(dto.getLeaveTypeId()).orElseThrow(() -> new RuntimeException("LeaveType not found"));
            ent.setLeaveType(lt);
        }
        if (dto.getStatusId() != null) {
            AttendanceStatus st = attendanceStatusRepo.findById(dto.getStatusId()).orElseThrow(() -> new RuntimeException("Status not found"));
            ent.setStatus(st);
        }
        if (ent.getAppliedAt() == null) ent.setAppliedAt(LocalDateTime.now());
        ent.setUpdatedAt(LocalDateTime.now());
        return mapper.toDto(repo.save(ent));
    }

    @Override
    public LeaveApplicationDto update(Long id, LeaveApplicationDto dto) {
        LeaveApplication existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Leave application not found"));

        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());
        existing.setTotalDays(dto.getTotalDays());
        existing.setReason(dto.getReason());

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

        if (dto.getStatusId() != null) {
            AttendanceStatus st = attendanceStatusRepo.findById(dto.getStatusId()).orElseThrow(() -> new RuntimeException("Status not found"));
            existing.setStatus(st);
        } else {
            existing.setStatus(null);
        }

        existing.setUpdatedAt(LocalDateTime.now());
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public LeaveApplicationDto findById(Long id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Leave application not found"));
    }

    @Override
    public List<LeaveApplicationDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new RuntimeException("Leave application not found");
        repo.deleteById(id);
    }
}
