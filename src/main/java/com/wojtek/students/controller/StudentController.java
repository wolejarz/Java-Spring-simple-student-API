package com.wojtek.students.controller;

import com.wojtek.students.repository.StudentRepository;
import com.wojtek.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody @Valid Student student) {
        return studentRepository.save(student);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
        try {
            studentRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
        }
    }
    @PutMapping("/id")
    public ResponseEntity<Student> putStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentRepository.findById(id)
                .map(studentFromDB ->{
                    studentFromDB.setFirstName(student.getFirstName());
                    studentFromDB.setLastName(student.getLastName());
                    studentFromDB.setEmail(student.getEmail());
                    studentRepository.save(studentFromDB);
                    return ResponseEntity.ok().body(studentFromDB);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
