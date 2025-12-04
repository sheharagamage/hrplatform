package com.hrmanager.hrPlatform.mapper;

import com.hrmanager.hrPlatform.DTO.*;
import com.hrmanager.hrPlatform.model.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RecruitmentPayrollMapper {

    // Payroll
    @Mapping(target = "employeeId", source = "employee.employeeId")
    PayrollDto toDto(Payroll payroll);

    @Mapping(target = "employee", ignore = true)
    Payroll toEntity(PayrollDto dto);

    // Payslip
    @Mapping(target = "payrollId", source = "payroll.payrollId")
    PayslipDto toDto(Payslip payslip);

    @Mapping(target = "payroll", ignore = true)
    Payslip toEntity(PayslipDto dto);

    // JobPost
    @Mapping(target = "status", expression = "java(post.getStatus().name())")
    JobPostDto toDto(JobPost post);

    @Mapping(target = "status", expression = "java(JobPost.Status.valueOf(dto.getStatus()))")
    JobPost toEntity(JobPostDto dto);

    // CandidateApplication
    @Mapping(target = "jobId", source = "job.jobId")
    @Mapping(target = "status", expression = "java(app.getStatus().name())")
    CandidateApplicationDto toDto(CandidateApplication app);

    @Mapping(target = "job", ignore = true)
    @Mapping(target = "status", expression = "java(CandidateApplication.Status.valueOf(dto.getStatus()))")
    CandidateApplication toEntity(CandidateApplicationDto dto);
}
