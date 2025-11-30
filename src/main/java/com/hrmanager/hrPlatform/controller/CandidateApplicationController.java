package com.hrmanager.hrPlatform.controller;

import com.hrmanager.hrPlatform.DTO.CandidateApplicationDto;
import com.hrmanager.hrPlatform.service.CandidateApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class CandidateApplicationController {

    private final CandidateApplicationService service;

    @PostMapping
    public ResponseEntity<CandidateApplicationDto> apply(@RequestBody CandidateApplicationDto dto) {
        return ResponseEntity.ok(service.apply(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateApplicationDto> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<CandidateApplicationDto>> getByJob(@PathVariable Integer jobId) {
        return ResponseEntity.ok(service.findByJobId(jobId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
