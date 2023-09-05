package com.example.Student_Management_App;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentManagementAppApplicationTests {

	@Autowired
	StudentService studentService;
	@BeforeEach
	public void prepare(){
		studentService.addStudent(new Student(1,"rahul1",3,"hem",25));
		studentService.addStudent(new Student(2,"rahul2",2,"chem",23));
		studentService.addStudent(new Student(3,"rahu3",4,"em",24));
	}
	@Test
	void contextLoads() {
	}
	@Test
	public void addStudentTest(){
		Student student=new Student(1,"rahul",2,"chem",23);
		studentService.addStudent(student);
		Student expectedOutput=new Student(1,"rahul",2,"chem",23);
		Student actualOutput=studentService.getStudent(1);
		Assertions.assertEquals(expectedOutput.getAge(),actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(),actualOutput.getCourse());
		Assertions.assertEquals(expectedOutput.getName(),actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getRollNo(),actualOutput.getRollNo());

	}
	@Test
	public void getStudentTest(){
		Student expectedOutput=new Student(2,"rahul2",2,"chem",23);
		Student actualOutput=studentService.getStudent(2);
		Assertions.assertEquals(expectedOutput.getAge(),actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(),actualOutput.getCourse());
		Assertions.assertEquals(expectedOutput.getName(),actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getRollNo(),actualOutput.getRollNo());
	}

}
