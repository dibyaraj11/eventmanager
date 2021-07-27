package com.example.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

}
