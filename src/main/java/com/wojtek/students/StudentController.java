package com.wojtek.students;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/helloo")
    public String sayHello(){
        return "Welcome!";
    }
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student();
        student.setFirstName("Wojciech");
        student.setLastName("Olejarz");
        student.setEmail("hhh@fff.com");
        return student;
    }
}
