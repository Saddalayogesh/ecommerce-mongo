package com.java.spring.ecommercemongo.service;

import com.java.spring.ecommercemongo.document.Customer;
import com.java.spring.ecommercemongo.dto.request.SignupRequestDto;
import com.java.spring.ecommercemongo.dto.response.CustomerDto;
import com.java.spring.ecommercemongo.enums.CustomerStatus;
import com.java.spring.ecommercemongo.exceptions.CustomerExistsException;
import com.java.spring.ecommercemongo.exceptions.CustomerNotFoundException;
import com.java.spring.ecommercemongo.repository.AddressRepository;
import com.java.spring.ecommercemongo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;


    @Override
    public CustomerDto save(SignupRequestDto signupRequestDto) throws CustomerExistsException {

        // 1. validate if customer exists
        log.info("{} signup request {}", getClass().getSimpleName(), signupRequestDto);

        customerRepository.findByEmail(signupRequestDto.getEmail()).ifPresent(Customer -> {
            throw new CustomerExistsException("Customer already exists with email: " + signupRequestDto.getEmail());
        });

        //2. Convert SignupRequest to Customer (document)
        Customer customer = modelMapper.map(signupRequestDto, Customer.class);

        //3. Save Customer
        customer.setStatus(CustomerStatus.ACTIVE);
        customer.setCreatedAt(LocalDateTime.now());

        log.info("Saving customer {}", customer);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("Saved customer {}", savedCustomer);

        //4. Convert Customer to CustomerDto
        CustomerDto customerDto = modelMapper.map(savedCustomer, CustomerDto.class);
        log.info("customerDto {}", customerDto);

        return customerDto;
    }

    @Override
    public Optional<CustomerDto> getByEmail(String email) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByEmail(email).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found with email: " + email));

        return Optional.ofNullable(modelMapper.map(customer, CustomerDto.class));
    }

    @Override
    public CustomerDto getById(String id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer Not Found"));

        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer ->
                        modelMapper.map(customer, CustomerDto.class))
                .toList();
    }

    @Override
    public CustomerDto update(String id, CustomerDto customerDto) {

        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("Customer not found with id: " + id));

        existingCustomer.setName(customerDto.getName());
        existingCustomer.setEmail(customerDto.getEmail());
        existingCustomer.setPhone(customerDto.getPhone());

        existingCustomer.setAddresses(modelMapper.map(customerDto.getAddresses(), List.class));

        return modelMapper.map(customerRepository.save(existingCustomer), CustomerDto.class);
    }

    @Override
    public void delete(String id) throws CustomerNotFoundException {

        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("Customer not found with id: " + id));
        customerRepository.delete(customer);
    }


}