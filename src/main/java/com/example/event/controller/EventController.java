package com.example.event.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Event;

@RestController
public class EventController 
{	
	@PostMapping("/event")
	public Event createEvent(@RequestBody Event e)
	{
		return null;
	}

}
