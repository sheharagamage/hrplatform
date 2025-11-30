package com.hrmanager.hrPlatform.mapper;


import com.hrmanager.hrPlatform.DTO.DepartmentDto;
import com.hrmanager.hrPlatform.model.Company;
import com.hrmanager.hrPlatform.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = Company.class)
public interface DepartmentMapper {

    @Mapping(source = "company.companyId", target = "companyId")
    DepartmentDto toDto(Department entity);

    @Mapping(target = "company", expression = "java(dto.getCompanyId() != null ? new Company(dto.getCompanyId(), null, null, null, null) : null)")
    Department toEntity(DepartmentDto dto);
}
