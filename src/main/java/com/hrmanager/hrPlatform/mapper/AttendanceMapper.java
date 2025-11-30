package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.AttendanceDto;
import com.hrmanager.hrPlatform.model.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    @Mapping(source = "employee.employeeId", target = "employeeId")
    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "source.id", target = "sourceId")
    AttendanceDto toDto(Attendance entity);

    @Mapping(source = "employeeId", target = "employee.employeeId")
    @Mapping(source = "statusId", target = "status.id")
    @Mapping(source = "sourceId", target = "source.id")
    Attendance toEntity(AttendanceDto dto);
}
