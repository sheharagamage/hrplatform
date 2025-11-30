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

    @Mapping(target = "employmentType", expression = "java(dto.getEmploymentTypeId() != null ? new EmploymentType(dto.getEmploymentTypeId(), null) : null)")
    @Mapping(target = "department", expression = "java(dto.getDepartmentId() != null ? new Department(dto.getDepartmentId(), null, null, null) : null)")
    @Mapping(target = "designation", expression = "java(dto.getDesignationId() != null ? new Designation(dto.getDesignationId(), null) : null)")
    @Mapping(target = "reportingManager", expression = "java(dto.getReportingManagerId() != null ? new Employee(dto.getReportingManagerId(), null, null, null, null, null, null, null, null, null, null, null) : null)")
    Employee toEntity(EmployeeDto dto);
}
