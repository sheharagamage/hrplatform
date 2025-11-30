package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.LeaveStatusDto;
import com.hrmanager.hrPlatform.mapper.LeaveStatusMapper;
import com.hrmanager.hrPlatform.model.Employee;
import com.hrmanager.hrPlatform.model.LeaveApplication;
import com.hrmanager.hrPlatform.model.LeaveStatus;
import com.hrmanager.hrPlatform.repository.EmployeeRepository;
import com.hrmanager.hrPlatform.repository.LeaveApplicationRepository;
import com.hrmanager.hrPlatform.repository.LeaveStatusRepository;
import com.hrmanager.hrPlatform.service.LeaveStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveStatusServiceImpl implements LeaveStatusService {

    private final LeaveStatusRepository repo;
    private final LeaveStatusMapper mapper;
    private final LeaveApplicationRepository leaveAppRepo;
    private final EmployeeRepository employeeRepo;

    @Override
    public LeaveStatusDto create(LeaveStatusDto dto) {
        LeaveStatus ent = mapper.toEntity(dto);

        if (dto.getLeaveId() != null) {
            LeaveApplication la = leaveAppRepo.findById(dto.getLeaveId()).orElseThrow(() -> new RuntimeException("Leave application not found"));
            ent.setLeaveApplication(la);
        }
        if (dto.getApprovedBy() != null) {
            Employee approver = employeeRepo.findById(Math.toIntExact(dto.getApprovedBy())).orElseThrow(() -> new RuntimeException("Approver employee not found"));
            ent.setApprovedBy(approver);
        }
        if (ent.getActionDate() == null) ent.setActionDate(LocalDateTime.now());
        return mapper.toDto(repo.save(ent));
    }

    @Override
    public LeaveStatusDto findById(Long id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Leave status not found"));
    }

    @Override
    public List<LeaveStatusDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new RuntimeException("Leave status not found");
        repo.deleteById(id);
    }
}
