package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.SalaryComponentDto;
import com.hrmanager.hrPlatform.mapper.SalaryMapper;
import com.hrmanager.hrPlatform.model.SalaryComponent;
import com.hrmanager.hrPlatform.repository.SalaryComponentRepository;
import com.hrmanager.hrPlatform.service.SalaryComponentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryComponentServiceImpl implements SalaryComponentService {

    private final SalaryComponentRepository repo;
    private final SalaryMapper mapper;

    public SalaryComponentServiceImpl(SalaryComponentRepository repo, SalaryMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public SalaryComponentDto create(SalaryComponentDto dto) {
        SalaryComponent comp = mapper.toEntity(dto);
        SalaryComponent saved = repo.save(comp);
        return mapper.toDto(saved);
    }

    @Override
    public SalaryComponentDto update(Integer id, SalaryComponentDto dto) {
        SalaryComponent existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found"));
        existing.setName(dto.getName());
        existing.setType(SalaryComponent.ComponentType.valueOf(dto.getType()));
        existing.setAmountType(SalaryComponent.AmountType.valueOf(dto.getAmountType()));
        existing.setValue(dto.getValue());
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public SalaryComponentDto findById(Integer id) {
        return repo.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Component not found"));
    }

    @Override
    public List<SalaryComponentDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
