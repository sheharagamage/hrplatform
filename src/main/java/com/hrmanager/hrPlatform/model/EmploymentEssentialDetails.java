package com.hrmanager.hrPlatform.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentEssentialDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer essentialId;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    private String nationalId;
    private String passportNumber;
    private String bankAccount;
    private String otherDocuments;
}
