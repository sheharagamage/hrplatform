package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.AttendanceSourceDto;
import com.hrmanager.hrPlatform.model.AttendanceSource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttendanceSourceMapper {
    AttendanceSourceDto toDto(AttendanceSource entity);
    AttendanceSource toEntity(AttendanceSourceDto dto);
}
