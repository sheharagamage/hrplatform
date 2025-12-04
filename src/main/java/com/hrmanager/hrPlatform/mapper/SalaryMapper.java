package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.*;
import com.hrmanager.hrPlatform.model.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SalaryMapper {

    @Mapping(target = "type", expression = "java(component.getType() != null ? component.getType().name() : null)")
    @Mapping(target = "amountType", expression = "java(component.getAmountType() != null ? component.getAmountType().name() : null)")
    SalaryComponentDto toDto(SalaryComponent component);

    @Mapping(target = "type", expression = "java(mapComponentType(dto.getType()))")
    @Mapping(target = "amountType", expression = "java(mapAmountType(dto.getAmountType()))")
    SalaryComponent toEntity(SalaryComponentDto dto);

    // SalaryStructure
    @Mapping(target = "employeeId", source = "employee.employeeId")
    @Mapping(target = "componentId", source = "component.componentId")
    SalaryStructureDto toDto(SalaryStructure structure);

    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "component", ignore = true)
    SalaryStructure toEntity(SalaryStructureDto dto);

    default SalaryComponent.ComponentType mapComponentType(String value) {
        return value == null ? null : SalaryComponent.ComponentType.valueOf(value);
    }

    default SalaryComponent.AmountType mapAmountType(String value) {
        return value == null ? null : SalaryComponent.AmountType.valueOf(value);
    }
}
