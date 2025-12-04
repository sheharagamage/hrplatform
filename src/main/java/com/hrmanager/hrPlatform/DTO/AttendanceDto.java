package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class AttendanceDto {
    private Long id;
    private Long employeeId;
    private String attendanceDate;
    private Long statusId;
    private Long sourceId;
    private String remarks;
    private String createdAt;
}
