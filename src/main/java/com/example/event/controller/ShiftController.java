package com.example.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.model.Shift;
import com.example.event.services.ShiftService;

@RestController
public class ShiftController {

	@Autowired
	ShiftService service;

	@PostMapping("/shift")
	public Shift createShift(@RequestBody Shift v) throws Exception {
		return service.createShift(v);
	}

	@GetMapping("/Shift/{id}")
	public Shift getShift(@PathVariable Integer id) {
		return service.getShift(id);
	}
	
	@GetMapping("/ShiftByEventID/{eventId}")
	public List<Shift> getShiftByEventID(@PathVariable Integer eventId) throws Exception {
		return service.ShiftByEventID(eventId);
	}

	@PutMapping("/Shift")
	public Shift updateShift(@RequestBody Shift v) {
		return service.updateShift(v);
	}

	@DeleteMapping("/Shift/{id}")
	public boolean deleteShift(@PathVariable Integer id) {
		return service.deleteShift(id);
	}

}
