package com.wojtek.students.controller;


import com.wojtek.students.model.Student;
import com.wojtek.students.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) Student.Status status) {
        return studentService.getStudents(status);
    }

        @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody @Valid Student student) {
        return studentService.addStudent(student);
    }


    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);

    }
    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/id")
    public Student putStudent(@PathVariable Long Id,@Valid @RequestBody Student student) {
        return studentService.putStudent(Id, student);
    }
    @PatchMapping("/id")
    public Student patchStudent(@PathVariable Long Id, @RequestBody Student student) {
        return studentService.patchStudent(Id, student);
    }
}
