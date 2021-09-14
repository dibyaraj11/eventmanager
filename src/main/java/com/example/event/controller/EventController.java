package com.example.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.model.Event;
import com.example.event.services.EventService;

@RestController
public class EventController 
{	
	@Autowired
	EventService service;
	
	
	@PostMapping("/event")
	public Event createEvent(@RequestBody Event e)
	{
		return service.createEvent(e);
	}
	
	@GetMapping("/event/{id}")
	public Event getEventbyId(@PathVariable int id)
	{
		return service.getEventbyId(id);
	}
	@GetMapping("/event")
	public Iterable<Event> getEventList()
	{
		return service.getEvenList();
	}
	@PutMapping("/event")
	public Event updateEventById(@RequestBody Event e)
	{
		return service.updateEventById(e);
	}
	@DeleteMapping("/event/{id}")
	public boolean deleteEventbyId(@PathVariable int id)
	{
		 return service.deleteEventbyId(id);
	}

}
