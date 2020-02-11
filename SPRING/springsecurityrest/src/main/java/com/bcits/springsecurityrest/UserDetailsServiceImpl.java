package com.bcits.springsecurityrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bcits.springsecurityrest.dao.EmpDAO;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private EmpDAO dao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetailsImpl =new UserDetailsImpl();
		userDetailsImpl.setEmpInfoBean(dao.getEmplioyee(Integer.parseInt(username)));
		
		return userDetailsImpl;
	}//End of loadUserByUserName()

}//End of Class
