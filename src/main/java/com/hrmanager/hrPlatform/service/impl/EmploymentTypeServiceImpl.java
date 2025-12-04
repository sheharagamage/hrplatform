package com.hrmanager.hrPlatform.service.impl;


import com.hrmanager.hrPlatform.DTO.EmploymentTypeDto;
import com.hrmanager.hrPlatform.mapper.EmploymentTypeMapper;
import com.hrmanager.hrPlatform.model.EmploymentType;
import com.hrmanager.hrPlatform.repository.EmploymentTypeRepository;
import com.hrmanager.hrPlatform.service.EmploymentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmploymentTypeServiceImpl implements EmploymentTypeService {

    private final EmploymentTypeRepository repo;
    private final EmploymentTypeMapper mapper;

    public EmploymentTypeServiceImpl(EmploymentTypeRepository repo, EmploymentTypeMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public EmploymentTypeDto create(EmploymentTypeDto dto) {
        EmploymentType saved = repo.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    @Override
    public EmploymentTypeDto update(Integer id, EmploymentTypeDto dto) {
        EmploymentType ex = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        ex.setName(dto.getName());
        return mapper.toDto(repo.save(ex));
    }

    @Override
    public EmploymentTypeDto findById(Integer id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<EmploymentTypeDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id)) throw new RuntimeException("Not found");
        repo.deleteById(id);
    }
}
