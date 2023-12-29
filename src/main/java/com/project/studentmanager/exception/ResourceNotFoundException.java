package com.project.studentmanager.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id){
        super(String.format("Student with id %d was not found", id));
    }

}
