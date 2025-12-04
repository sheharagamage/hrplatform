package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SalaryComponent")
public class SalaryComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer componentId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ComponentType type;   // Allowance / Deduction

    @Enumerated(EnumType.STRING)
    private AmountType amountType; // Fixed / Percentage

    private Double value;

    public enum ComponentType {
        Allowance,
        Deduction
    }

    public enum AmountType {
        Fixed,
        Percentage
    }
}
