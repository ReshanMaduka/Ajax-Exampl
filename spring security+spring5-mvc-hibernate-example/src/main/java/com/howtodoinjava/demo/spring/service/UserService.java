package com.howtodoinjava.demo.spring.service;

import java.util.List;

import com.howtodoinjava.demo.spring.dto.CustomerDTO;

public interface UserService {

   void saveUser(CustomerDTO customerDTO);

   List<CustomerDTO> findAllUsers();
}
