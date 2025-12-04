package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Employee Relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    // Attendance Status Relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private AttendanceStatus status;

    // Attendance Source Relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id", nullable = false)
    private AttendanceSource source;

    @Column(nullable = false)
    private LocalDateTime attendanceDate;

    private String remarks;

    private LocalDateTime createdAt = LocalDateTime.now();
}
