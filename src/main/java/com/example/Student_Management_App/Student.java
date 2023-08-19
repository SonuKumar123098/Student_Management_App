package com.example.Student_Management_App;

public class Student {
    private int regNo;
    private String name;
    private int rollNo;
    private String course;
    private int age;

    public Student() {
    }

    public Student(int regNo, String name, int rollNo, String course, int age) {

        this.regNo = regNo;
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.age = age;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
