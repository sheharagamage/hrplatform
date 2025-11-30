package com.hrmanager.hrPlatform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_leave_balance")
@Data
public class EmployeeLeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;

    private Integer allocatedDays;

    private Integer usedDays;

    private Integer remainingDays;

    private Integer year;
}
