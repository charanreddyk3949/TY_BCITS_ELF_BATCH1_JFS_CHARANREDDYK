package com.bcits.springsecurity.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
     
	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager getInMemoryUserDetailsManager() {
		InMemoryUserDetailsManager inMemoryManager= new InMemoryUserDetailsManager();
		
		inMemoryManager.createUser(
				User.withDefaultPasswordEncoder()
				.username("user").password("pwd").roles("user").build());
		
		inMemoryManager.createUser(
				User.withDefaultPasswordEncoder()
				.username("admin").password("qwerty").roles("admin").build());
		
		return inMemoryManager;

	}//End of memory Manager
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		http.csrf().disable()
		    .authorizeRequests()
		    .antMatchers("/index").permitAll()
		    .and()
		    .authorizeRequests()
		    .antMatchers("/userSecureHome").hasRole("user")
		    .and()		    
		    .authorizeRequests()
		    .antMatchers("/adminSecureHome").hasRole("admin")
		    .and()
		    .formLogin().loginPage("/login")
		    .and()
		    .logout().logoutSuccessUrl("/index");
	}//End of configure()
}//End of Class
