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

    @Mapping(target = "company", expression = "java(mapCompany(dto.getCompanyId()))")
    @Mapping(target = "designations", ignore = true)
    @Mapping(target = "employees", ignore = true)
    Department toEntity(DepartmentDto dto);

    default Company mapCompany(Integer companyId) {
        if (companyId == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyId(companyId);
        return company;
    }
}
