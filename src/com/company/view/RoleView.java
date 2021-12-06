package com.company.view;

import com.company.controller.ClassRoomController;
import com.company.controller.RoleController;
import com.company.controller.StudentController;
import com.company.file.Path;
import com.company.model.ClassRoom;
import com.company.model.Role;
import com.company.model.RoleName;

import java.io.IOException;
import java.util.List;

public class RoleView {
    RoleController roleController = new RoleController();
    List<Role> roleList = roleController.showListRole();
    public RoleView() throws IOException {
    }

    public void viewRole() throws IOException {
        System.out.println(roleList);
        System.out.println("Enter QUIT to come back MENU: ");
        String back = Path.scanner().nextLine();
        if(back.equalsIgnoreCase("quit")){
            new Main();
        }
    }
    public void viewCreateRole() throws IOException {
        while (true){
            int id;
            if(roleList.size()==0){
                id = 1;
            } else {
                id = roleList.get(roleList.size()-1).getId()+1;
            }
            System.out.println("Enter the name Role: ");
            RoleName name = RoleName.valueOf(Path.scanner().nextLine());
            Role role = new Role(id, name);
            roleController.createRole(role);
            System.out.println("Enter the any key to continue create - Enter QUIT to come back MENU: ");
            String back = Path.scanner().nextLine();
            if(back.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }
}
