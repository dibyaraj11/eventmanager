package com.example.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.event.model.LoginDetails;

@Repository
public interface LoginDetailsRepository extends CrudRepository<LoginDetails, String>{

}
