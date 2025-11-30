package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.EmployeeLeaveBalanceDto;
import com.hrmanager.hrPlatform.model.EmployeeLeaveBalance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeLeaveBalanceMapper {

    @Mapping(source = "employee.employeeId", target = "employeeId")
    @Mapping(source = "leaveType.leaveTypeId", target = "leaveTypeId")
    EmployeeLeaveBalanceDto toDto(EmployeeLeaveBalance entity);

    // toEntity will leave relations null; service layer will set them
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "leaveType", ignore = true)
    EmployeeLeaveBalance toEntity(EmployeeLeaveBalanceDto dto);
}
