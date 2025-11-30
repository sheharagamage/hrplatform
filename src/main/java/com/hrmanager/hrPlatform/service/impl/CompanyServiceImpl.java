package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.CompanyDto;
import com.hrmanager.hrPlatform.mapper.CompanyMapper;
import com.hrmanager.hrPlatform.model.Company;
import com.hrmanager.hrPlatform.repository.CompanyRepository;
import com.hrmanager.hrPlatform.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repo;
    private final CompanyMapper mapper;

    public CompanyServiceImpl(CompanyRepository repo, CompanyMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public CompanyDto create(CompanyDto dto) {
        Company entity = mapper.toEntity(dto);
        Company saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public CompanyDto update(Integer id, CompanyDto dto) {
        Company existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        existing.setName(dto.getName());
        existing.setLogo(dto.getLogo());
        existing.setAddress(dto.getAddress());
        existing.setContact(dto.getContact());
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public CompanyDto findById(Integer id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @Override
    public List<CompanyDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id)) throw new RuntimeException("Company not found");
        repo.deleteById(id);
    }
}
