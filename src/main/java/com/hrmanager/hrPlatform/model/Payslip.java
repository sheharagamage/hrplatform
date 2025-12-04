package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Payslip")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payslip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payslipId;

    @ManyToOne
    @JoinColumn(name = "payroll_id")
    private Payroll payroll;

    private String pdfPath;
}
