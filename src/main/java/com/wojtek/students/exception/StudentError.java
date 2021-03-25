package com.wojtek.students.exception;

public enum StudentError {
    STUDENT_NOT_FOUND("Student doesn't exist");

    private String message;

    StudentError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }



}
