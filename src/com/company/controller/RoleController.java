package com.company.controller;

import com.company.model.Role;
import com.company.service.role.RoleServiceImpl;

import java.io.IOException;
import java.util.List;

public class RoleController {
    RoleServiceImpl roleService = new RoleServiceImpl();
    public List<Role> showListRole() throws IOException {
        return roleService.findAll();
    }
    public void createRole(Role role) throws IOException {
        roleService.save(role);
        showListRole();
    }
}
