package com.hrmanager.hrPlatform.repository;

import com.hrmanager.hrPlatform.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> { }
