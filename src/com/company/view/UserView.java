package com.company.view;

import com.company.controller.UserController;
import com.company.dto.request.Register;
import com.company.file.Path;
import com.company.model.User;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserView {
    UserController userController = new UserController();
    List<User> userList = userController.showListUser();

    public UserView() throws IOException {
    }
    public void viewRegister() throws IOException {
        int id;
        if(userList.size()==0){
            id=1;
        } else {
            id = userList.get(userList.size()-1).getId()+1;
        }
        System.out.println("Enter username: ");
        String username = Path.scanner().nextLine();
        System.out.println("Enter password: ");
        String password = Path.scanner().nextLine();
        System.out.println("Enter Role: ");
        String role = Path.scanner().nextLine();
        Set<String> roles = new HashSet<>();
        roles.add(role);
        Register register = new Register(id,username,password,roles);
        userController.register(register);
        String back = Path.scanner().nextLine();
        if(back.equalsIgnoreCase("quit")){
            new Main();
        }
    }
    public void showListUser() throws IOException {
        System.out.println(userList);
        System.out.println("Enter the any key to continue create - Enter QUIT to come back MENU: ");
        String back = Path.scanner().nextLine();
        if(back.equalsIgnoreCase("quit")){
            new Main();
        }
    }
}
