package com.hrmanager.hrPlatform.controller;

import com.hrmanager.hrPlatform.DTO.LeaveApplicationDto;
import com.hrmanager.hrPlatform.service.LeaveApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-applications")
@RequiredArgsConstructor
public class LeaveApplicationController {

    private final LeaveApplicationService service;

    @PostMapping
    public ResponseEntity<LeaveApplicationDto> create(@RequestBody LeaveApplicationDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveApplicationDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<LeaveApplicationDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveApplicationDto> update(@PathVariable Long id, @RequestBody LeaveApplicationDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
