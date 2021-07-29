package com.example.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.event.model.Volunteer;

@Repository
public interface VolunteerRepository extends CrudRepository<Volunteer, String>{
	
	

}
