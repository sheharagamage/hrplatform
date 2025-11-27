package com.hrmanager.hrPlatform.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designationId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

}
