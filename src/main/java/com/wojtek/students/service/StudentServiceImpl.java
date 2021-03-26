package com.wojtek.students.service;

import com.wojtek.students.exception.StudentError;
import com.wojtek.students.exception.StudentException;
import com.wojtek.students.model.Student;
import com.wojtek.students.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(Student.Status status) {
    if(status !=null) return studentRepository.findAllByStatus(status);
    return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
    }


    public Student addStudent(Student student) {
        if(studentRepository.existsByEmail(student.getEmail()))
            throw new StudentException(StudentError.STUDENT_EMAIL_ALREADY_EXISTS);
        return studentRepository.save(student);
    }


    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
        studentRepository.delete(student);
    }

    public Student putStudent(Long id, Student student) {
        return studentRepository.findById(id)
                .map(studentFromDB ->{
                    studentFromDB.setFirstName(student.getFirstName());
                    studentFromDB.setLastName(student.getLastName());
                    if(studentRepository.existsByEmail(student.getEmail()))
                        throw new StudentException(StudentError.STUDENT_EMAIL_ALREADY_EXISTS);
                    studentFromDB.setEmail(student.getEmail());
                    studentRepository.save(studentFromDB);
                    return studentFromDB;
                }).orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
    }


    public Student patchStudent(Long id, Student student) {
        return studentRepository.findById(id)
                .map(studentFromDB -> {
                    if(!StringUtils.isEmpty(student.getFirstName())) {
                        studentFromDB.setFirstName(student.getFirstName());
                    }
                    if(!StringUtils.isEmpty(student.getLastName())) {
                        studentFromDB.setLastName(student.getLastName());
                    }
                    return studentRepository.save(studentFromDB);
                }).orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));

    }
    }
