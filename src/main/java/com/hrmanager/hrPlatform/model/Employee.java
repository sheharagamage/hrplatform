package com.hrmanager.hrPlatform.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "employmentTypeId")
    private EmploymentType employmentType;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "designationId")
    private Designation designation;

    @ManyToOne
    @JoinColumn(name = "reportingManagerId")
    private Employee reportingManager;
}
