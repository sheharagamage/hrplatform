package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "attendance_status")
@Data
public class AttendanceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String statusName;
}
