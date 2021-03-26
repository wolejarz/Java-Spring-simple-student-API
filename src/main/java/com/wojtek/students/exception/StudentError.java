package com.wojtek.students.exception;

public enum StudentError {
    STUDENT_NOT_FOUND("Student doesn't exist"),
    STUDENT_EMAIL_ALREADY_EXISTS("Student's email already exists");

    private String message;

    StudentError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }



}
