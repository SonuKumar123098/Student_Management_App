package com.example.Student_Management_App;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class StudentRepository {
    Map<Integer,Student> db=new HashMap<>();

    public Student getStudent(int regNo) {
        return db.get(regNo);
    }

    public void addStudent(Student student) {
        db.put(student.getRegNo(),student);
    }

    public void deleteStudent(int regNo) {
        if(db.containsKey(regNo)){
            db.remove(regNo);
        }
    }

    public Student changeCourse(int regNo, String newCourse) {
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }

    public Student changeCourseByBody(int regNo, Student student) {
        db.get(regNo).setCourse(student.getCourse());
        return db.get(regNo);
    }
}
