package com.company.view;

import com.company.controller.ClassRoomController;
import com.company.controller.StudentController;
import com.company.file.Path;
import com.company.model.ClassRoom;
import com.company.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ClassRoomView {
    ClassRoomController classRoomController = new ClassRoomController();
    StudentController studentController = new StudentController();
    List<ClassRoom> classRoomList = classRoomController.showListClassRoom();
    public ClassRoomView() throws IOException {
    }

    public void viewListClassRoom() throws IOException {
        System.out.println(classRoomList);
        System.out.println("Enter QUIT to come back MENU: ");
        String back = Path.scanner().nextLine();
        if(back.equalsIgnoreCase("quit")){
            new Main().classRoomView();
        }
    }
    public void viewCreateClassRoom() throws IOException {
        while (true){
            int id;
            if(classRoomList.size()==0){
                id = 1;
            } else {
                id = classRoomList.get(classRoomList.size()-1).getId()+1;
            }
            System.out.println("Enter the name Student: ");
            String name = Path.scanner().nextLine();
            ClassRoom classRoom = new ClassRoom(id, name);
            classRoomController.createClassRoom(classRoom);
            System.out.println("Enter the any key to continue create - Enter QUIT to come back MENU: ");
            String back = Path.scanner().nextLine();
            if(back.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }
    public void  viewDetailClassRoom() throws IOException {
        while (true){
            System.out.println("Enter id Class Room: ");
            int id = Path.scanner().nextInt();
            ClassRoom classRoom = classRoomController.detailClassRoom(id);
            System.out.println("-------CLASS: "+classRoom.getName()+"----------");
            System.out.println("----->ALL STUDENT OF CLASS<--------");
            System.out.println(studentController.findListStudentByClassRoomId(id));
            System.out.println("Enter any key to continue detail - Enter QUIT back MANAGE CLASS");
            String back = Path.scanner().nextLine();
            if(back.equalsIgnoreCase("quit")){
                new Main();
            }
        }

    }
}
