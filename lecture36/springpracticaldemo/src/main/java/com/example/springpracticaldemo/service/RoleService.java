package com.example.springpracticaldemo.service;


import lombok.Setter;
import org.springframework.stereotype.Service;

import com.example.springpracticaldemo.entity.Role;
import com.example.springpracticaldemo.repository.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
