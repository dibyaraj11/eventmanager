package com.example.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.event.model.EventShiftVolunteerIdentity;
import com.example.event.model.ShiftRegistration;

@Repository
public interface ShiftRegistrationRepository extends CrudRepository<ShiftRegistration, EventShiftVolunteerIdentity>{

}
