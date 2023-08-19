package com.example.Student_Management_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student getStudent(int regNo) {
        return studentRepository.getStudent(regNo);
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudent(int regNo) {
        studentRepository.deleteStudent(regNo);
    }

    public Student changeCourse(int regNo, String newCourse) {
        return studentRepository.changeCourse(regNo,newCourse);
    }

    public Student changeCourseByBody(int regNo, Student student) {
        return studentRepository.changeCourseByBody(regNo,student);
    }
}
