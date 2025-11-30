package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "salary_component")
@Data
public class SalaryComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long componentId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ComponentType type;

    @Enumerated(EnumType.STRING)
    private AmountType amountType;

    private Double value;

    public enum ComponentType {
        Allowance, Deduction
    }

    public enum AmountType {
        Fixed, Percentage
    }
}
