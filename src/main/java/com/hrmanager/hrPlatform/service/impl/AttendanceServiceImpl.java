package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.AttendanceDto;
import com.hrmanager.hrPlatform.mapper.AttendanceMapper;
import com.hrmanager.hrPlatform.model.Attendance;
import com.hrmanager.hrPlatform.repository.AttendanceRepository;
import com.hrmanager.hrPlatform.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository repository;
    private final AttendanceMapper mapper;

    @Override
    public AttendanceDto create(AttendanceDto dto) {
        Attendance entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<AttendanceDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).toList();
    }
}
