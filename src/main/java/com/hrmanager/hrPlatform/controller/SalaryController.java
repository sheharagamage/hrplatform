package com.hrmanager.hrPlatform.controller;

import com.hrmanager.hrPlatform.DTO.*;
import com.hrmanager.hrPlatform.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    private final SalaryComponentService componentService;
    private final SalaryStructureService structureService;

    public SalaryController(SalaryComponentService componentService,
                            SalaryStructureService structureService) {
        this.componentService = componentService;
        this.structureService = structureService;
    }

    // Salary Component
    @PostMapping("/component")
    public SalaryComponentDto createComponent(@RequestBody SalaryComponentDto dto) {
        return componentService.create(dto);
    }

    @GetMapping("/component")
    public List<SalaryComponentDto> getAllComponents() {
        return componentService.findAll();
    }

    @GetMapping("/component/{id}")
    public SalaryComponentDto getComponent(@PathVariable Integer id) {
        return componentService.findById(id);
    }

    @PutMapping("/component/{id}")
    public SalaryComponentDto updateComponent(@PathVariable Integer id,
                                              @RequestBody SalaryComponentDto dto) {
        return componentService.update(id, dto);
    }

    @DeleteMapping("/component/{id}")
    public void deleteComponent(@PathVariable Integer id) {
        componentService.delete(id);
    }

    // Salary Structure
    @PostMapping("/structure")
    public SalaryStructureDto createStructure(@RequestBody SalaryStructureDto dto) {
        return structureService.create(dto);
    }

    @GetMapping("/structure")
    public List<SalaryStructureDto> getAllStructures() {
        return structureService.findAll();
    }

    @GetMapping("/structure/{id}")
    public SalaryStructureDto getStructure(@PathVariable Integer id) {
        return structureService.findById(id);
    }

    @PutMapping("/structure/{id}")
    public SalaryStructureDto updateStructure(@PathVariable Integer id,
                                              @RequestBody SalaryStructureDto dto) {
        return structureService.update(id, dto);
    }

    @DeleteMapping("/structure/{id}")
    public void deleteStructure(@PathVariable Integer id) {
        structureService.delete(id);
    }
}
