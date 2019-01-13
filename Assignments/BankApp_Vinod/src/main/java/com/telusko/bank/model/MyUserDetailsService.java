package com.telusko.bank.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jdk.nashorn.internal.runtime.UserAccessorProperty;

@Service
public class MyUserDetailsService  implements UserDetailsService
{
	@Autowired
	public UserRepository userRepository;
	@Autowired
	private AuthGroupRepository authGroupRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		User user = userRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User not found");
		
		List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);		
		
		return new UserPrincipal(user,authGroups);
	}
	
}
