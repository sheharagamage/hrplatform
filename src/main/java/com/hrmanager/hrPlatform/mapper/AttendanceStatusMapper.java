package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.AttendanceStatusDto;
import com.hrmanager.hrPlatform.model.AttendanceStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttendanceStatusMapper {
    AttendanceStatusDto toDto(AttendanceStatus entity);
    AttendanceStatus toEntity(AttendanceStatusDto dto);
}
