package com.company.controller;

import com.company.model.Student;
import com.company.service.student.StudentServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    StudentServiceImpl studentService = new StudentServiceImpl();
    public List<Student> showListStudent() throws IOException {
       return studentService.findAll();
    }
    public void createStudent(Student student) throws IOException {
        studentService.save(student);
        studentService.findAll();
    }
    public List<Student> findListStudentByClassRoomId(int id) throws IOException {
        List<Student> studentList = showListStudent();
        List<Student> studentListByClassRoomId = new ArrayList<>();
        for (int i=0; i<studentList.size();i++){
            if(studentList.get(i).getClassRoom().getId()==id){
                studentListByClassRoomId.add(studentList.get(i));
            }
        }
        return studentListByClassRoomId;
    }
}
