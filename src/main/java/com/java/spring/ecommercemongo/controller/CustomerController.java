package com.java.spring.ecommercemongo.controller;

import com.java.spring.ecommercemongo.dto.request.SignupRequestDto;
import com.java.spring.ecommercemongo.dto.response.CustomerDto;
import com.java.spring.ecommercemongo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody SignupRequestDto signupRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(signupRequestDto));
    }


}