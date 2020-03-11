package com.metacube.training.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.UserData;

@Service
public class UserDetailsImpl implements UserDetailsService{

	@Autowired
	private EmployeeDAO userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		
		Optional<EmployeeCommands> userCommands = userRepo.findByEmail(email);
		
		userCommands.ifPresent(Employee -> {
		    System.out.println("User's is here ss = " + userCommands.get().getRoles());   });
		
		userCommands.orElseThrow( () -> new UsernameNotFoundException( "Not found " + email));
		
		return userCommands.map(UserData::new).get();

	}
	

}