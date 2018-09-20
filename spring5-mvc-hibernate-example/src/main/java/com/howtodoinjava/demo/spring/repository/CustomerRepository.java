package com.howtodoinjava.demo.spring.repository;

import com.howtodoinjava.demo.spring.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Reshan on 20/09/2018.
 */
public interface CustomerRepository extends JpaRepository<Customers,Integer> {
}
