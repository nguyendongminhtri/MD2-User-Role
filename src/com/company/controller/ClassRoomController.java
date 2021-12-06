package com.company.controller;

import com.company.model.ClassRoom;
import com.company.service.classroom.ClassRoomServiceServiceImpl;

import java.io.IOException;
import java.util.List;

public class ClassRoomController {
    ClassRoomServiceServiceImpl classRoomServiceService = new ClassRoomServiceServiceImpl();
    public List<ClassRoom> showListClassRoom() throws IOException {
        return classRoomServiceService.findAll();
    }
    public void createClassRoom(ClassRoom classRoom) throws IOException {
        classRoomServiceService.save(classRoom);
        classRoomServiceService.findAll();
    }
    public ClassRoom detailClassRoom(int id){
        ClassRoom classRoom = classRoomServiceService.findById(id);
        return classRoom;
    }

}
