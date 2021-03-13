package com.wojtek.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {


    private final StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    @PostMapping("/students")
    public Student addStudent (@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
