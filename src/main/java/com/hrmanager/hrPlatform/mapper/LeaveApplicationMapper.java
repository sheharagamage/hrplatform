package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.LeaveApplicationDto;
import com.hrmanager.hrPlatform.model.LeaveApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeaveApplicationMapper {

    @Mapping(source = "employee.employeeId", target = "employeeId")
    @Mapping(source = "leaveType.leaveTypeId", target = "leaveTypeId")
    @Mapping(source = "status.id", target = "statusId")
    LeaveApplicationDto toDto(LeaveApplication entity);

    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "leaveType", ignore = true)
    @Mapping(target = "status", ignore = true)
    LeaveApplication toEntity(LeaveApplicationDto dto);
}
