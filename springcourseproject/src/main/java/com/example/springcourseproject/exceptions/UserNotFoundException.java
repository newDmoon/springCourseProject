package com.example.springcourseproject.exceptions;

import java.util.function.Supplier;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
