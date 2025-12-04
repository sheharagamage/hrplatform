package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.SalaryStructureDto;
import com.hrmanager.hrPlatform.mapper.SalaryMapper;
import com.hrmanager.hrPlatform.model.Employee;
import com.hrmanager.hrPlatform.model.SalaryComponent;
import com.hrmanager.hrPlatform.model.SalaryStructure;
import com.hrmanager.hrPlatform.repository.EmployeeRepository;
import com.hrmanager.hrPlatform.repository.SalaryComponentRepository;
import com.hrmanager.hrPlatform.repository.SalaryStructureRepository;
import com.hrmanager.hrPlatform.service.SalaryStructureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryStructureServiceImpl implements SalaryStructureService {

    private final SalaryStructureRepository repo;
    private final EmployeeRepository employeeRepo;
    private final SalaryComponentRepository compRepo;
    private final SalaryMapper mapper;

    public SalaryStructureServiceImpl(SalaryStructureRepository repo,
                                      EmployeeRepository employeeRepo,
                                      SalaryComponentRepository compRepo,
                                      SalaryMapper mapper) {
        this.repo = repo;
        this.employeeRepo = employeeRepo;
        this.compRepo = compRepo;
        this.mapper = mapper;
    }

    @Override
    public SalaryStructureDto create(SalaryStructureDto dto) {
        SalaryStructure entity = mapper.toEntity(dto);

        Employee emp = employeeRepo.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        SalaryComponent comp = compRepo.findById(dto.getComponentId())
                .orElseThrow(() -> new RuntimeException("Component not found"));

        entity.setEmployee(emp);
        entity.setComponent(comp);

        return mapper.toDto(repo.save(entity));
    }

    @Override
    public SalaryStructureDto update(Integer id, SalaryStructureDto dto) {
        SalaryStructure existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Structure not found"));

        Employee emp = employeeRepo.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        SalaryComponent comp = compRepo.findById(dto.getComponentId())
                .orElseThrow(() -> new RuntimeException("Component not found"));

        existing.setEmployee(emp);
        existing.setComponent(comp);
        existing.setAmount(dto.getAmount());

        return mapper.toDto(repo.save(existing));
    }

    @Override
    public SalaryStructureDto findById(Integer id) {
        return repo.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Structure not found"));
    }

    @Override
    public List<SalaryStructureDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
