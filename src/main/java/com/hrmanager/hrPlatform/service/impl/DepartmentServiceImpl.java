package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.DepartmentDto;
import com.hrmanager.hrPlatform.mapper.DepartmentMapper;
import com.hrmanager.hrPlatform.model.Company;
import com.hrmanager.hrPlatform.model.Department;
import com.hrmanager.hrPlatform.repository.CompanyRepository;
import com.hrmanager.hrPlatform.repository.DepartmentRepository;
import com.hrmanager.hrPlatform.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository deptRepo;
    private final CompanyRepository companyRepo;
    private final DepartmentMapper mapper;

    public DepartmentServiceImpl(DepartmentRepository deptRepo, CompanyRepository companyRepo, DepartmentMapper mapper) {
        this.deptRepo = deptRepo;
        this.companyRepo = companyRepo;
        this.mapper = mapper;
    }

    @Override
    public DepartmentDto create(DepartmentDto dto) {
        Department entity = mapper.toEntity(dto);
        if (dto.getCompanyId() != null) {
            Company comp = companyRepo.findById(dto.getCompanyId()).orElseThrow(() -> new RuntimeException("Company not found"));
            entity.setCompany(comp);
        }
        return mapper.toDto(deptRepo.save(entity));
    }

    @Override
    public DepartmentDto update(Integer id, DepartmentDto dto) {
        Department existing = deptRepo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        existing.setName(dto.getName());
        if (dto.getCompanyId() != null) {
            Company comp = companyRepo.findById(dto.getCompanyId()).orElseThrow(() -> new RuntimeException("Company not found"));
            existing.setCompany(comp);
        } else {
            existing.setCompany(null);
        }
        return mapper.toDto(deptRepo.save(existing));
    }

    @Override
    public DepartmentDto findById(Integer id) {
        return deptRepo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public List<DepartmentDto> findAll() {
        return deptRepo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (!deptRepo.existsById(id)) throw new RuntimeException("Department not found");
        deptRepo.deleteById(id);
    }

}
