package com.java.spring.ecommercemongo.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    private String id;

    private String name;
    private String email;
    private String phone;

    private List<AddressDto> addresses;
}