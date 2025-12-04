package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.AttendanceStatusDto;
import com.hrmanager.hrPlatform.mapper.AttendanceStatusMapper;
import com.hrmanager.hrPlatform.model.AttendanceStatus;
import com.hrmanager.hrPlatform.repository.AttendanceStatusRepository;
import com.hrmanager.hrPlatform.service.AttendanceStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceStatusServiceImpl implements AttendanceStatusService {

    private final AttendanceStatusRepository repository;
    private final AttendanceStatusMapper mapper;

    @Override
    public AttendanceStatusDto create(AttendanceStatusDto dto) {
        AttendanceStatus entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<AttendanceStatusDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).toList();
    }
}
