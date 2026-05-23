package com.java.spring.ecommercemongo.document;

import com.java.spring.ecommercemongo.enums.CustomerStatus;
import com.java.spring.ecommercemongo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor

@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Gender gender;
    private LocalDateTime createdDate;
    private List<Address> addresses;
}