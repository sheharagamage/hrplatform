package com.hrmanager.hrPlatform.controller;

import com.hrmanager.hrPlatform.DTO.AttendanceDto;
import com.hrmanager.hrPlatform.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService service;

    @PostMapping
    public AttendanceDto create(@RequestBody AttendanceDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<AttendanceDto> getAll() {
        return service.getAll();
    }
}
