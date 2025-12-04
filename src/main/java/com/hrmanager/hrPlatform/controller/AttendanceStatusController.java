package com.hrmanager.hrPlatform.controller;

import com.hrmanager.hrPlatform.DTO.AttendanceStatusDto;
import com.hrmanager.hrPlatform.service.AttendanceStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance-status")
@RequiredArgsConstructor
public class AttendanceStatusController {

    private final AttendanceStatusService service;

    @PostMapping
    public AttendanceStatusDto create(@RequestBody AttendanceStatusDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<AttendanceStatusDto> getAll() {
        return service.getAll();
    }
}
