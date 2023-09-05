package com.example.Student_Management_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
//@Slf4j
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return studentService.getStudent(regNo);
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
//        log.warn("student added successfully");
        studentService.addStudent(student);
        return "student has been added successfully";
    }
    @GetMapping("/getByPath/{id}")
    public Student getStudentByPath(@PathVariable("id") int regNo){
        return studentService.getStudent(regNo);
    }
//    @PutMapping("/update-age")
//    public Student updateAge(@RequestParam("id") int regNo, @RequestParam("age") int newAge){
//        return studentService.updateAge(regNo,newAge);
//    }

    // delete a student  --> request param
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("q") int regNo){
        studentService.deleteStudent(regNo);
        return "student deleted successfully";

    }
    // delete a student ---> path variable
    @DeleteMapping("/deleteByPath/{id}")
    public String deleteStudentByPath(@PathVariable("id") int regNo){
        studentService.deleteStudent(regNo);
        return "student deleted successfully";
    }
    // change course of a student (regNo, course)  ---> Both as request params
    @PutMapping("/course")
    public Student changeCourse(@RequestParam("id") int regNo,@RequestParam("c") String newCourse){
       return studentService.changeCourse(regNo,newCourse);
    }
    // change course of a student  ----> Both as path variables
    @PutMapping("/courseByPath/{id}/{c}")
    public Student changeCourseByPath(@PathVariable("id") int regNo,@PathVariable("c") String newCourse){
        return studentService.changeCourse(regNo,newCourse);
    }
    // change course --> One as request param, one as path variable
    @PutMapping("/courseByMix/{c}")
    public Student changeCourseByMix(@RequestParam("id") int regNo, @PathVariable("c") String newCourse){
        return studentService.changeCourse(regNo,newCourse);
    }
    // change course and age ---> regNo as request param, entire student object as request body
    @PutMapping("/courseByBody")
    public Student changeCourseByBody(@RequestParam("id") int regNo,@RequestBody Student student){
        return studentService.changeCourseByBody(regNo,student);
    }
}
