package com.example.event.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.model.LoginDetails;
import com.example.event.repository.LoginDetailsRepository;

@Service
public class LoginDetailsService {

	@Autowired
	LoginDetailsRepository repo;
	
	
	/*
	 *  validate credentials during login
	 */
	public boolean validateCredentails(LoginDetails cred) {
		Iterable<LoginDetails> details= repo.findAll();
		Iterator<LoginDetails> itr= details.iterator();
		while(itr.hasNext())
		{
			LoginDetails dbDtetails = itr.next();
			if(dbDtetails.getUsername().equalsIgnoreCase(cred.getUsername()) 
					&& dbDtetails.getPassword().equals(cred.getPassword())
					&& dbDtetails.getRole().equals(cred.getRole()))
			{
				return true;
			}
		}
		return false;
	}
	/*
	 * create new credentials during registration
	 */
	public boolean createCredentails(LoginDetails cred) {
		if(repo.findById(cred.getUsername()).isEmpty())
		{
			repo.save(cred);
			return true;
		}
		return false;
		
	}



}
