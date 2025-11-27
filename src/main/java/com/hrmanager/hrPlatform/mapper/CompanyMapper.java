package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.CompanyDto;
import com.hrmanager.hrPlatform.model.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class CompanyMapper {
    CompanyDto toDto(Company entity);
    Company toEntity(CompanyDto dto);

}
