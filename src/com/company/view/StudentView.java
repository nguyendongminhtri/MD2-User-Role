package com.company.view;

import com.company.controller.ClassRoomController;
import com.company.controller.StudentController;
import com.company.file.Path;
import com.company.model.ClassRoom;
import com.company.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    StudentController studentController = new StudentController();
    ClassRoomController classRoomController = new ClassRoomController();
    List<Student> studentList = studentController.showListStudent();
    public StudentView() throws IOException {
    }
    public void viewListStudent() throws IOException {
        System.out.println(studentList);
        System.out.println("Enter QUIT to come back MENU: ");
        String back = Path.scanner().nextLine();
        if(back.equalsIgnoreCase("quit")){
            new Main();
        }
    }
    public void viewCreateStudent() throws IOException {
        while (true){
            int id;
            if(studentList.size()==0){
              id = 1;
            } else {
                id = studentList.get(studentList.size()-1).getId()+1;
            }
            System.out.println("Enter the name Student: ");
            String name = Path.scanner().nextLine();
            System.out.println("Enter the age: ");
            int age = Integer.parseInt(Path.scanner().nextLine());
            System.out.println("Select id of Class Room: ");
            int id_Class_Room = Path.scanner().nextInt();
            ClassRoom classRoom = classRoomController.detailClassRoom(id_Class_Room);
            Student student = new Student(id, name,age,classRoom);
            studentController.createStudent(student);
            System.out.println("Enter the any key to continue create - Enter QUIT to come back MENU: ");
            String back = Path.scanner().nextLine();
            if(back.equalsIgnoreCase("quit")){
                new Main().studentView();
            }
        }
    }
}
