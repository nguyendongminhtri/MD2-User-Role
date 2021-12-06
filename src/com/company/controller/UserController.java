package com.company.controller;

import com.company.dto.request.Register;
import com.company.dto.response.ResponseMessage;
import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.User;
import com.company.service.role.RoleServiceImpl;
import com.company.service.user.UserServiceImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    UserServiceImpl userService = new UserServiceImpl();
    RoleServiceImpl roleService = new RoleServiceImpl();
    public List<User> showListUser() throws IOException {
        return userService.findAll();
    }
    public ResponseMessage register(Register register) throws IOException {
        List<User> userList = showListUser();
        System.out.println("userList === "+userList.size());
        if(userList.size()!=0){
            for (int i = 0; i < userList.size(); i++) {
                if(register.getUsername().equals(userList.get(i).getUsername())){
                    return new ResponseMessage("user_existed");
                }
            }
        }
        Set<String> strRoles = register.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role->{
            switch (role){
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN);
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM);
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER);
                    roles.add(userRole);
            }
        });
        User user = new User(register.getId(),register.getUsername(),register.getPassword(),roles);
        userService.save(user);
        showListUser();
        return new ResponseMessage("register_success");
    }
}
