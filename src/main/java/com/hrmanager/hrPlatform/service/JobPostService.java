package com.hrmanager.hrPlatform.service;

import com.hrmanager.hrPlatform.DTO.JobPostDto;

import java.util.List;

public interface JobPostService {
    JobPostDto create(JobPostDto dto);
    JobPostDto update(Integer id, JobPostDto dto);
    JobPostDto findById(Integer id);
    List<JobPostDto> findAll();
    void delete(Integer id);
}
