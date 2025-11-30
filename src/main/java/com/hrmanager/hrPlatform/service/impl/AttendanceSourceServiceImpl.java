package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.AttendanceSourceDto;
import com.hrmanager.hrPlatform.mapper.AttendanceSourceMapper;
import com.hrmanager.hrPlatform.model.AttendanceSource;
import com.hrmanager.hrPlatform.repository.AttendanceSourceRepository;
import com.hrmanager.hrPlatform.service.AttendanceSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceSourceServiceImpl implements AttendanceSourceService {

    private final AttendanceSourceRepository repository;
    private final AttendanceSourceMapper mapper;

    @Override
    public AttendanceSourceDto create(AttendanceSourceDto dto) {
        AttendanceSource entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<AttendanceSourceDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).toList();
    }
}