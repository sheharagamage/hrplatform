package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class EmployeeLeaveBalanceDto {
    private Long balanceId;
    private Long employeeId;
    private Long leaveTypeId;
    private Integer allocatedDays;
    private Integer usedDays;
    private Integer remainingDays;
    private Integer year;
}
