package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class PayrollDto {

    private Integer payrollId;
    private Integer employeeId;
    private Integer month;
    private Integer year;
    private Double grossSalary;
    private Double totalDeductions;
    private Double netSalary;
    private String status;
}
