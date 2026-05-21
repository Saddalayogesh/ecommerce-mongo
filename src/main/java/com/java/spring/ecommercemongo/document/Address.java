package com.java.spring.ecommercemongo.document;

import lombok.Data;

@Data
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;

}