package com.example.Student_Management_App;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    Map<Integer,Student> db=new HashMap<>();
    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return db.get(regNo);
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        db.put(student .getRegNo(),student);
        return "student has been added successfully";
    }
    @GetMapping("/getByPath/{id}")
    public Student getStudentByPath(@PathVariable("id") int regNo){
        return db.get(regNo);
    }
//    @PutMapping("/update-age")
//    public Student updateAge(@RequestParam("id") int regNo, @RequestParam("age") int newAge){
//        return studentService.updateAge(regNo,newAge);
//    }

    // delete a student  --> request param
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("q") int regNo){
        if(db.containsKey(regNo)){
            db.remove(regNo);
        }
        return "student deleted successfully";
    }
    // delete a student ---> path variable
    @DeleteMapping("/delete/{id}")
    public String deleteStudentByPath(@PathVariable("id") int regNo){
        if(db.containsKey(regNo)){
            db.remove(regNo);
        }
        return "student deleted successfully";
    }
    // change course of a student (regNo, course)  ---> Both as request params
    @PutMapping("/course")
    public Student changeCourse(@RequestParam("id") int regNo,@RequestParam("c") String newCourse){
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }
    // change course of a student  ----> Both as path variables
    @PutMapping("/course/{id}/{c}")
    public Student changeCourseByPath(@PathVariable("id") int regNo,@PathVariable("c") String newCourse){
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }
    // change course --> One as request param, one as path variable
    @PutMapping("/course/{c}")
    public Student changeCourseByMix(@RequestParam("id") int regNo, @PathVariable("c") String newCourse){
        db.get(regNo).setCourse(newCourse);
        return db.get(regNo);
    }
    // change course and age ---> regNo as request param, entire student object as request body
    @PutMapping("/course")
    public Student changeCourseByBody(@RequestParam("id") int regNo,@RequestBody Student student){
        db.get(regNo).setCourse(student.getCourse());
        return db.get(regNo);
    }
}
