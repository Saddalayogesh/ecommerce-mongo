package com.java.spring.ecommercemongo.dto.request;

import com.java.spring.ecommercemongo.document.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SignupRequestDto {

    private String name;
    private String email;
    private String password;
    private String phone;

    private List<Address> addresses;
}