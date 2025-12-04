package com.hrmanager.hrPlatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private Date joinDate;
    private String status;
    private Integer employmentTypeId;
    private Integer departmentId;
    private Integer designationId;
    private Integer reportingManagerId;
}
