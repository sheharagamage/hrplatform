package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class LeaveTypeDto {
    private Long leaveTypeId;
    private String typeName;
    private String description;
    private Integer maxDaysPerYear;
    private Boolean isPaid;
    private Boolean isActive;
}
