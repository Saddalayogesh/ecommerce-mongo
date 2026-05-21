package com.java.spring.ecommercemongo.repository;

import com.java.spring.ecommercemongo.document.Address;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AddressRepository extends MongoRepository<Address, String> {

}
