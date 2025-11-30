package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.EmploymentTypeDto;
import com.hrmanager.hrPlatform.model.EmploymentType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface EmploymentTypeMapper {
    EmploymentTypeDto toDto(EmploymentType entity);
    EmploymentType toEntity(EmploymentTypeDto dto);

}


