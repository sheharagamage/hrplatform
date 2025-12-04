package com.hrmanager.hrPlatform.controller;

import com.hrmanager.hrPlatform.DTO.AttendanceSourceDto;
import com.hrmanager.hrPlatform.service.AttendanceSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance-source")
@RequiredArgsConstructor
public class AttendanceSourceController {

    private final AttendanceSourceService service;

    @PostMapping
    public AttendanceSourceDto create(@RequestBody AttendanceSourceDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<AttendanceSourceDto> getAll() {
        return service.getAll();
    }
}
