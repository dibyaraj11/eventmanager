package com.example.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.model.ShiftRegistration;
import com.example.event.services.ShiftRegistrationService;
import com.example.event.services.ShiftService;



@RestController
public class ShiftRegistrationController {
	
	@Autowired
	ShiftRegistrationService service;
	
	@PostMapping("/ShiftRegistration")
	public ShiftRegistration createShift(@RequestBody ShiftRegistration e)
	{
		return service.createShiftRegistration(e);
	}
	
	@PostMapping("/ShiftRegistration/isExist")
	public Boolean isShiftAlreadyExist(@RequestBody ShiftRegistration e)
	{
		return service.isShiftAlreadyExist(e);
	}
	
	@DeleteMapping("/ShiftRegistration")
	public Boolean deleteShift(@RequestBody ShiftRegistration e)
	{
		return service.deleteShift(e);
	}
	

}
