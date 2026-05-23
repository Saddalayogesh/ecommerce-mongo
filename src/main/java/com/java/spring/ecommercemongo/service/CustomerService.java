package com.java.spring.ecommercemongo.service;

import com.java.spring.ecommercemongo.document.Customer;
import com.java.spring.ecommercemongo.dto.request.LoginRequestDto;
import com.java.spring.ecommercemongo.dto.request.SignupRequestDto;
import com.java.spring.ecommercemongo.dto.response.CustomerDto;
import com.java.spring.ecommercemongo.exceptions.CustomerExistsException;
import com.java.spring.ecommercemongo.exceptions.CustomerNotFoundException;
import com.java.spring.ecommercemongo.exceptions.InvalidCredentialsException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDto save(SignupRequestDto signupRequest) throws CustomerExistsException;
    CustomerDto login(LoginRequestDto loginRequest) throws CustomerNotFoundException, InvalidCredentialsException;
    List<CustomerDto> getAll();
    CustomerDto getById(String id) throws CustomerNotFoundException;
    CustomerDto update(String id, Customer Customer) throws CustomerNotFoundException;
    void delete(String id) throws CustomerNotFoundException;

}