package com.hrmanager.hrPlatform.controller;

import com.hrmanager.hrPlatform.DTO.EmployeeLeaveBalanceDto;
import com.hrmanager.hrPlatform.service.EmployeeLeaveBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-balances")
@RequiredArgsConstructor
public class EmployeeLeaveBalanceController {

    private final EmployeeLeaveBalanceService service;

    @PostMapping
    public ResponseEntity<EmployeeLeaveBalanceDto> create(@RequestBody EmployeeLeaveBalanceDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeLeaveBalanceDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeLeaveBalanceDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeLeaveBalanceDto> update(@PathVariable Long id, @RequestBody EmployeeLeaveBalanceDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
