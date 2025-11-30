package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.DesignationDto;
import com.hrmanager.hrPlatform.model.Department;
import com.hrmanager.hrPlatform.model.Designation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = Department.class)
public interface DesignationMapper {
    @Mapping(source = "department.departmentId", target = "departmentId")
    DesignationDto toDto(Designation entity);

    @Mapping(target = "department", expression = "java(dto.getDepartmentId() != null ? new Department(dto.getDepartmentId(), null) : null)")
    Designation toEntity(DesignationDto dto);


}
