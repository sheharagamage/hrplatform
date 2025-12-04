package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class JobPostDto {

    private Integer jobId;
    private String title;
    private String description;
    private String requirements;
    private String status;
}
