package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.EmployeeDto;
import com.hrmanager.hrPlatform.model.Department;
import com.hrmanager.hrPlatform.model.Designation;
import com.hrmanager.hrPlatform.model.Employee;
import com.hrmanager.hrPlatform.model.EmploymentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {Department.class, EmploymentType.class, Designation.class})
public interface EmployeeMapper {
    @Mapping(source = "employmentType.employmentTypeId", target = "employmentTypeId")
    @Mapping(source = "department.departmentId", target = "departmentId")
    @Mapping(source = "designation.designationId", target = "designationId")
    @Mapping(source = "reportingManager.employeeId", target = "reportingManagerId")
    EmployeeDto toDto(Employee entity);

    @Mapping(target = "employmentType", expression = "java(mapEmploymentType(dto.getEmploymentTypeId()))")
    @Mapping(target = "department", expression = "java(mapDepartment(dto.getDepartmentId()))")
    @Mapping(target = "designation", expression = "java(mapDesignation(dto.getDesignationId()))")
    @Mapping(target = "reportingManager", expression = "java(mapReportingManager(dto.getReportingManagerId()))")
    Employee toEntity(EmployeeDto dto);

    default EmploymentType mapEmploymentType(Integer employmentTypeId) {
        if (employmentTypeId == null) {
            return null;
        }
        EmploymentType employmentType = new EmploymentType();
        employmentType.setEmploymentTypeId(employmentTypeId);
        return employmentType;
    }

    default Department mapDepartment(Integer departmentId) {
        if (departmentId == null) {
            return null;
        }
        Department department = new Department();
        department.setDepartmentId(departmentId);
        return department;
    }

    default Designation mapDesignation(Integer designationId) {
        if (designationId == null) {
            return null;
        }
        Designation designation = new Designation();
        designation.setDesignationId(designationId);
        return designation;
    }

    default Employee mapReportingManager(Integer reportingManagerId) {
        if (reportingManagerId == null) {
            return null;
        }
        Employee manager = new Employee();
        manager.setEmployeeId(reportingManagerId);
        return manager;
    }
}
