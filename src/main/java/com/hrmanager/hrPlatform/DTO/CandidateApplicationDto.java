package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class CandidateApplicationDto {

    private Integer candidateId;
    private Integer jobId;
    private String name;
    private String email;
    private String resumePath;
    private String status;
}
