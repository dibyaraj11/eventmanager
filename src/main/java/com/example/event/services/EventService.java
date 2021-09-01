package com.example.event.services;

import java.util.List;
import java.util.Optional;

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
		return repo.save(e);
	}

	public Event getEventbyId(int id) {
		Optional<Event> e= repo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		else
		{
			return null;
		}
	}

	public Event updateEventById(Event e) {
		return repo.save(e);
	}

	public boolean deleteEventbyId(int id) {
		
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		return false;
		
		
	}

	public Iterable<Event> getEvenList()
	{
		return repo.findAll();

	}

}
