package com.java.spring.ecommercemongo.document;

import com.java.spring.ecommercemongo.enums.CustomerStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private CustomerStatus status;
    private LocalDateTime createdAt;

    private List<Address> addresses;
}