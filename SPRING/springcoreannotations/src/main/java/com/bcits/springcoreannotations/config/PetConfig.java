package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.bcits.springcoreannotations.beans.Pet;
import com.bcits.springcoreannotations.interfaces.Animal;

@Import(AnimalConfig.class)
@Configuration
public class PetConfig {
	
	@Bean
	public Pet getPet() {
		Pet myPet=new Pet();
		myPet.setName("Tommy");
		
		return myPet;
	}//End of getPet

}//End of class
