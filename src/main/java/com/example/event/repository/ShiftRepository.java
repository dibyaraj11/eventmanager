package com.example.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.event.model.Shift;

@Repository
public interface ShiftRepository extends CrudRepository<Shift, Integer> {
	
	@Query("SELECT u FROM Shift u WHERE u.eventId = :id")
	List<Shift> findShiftByEventId(@Param("id") Integer id);


}
