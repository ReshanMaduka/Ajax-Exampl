package com.howtodoinjava.demo.spring.service.impl;

import com.howtodoinjava.demo.spring.dto.CustomerDTO;
import com.howtodoinjava.demo.spring.entity.Customers;
import com.howtodoinjava.demo.spring.repository.CustomerRepository;
import com.howtodoinjava.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reshan on 20/09/2018.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private CustomerRepository customerRepository;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(CustomerDTO customerDTO){
        customerRepository.save(new Customers(customerDTO.getName(), customerDTO.getEmail()));
    }

    @Override
    public List<CustomerDTO> findAllUsers() {
        List<Customers> customersList =customerRepository.findAll();
        List<CustomerDTO>dtoList=new ArrayList<>();
        for (Customers customers : customersList){
            dtoList.add(new CustomerDTO(customers.getId(), customers.getName(), customers.getEmail()));
        }
        return dtoList;
    }
}
