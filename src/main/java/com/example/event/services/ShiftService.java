package com.example.event.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.model.Shift;
import com.example.event.repository.EventRepository;
import com.example.event.repository.ShiftRepository;

@Service
public class ShiftService {

	@Autowired
	ShiftRepository repo;

	@Autowired
	EventRepository eventRepo;
	public Shift createShift(Shift v) throws Exception {
		// TODO Auto-generated method stub
		if(eventRepo.existsById(v.getEventId()))
		{
			return repo.save(v);
		}
		else
		{
			throw new Exception("EventId does not exist");
		}

	}

	public Shift getShift(Integer id) {
		// TODO Auto-generated method stub
		Optional<Shift> s= repo.findById(id);
		if(s.isPresent())
		{
			return s.get();
		}
		else
		{
			return null;
		}

	}

	public Shift updateShift(Shift v) {
		// TODO Auto-generated method stub
		return repo.save(v);
	}

	public boolean deleteShift(Integer id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Shift> ShiftByEventID(Integer eventId) throws Exception {
		if(eventRepo.existsById(eventId))
		{
			return repo.findShiftByEventId(eventId);
		}
		return null;
	}

	public Iterable<Shift> getShiftList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
