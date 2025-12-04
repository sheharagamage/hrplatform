package com.hrmanager.hrPlatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Integer departmentId;
    private String name;
    private Integer companyId; // relation as id

}
