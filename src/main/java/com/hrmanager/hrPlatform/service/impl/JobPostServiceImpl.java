package com.hrmanager.hrPlatform.service.impl;

import com.hrmanager.hrPlatform.DTO.JobPostDto;
import com.hrmanager.hrPlatform.mapper.RecruitmentPayrollMapper;
import com.hrmanager.hrPlatform.model.JobPost;
import com.hrmanager.hrPlatform.repository.JobPostRepository;
import com.hrmanager.hrPlatform.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostServiceImpl implements JobPostService {

    private final JobPostRepository repo;
    private final RecruitmentPayrollMapper mapper;

    @Override
    public JobPostDto create(JobPostDto dto) {
        JobPost ent = mapper.toEntity(dto);
        JobPost saved = repo.save(ent);
        return mapper.toDto(saved);
    }

    @Override
    public JobPostDto update(Integer id, JobPostDto dto) {
        JobPost existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Job post not found"));
        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setRequirements(dto.getRequirements());
        if (dto.getStatus() != null) {
            existing.setStatus(JobPost.Status.valueOf(dto.getStatus()));
        }
        JobPost saved = repo.save(existing);
        return mapper.toDto(saved);
    }

    @Override
    public JobPostDto findById(Integer id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow(() -> new RuntimeException("Job post not found"));
    }

    @Override
    public List<JobPostDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id)) throw new RuntimeException("Job post not found");
        repo.deleteById(id);
    }
}
