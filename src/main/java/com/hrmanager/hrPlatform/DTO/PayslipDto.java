package com.hrmanager.hrPlatform.DTO;

import lombok.Data;

@Data
public class PayslipDto {

    private Integer payslipId;
    private Integer payrollId;
    private String pdfPath;
}
