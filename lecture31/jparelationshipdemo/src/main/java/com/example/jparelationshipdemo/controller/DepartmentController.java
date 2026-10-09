package com.example.jparelationshipdemo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jparelationshipdemo.model.Department;
import com.example.jparelationshipdemo.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(
            @RequestBody Department department) {

        departmentService.createDepartment(department);
        return ResponseEntity.ok("DONE");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(
            @PathVariable Long id) {

        departmentService.removeDepartment(id);
        return ResponseEntity.ok("DONE");
    }
}
