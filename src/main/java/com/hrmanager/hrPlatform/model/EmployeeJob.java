package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeJobId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    private String jobTitle;
    private Date startDate;
    private Date endDate;
    private String status;

}
