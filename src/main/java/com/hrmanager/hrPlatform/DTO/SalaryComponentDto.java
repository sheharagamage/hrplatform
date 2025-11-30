package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class SalaryComponentDto {

    private Integer componentId;
    private String name;
    private String type;        // Allowance / Deduction
    private String amountType;  // Fixed / Percentage
    private Double value;
}
