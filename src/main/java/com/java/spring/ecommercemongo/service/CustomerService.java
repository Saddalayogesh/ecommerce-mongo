package com.java.spring.ecommercemongo.service;

import com.java.spring.ecommercemongo.dto.request.SignupRequestDto;
import com.java.spring.ecommercemongo.dto.response.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDto save(SignupRequestDto signupRequestDto);

    Optional<CustomerDto> getByEmail(String email);

    CustomerDto getById(String id);

    List<CustomerDto> getAllCustomers();

    CustomerDto update(String id, CustomerDto customerDto);

    void delete(String id);
}