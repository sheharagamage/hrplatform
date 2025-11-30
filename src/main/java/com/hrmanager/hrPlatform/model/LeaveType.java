package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "leave_type")
@Data
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveTypeId;

    private String typeName;

    private String description;

    private Integer maxDaysPerYear;

    private Boolean isPaid;

    private Boolean isActive;
}
