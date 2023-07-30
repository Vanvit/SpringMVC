package com.example.jdbcExample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jdbcExample.entity.RoleEntity;
import com.example.jdbcExample.entity.UserEntity;
import com.example.jdbcExample.repository.UserRepository;
@Service
@Transactional
public class MyAppUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserEntity> userOpt = userRepository.findByUsername(username);
		if (!userOpt.isPresent()) {
			throw new ApplicationContextException("User not found!!!");
		}
		UserEntity userEntity = userOpt.get();
		
		//User Entity  -> User Detail cua Spring
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		
		List<RoleEntity> roleEntities = userEntity.getRoles();
		for (RoleEntity roleEntity : roleEntities) {
			GrantedAuthority authority = new SimpleGrantedAuthority(roleEntity.getCode());
			roles.add(authority);
		}
		
		UserDetails userDetails = User
				.withUsername(userEntity.getUsername())
				.password(userEntity.getPassword())
				.authorities(roles)
				.build();
		
		return userDetails;
	}

}
