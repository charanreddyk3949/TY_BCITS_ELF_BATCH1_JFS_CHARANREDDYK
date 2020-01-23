package com.bcits.springcoreannotations.config;

import javax.lang.model.element.Element;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bcits.springcoreannotations.interfaces.Elephanet;
import com.bcits.springcoreannotations.interfaces.Goat;

@Configuration
public class AnimalConfig {
	
	@Bean
	@Primary
	public Goat getGoat() {
		return new Goat();
	}
	
	@Bean
	public Elephanet getElephanet() {
		return new Elephanet();
	}

}
