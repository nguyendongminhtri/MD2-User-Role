package com.company.service.student;

import com.company.config.ConfigReadAndWriteFile;
import com.company.file.Path;
import com.company.model.Student;
import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    ConfigReadAndWriteFile<Student> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    public String PATH_STUDENT = Path.PATH+"student.txt";
    List<Student> studentList = configReadAndWriteFile.readFromFile(PATH_STUDENT);

    @Override
    public List<Student> findAll() throws IOException {
        configReadAndWriteFile.writeFile(PATH_STUDENT, studentList);
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
