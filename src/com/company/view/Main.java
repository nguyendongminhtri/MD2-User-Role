package com.company.view;

import com.company.file.Path;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    //    Scanner scanner = new Scanner(System.in);
    public Main() throws IOException {
        System.out.println("-------MY MENU MANAGE -------");
        System.out.println("1.Class Room Manage: \n" + "2.Student Manage: \n"+"3.Role Manage: \n");
        int chooseMenu = Path.scanner().nextInt();
        switch (chooseMenu) {
            case 1:
                classRoomView();
                break;
            case 2:
                studentView();
                break;
            case 3:
                roleView();
            case 4:
                userView();
                break;
        }
    }

    public void classRoomView() throws IOException {
        ClassRoomView roomView = new ClassRoomView();
        System.out.println("-------CLASS ROOM MANAGE -------");
        System.out.println("1. Show List Class Room: \n"
                + "2. Create Class Room: \n"+
                "3.Detail Class Room: \n"+
                "0.Exit"
        );
        int chooseMenuClassRoom = Path.scanner().nextInt();
        switch (chooseMenuClassRoom) {
            case 0:
                new Main();
                break;
            case 1:
                roomView.viewListClassRoom();
                break;
            case 2:
                roomView.viewCreateClassRoom();
                break;
            case 3:
                roomView.viewDetailClassRoom();
                break;

        }
    }

    public void studentView() throws IOException {
        StudentView studentView = new StudentView();
        System.out.println("-------STUDENT VIEW MANAGE -------");
        System.out.println("1. Show List Student: \n"
                + "2.Create Student:\n"+
                "0.Exit"
        );
        int chooseMenuClassRoom = Path.scanner().nextInt();
        switch (chooseMenuClassRoom) {
            case 0:
                new Main();
                break;
            case 1:
                studentView.viewListStudent();
                break;
            case 2:
                studentView.viewCreateStudent();
                break;
        }
    }
    public void roleView() throws IOException {
        RoleView roleView = new RoleView();
        System.out.println("-------ROLE VIEW MANAGE -------");
        System.out.println("1. Show List Role: \n"
                + "2.Create Role:\n"+
                "0.Exit"
        );
        int chooseMenuClassRoom = Path.scanner().nextInt();
        switch (chooseMenuClassRoom) {
            case 0:
                new Main();
                break;
            case 1:
                roleView.viewRole();
                break;
            case 2:
                roleView.viewCreateRole();
                break;
        }
    }
    public void userView() throws IOException {
        UserView userView = new UserView();
        System.out.println("-------USER VIEW MANAGE -------");
        System.out.println("1. Show List User: \n"
                + "2.Create User:\n"+
                "0.Exit"
        );
        int chooseMenuUser = Path.scanner().nextInt();
        switch (chooseMenuUser) {
            case 0:
                new Main();
                break;
            case 1:
                userView.showListUser();
                break;
            case 2:
                userView.viewRegister();
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main();
        // write your code here
    }
}
