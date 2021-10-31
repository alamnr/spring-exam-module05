package com.spring.professional.exam.tutorial.module05.question09.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module05.question09.ds.Address;

public interface AddressDao extends CrudRepository<Address, Integer> {

}
