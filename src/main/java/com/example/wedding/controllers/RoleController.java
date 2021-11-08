package com.example.wedding.controllers;

import com.example.wedding.models.Role;
import com.example.wedding.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/roles")

public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @GetMapping("/{roleId}")
    public Optional<Role> getRoleByID(@PathVariable Long roleId) {
        return roleRepository.findById(roleId);
    }
}
