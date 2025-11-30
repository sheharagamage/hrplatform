package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.CandidateApplicationDto;
import com.hrmanager.hrPlatform.mapper.RecruitmentPayrollMapper;
import com.hrmanager.hrPlatform.model.CandidateApplication;
import com.hrmanager.hrPlatform.model.JobPost;
import com.hrmanager.hrPlatform.repository.CandidateApplicationRepository;
import com.hrmanager.hrPlatform.repository.JobPostRepository;
import com.hrmanager.hrPlatform.service.CandidateApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateApplicationServiceImpl implements CandidateApplicationService {

    private final CandidateApplicationRepository repo;
    private final JobPostRepository jobRepo;
    private final RecruitmentPayrollMapper mapper;

    @Override
    public CandidateApplicationDto apply(CandidateApplicationDto dto) {
        CandidateApplication ent = mapper.toEntity(dto);
        if (dto.getJobId() != null) {
            JobPost job = jobRepo.findById(dto.getJobId()).orElseThrow(() -> new RuntimeException("Job not found"));
            ent.setJob(job);
        }
        CandidateApplication saved = repo.save(ent);
        return mapper.toDto(saved);
    }

    @Override
    public CandidateApplicationDto findById(Integer id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Application not found"));
    }

    @Override
    public List<CandidateApplicationDto> findByJobId(Integer jobId) {
        return repo.findByJob_JobId(jobId).stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id)) throw new RuntimeException("Application not found");
        repo.deleteById(id);
    }
}
