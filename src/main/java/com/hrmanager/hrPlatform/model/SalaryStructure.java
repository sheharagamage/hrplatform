package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "salary_structure")
@Data
public class SalaryStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long structureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id")
    private SalaryComponent component;

    private Double amount;
}
