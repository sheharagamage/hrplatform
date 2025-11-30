package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.LeaveTypeDto;
import com.hrmanager.hrPlatform.model.LeaveType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveTypeMapper {
    LeaveTypeDto toDto(LeaveType entity);
    LeaveType toEntity(LeaveTypeDto dto);
}
