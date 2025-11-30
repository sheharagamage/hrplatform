package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class SalaryStructureDto {

    private Integer structureId;
    private Integer employeeId;
    private Integer componentId;
    private Double amount;
}
