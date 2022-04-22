package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Customerrepo extends JpaRepository<Customer,Integer> {

}
