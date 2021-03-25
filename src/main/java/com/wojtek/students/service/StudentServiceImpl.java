package com.wojtek.students.service;

import com.wojtek.students.model.Student;
import com.wojtek.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student putStudent(Long id, Student student) {

        return studentRepository.;
    }


    public Student patchstudent(Long id, Student student) {
        return null;
    }
}
