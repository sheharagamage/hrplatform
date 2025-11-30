package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.EmployeeDto;
import com.hrmanager.hrPlatform.mapper.EmployeeMapper;
import com.hrmanager.hrPlatform.model.Department;
import com.hrmanager.hrPlatform.model.Designation;
import com.hrmanager.hrPlatform.model.Employee;
import com.hrmanager.hrPlatform.model.EmploymentType;
import com.hrmanager.hrPlatform.repository.DepartmentRepository;
import com.hrmanager.hrPlatform.repository.DesignationRepository;
import com.hrmanager.hrPlatform.repository.EmployeeRepository;
import com.hrmanager.hrPlatform.repository.EmploymentTypeRepository;
import com.hrmanager.hrPlatform.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;
    private final EmployeeMapper mapper;
    private final EmploymentTypeRepository employmentTypeRepo;
    private final DepartmentRepository departmentRepo;
    private final DesignationRepository designationRepo;

    public EmployeeServiceImpl(EmployeeRepository repo,
                               EmployeeMapper mapper,
                               EmploymentTypeRepository employmentTypeRepo,
                               DepartmentRepository departmentRepo,
                               DesignationRepository designationRepo) {
        this.repo = repo;
        this.mapper = mapper;
        this.employmentTypeRepo = employmentTypeRepo;
        this.departmentRepo = departmentRepo;
        this.designationRepo = designationRepo;
    }

    @Override
    public EmployeeDto create(EmployeeDto dto) {
        Employee entity = mapper.toEntity(dto);
        // set real relations
        if (dto.getEmploymentTypeId() != null) {
            EmploymentType et = employmentTypeRepo.findById(dto.getEmploymentTypeId())
                    .orElseThrow(() -> new RuntimeException("EmploymentType not found"));
            entity.setEmploymentType(et);
        }
        if (dto.getDepartmentId() != null) {
            Department d = departmentRepo.findById(dto.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));
            entity.setDepartment(d);
        }
        if (dto.getDesignationId() != null) {
            Designation des = designationRepo.findById(dto.getDesignationId()).orElseThrow(() -> new RuntimeException("Designation not found"));
            entity.setDesignation(des);
        }
        if (dto.getReportingManagerId() != null) {
            Employee mgr = repo.findById(dto.getReportingManagerId()).orElseThrow(() -> new RuntimeException("Manager not found"));
            entity.setReportingManager(mgr);
        }
        Employee saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public EmployeeDto update(Integer id, EmployeeDto dto) {
        Employee existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setDob(dto.getDob());
        existing.setGender(dto.getGender());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setAddress(dto.getAddress());
        existing.setJoinDate(dto.getJoinDate());
        existing.setStatus(dto.getStatus());

        if (dto.getEmploymentTypeId() != null) {
            EmploymentType et = employmentTypeRepo.findById(dto.getEmploymentTypeId()).orElseThrow(() -> new RuntimeException("EmploymentType not found"));
            existing.setEmploymentType(et);
        } else {
            existing.setEmploymentType(null);
        }

        if (dto.getDepartmentId() != null) {
            Department d = departmentRepo.findById(dto.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));
            existing.setDepartment(d);
        } else {
            existing.setDepartment(null);
        }

        if (dto.getDesignationId() != null) {
            Designation des = designationRepo.findById(dto.getDesignationId()).orElseThrow(() -> new RuntimeException("Designation not found"));
            existing.setDesignation(des);
        } else {
            existing.setDesignation(null);
        }

        if (dto.getReportingManagerId() != null) {
            Employee mgr = repo.findById(dto.getReportingManagerId()).orElseThrow(() -> new RuntimeException("Manager not found"));
            existing.setReportingManager(mgr);
        } else {
            existing.setReportingManager(null);
        }

        return mapper.toDto(repo.save(existing));
    }

    @Override
    public EmployeeDto findById(Integer id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id)) throw new RuntimeException("Employee not found");
        repo.deleteById(id);
    }

}
