package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.CandidateApplicationDto;

import java.util.List;

public interface CandidateApplicationService {
    CandidateApplicationDto apply(CandidateApplicationDto dto);
    CandidateApplicationDto findById(Integer id);
    List<CandidateApplicationDto> findByJobId(Integer jobId);
    void delete(Integer id);
}
