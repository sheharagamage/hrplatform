package com.hrmanager.hrPlatform.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeaveStatusDto {
    private Long approvalId;
    private Long leaveId;
    private Long approvedBy; // employee id
    private String action;
    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime actionDate;
}
