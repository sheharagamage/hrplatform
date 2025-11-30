package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Payroll")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Integer month;
    private Integer year;
    private Double grossSalary;
    private Double totalDeductions;
    private Double netSalary;

    private String status; // Pending, Completed
}
