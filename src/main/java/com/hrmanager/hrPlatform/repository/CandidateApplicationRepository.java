package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.CandidateApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateApplicationRepository extends JpaRepository<CandidateApplication, Integer> {
    List<CandidateApplication> findByJob_JobId(Integer jobId);
}
