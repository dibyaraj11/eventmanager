package com.example.event.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.model.Event;
import com.example.event.repository.EventRepository;

@Service
public class EventService 
{
	@Autowired
	EventRepository repo;
	
	public Event createEvent(Event e)
	{
		return repo.saveAndFlush(e);
	}

}
