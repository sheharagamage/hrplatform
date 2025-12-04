package com.hrmanager.hrPlatform.controller;

import com.hrmanager.hrPlatform.DTO.LeaveStatusDto;
import com.hrmanager.hrPlatform.service.LeaveStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-status")
@RequiredArgsConstructor
public class LeaveStatusController {

    private final LeaveStatusService service;

    @PostMapping
    public ResponseEntity<LeaveStatusDto> create(@RequestBody LeaveStatusDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveStatusDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<LeaveStatusDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
