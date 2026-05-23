package com.java.spring.ecommercemongo.controller;

import com.java.spring.ecommercemongo.document.Customer;
import com.java.spring.ecommercemongo.dto.request.LoginRequestDto;
import com.java.spring.ecommercemongo.dto.request.SignupRequestDto;
import com.java.spring.ecommercemongo.dto.response.CustomerDto;
import com.java.spring.ecommercemongo.exceptions.CustomerNotFoundException;
import com.java.spring.ecommercemongo.exceptions.InvalidCredentialsException;
import com.java.spring.ecommercemongo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody SignupRequestDto signupRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(signupRequestDto));
    }



    // LOGIN CUSTOMER
    @PostMapping("/login")
    public ResponseEntity<CustomerDto> login(
            @RequestBody LoginRequestDto loginRequest)
            throws CustomerNotFoundException,
            InvalidCredentialsException {

        return ResponseEntity.ok(
                customerService.login(loginRequest)
        );
    }

    // GET ALL CUSTOMERS
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {

        return ResponseEntity.ok(
                customerService.getAll()
        );
    }

    // GET CUSTOMER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(
            @PathVariable String id)
            throws CustomerNotFoundException {

        return ResponseEntity.ok(
                customerService.getById(id)
        );
    }

    // UPDATE CUSTOMER
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(
            @PathVariable String id,
            @RequestBody Customer Customer)
            throws CustomerNotFoundException {

        return ResponseEntity.ok(
                customerService.update(id,
                        Customer)
        );
    }

    // DELETE CUSTOMER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id)
            throws CustomerNotFoundException {

        customerService.delete(id);

        return ResponseEntity.noContent().build();
    }


}