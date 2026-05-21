package com.java.spring.ecommercemongo.exceptions;

public class CustomerExistsException extends RuntimeException {
    public CustomerExistsException(String message) {
        super(message);
    }
}
