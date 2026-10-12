package com.example.springpracticaldemo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springpracticaldemo.entity.Role;
import com.example.springpracticaldemo.service.RoleService;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private RoleService rolesService;

    public RoleController(RoleService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping
    public ResponseEntity<String> addRole(@RequestBody Role role) {
        rolesService.addRole(role);
        return ResponseEntity.ok("DONE");
    }
}
