package com.java.spring.ecommercemongo.dto.response;

import lombok.Data;

@Data
public class AddressDto {

    private String street;
    private String city;
    private String state;
    private String zipCode;
}