package com.company.model;

import java.io.Serializable;
import java.util.List;

public class ClassRoom implements Serializable {
    private int id;
    private String name;
    private List<Student> studentList;
    public ClassRoom() {
    }

    public ClassRoom(int id, String name, List<Student> studentList) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
    }

    public ClassRoom(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
