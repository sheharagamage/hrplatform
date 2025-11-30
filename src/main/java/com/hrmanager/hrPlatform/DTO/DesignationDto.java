package com.hrmanager.hrPlatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignationDto {
    private Integer designationId;
    private String name;
    private Integer departmentId;
}
