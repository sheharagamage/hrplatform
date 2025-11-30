package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.*;
import com.hrmanager.hrPlatform.model.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SalaryMapper {

    SalaryComponentDto toComponentDto(SalaryComponent component);

    @Mapping(target = "type", expression = "java(component.getType().name())")
    @Mapping(target = "amountType", expression = "java(component.getAmountType().name())")
    SalaryComponentDto toDto(SalaryComponent component);

    @InheritInverseConfiguration
    SalaryComponent toEntity(SalaryComponentDto dto);

    // SalaryStructure
    @Mapping(target = "employeeId", source = "employee.employeeId")
    @Mapping(target = "componentId", source = "component.componentId")
    SalaryStructureDto toDto(SalaryStructure structure);

    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "component", ignore = true)
    SalaryStructure toEntity(SalaryStructureDto dto);
}
