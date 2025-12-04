package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.LeaveTypeDto;
import com.hrmanager.hrPlatform.mapper.LeaveTypeMapper;
import com.hrmanager.hrPlatform.model.LeaveType;
import com.hrmanager.hrPlatform.repository.LeaveTypeRepository;
import com.hrmanager.hrPlatform.service.LeaveTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveTypeServiceImpl implements LeaveTypeService {

    private final LeaveTypeRepository repo;
    private final LeaveTypeMapper mapper;

    @Override
    public LeaveTypeDto create(LeaveTypeDto dto) {
        LeaveType saved = repo.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    @Override
    public LeaveTypeDto update(Long id, LeaveTypeDto dto) {
        LeaveType existing = repo.findById(id).orElseThrow(() -> new RuntimeException("LeaveType not found"));
        existing.setTypeName(dto.getTypeName());
        existing.setDescription(dto.getDescription());
        existing.setMaxDaysPerYear(dto.getMaxDaysPerYear());
        existing.setIsPaid(dto.getIsPaid());
        existing.setIsActive(dto.getIsActive());
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public LeaveTypeDto findById(Long id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("LeaveType not found"));
    }

    @Override
    public List<LeaveTypeDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new RuntimeException("LeaveType not found");
        repo.deleteById(id);
    }
}
