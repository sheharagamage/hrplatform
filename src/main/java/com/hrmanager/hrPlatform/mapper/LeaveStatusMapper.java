package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.LeaveStatusDto;
import com.hrmanager.hrPlatform.model.LeaveStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LeaveStatusMapper {

    @Mapping(source = "leaveApplication.leaveId", target = "leaveId")
    @Mapping(source = "approvedBy.employeeId", target = "approvedBy")
    LeaveStatusDto toDto(LeaveStatus entity);

    @Mapping(target = "leaveApplication", ignore = true)
    @Mapping(target = "approvedBy", ignore = true)
    LeaveStatus toEntity(LeaveStatusDto dto);
}
