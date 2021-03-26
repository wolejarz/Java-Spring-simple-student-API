package com.wojtek.students.service;

import com.wojtek.students.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents(Student.Status status);
    Student addStudent(Student student);
    void deleteStudent(Long id);
    Student putStudent(Long id, Student student);
    Student patchStudent(Long id, Student student);
    Student getStudent(Long id);
}
