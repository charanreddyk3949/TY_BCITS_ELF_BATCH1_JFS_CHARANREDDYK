package com.bcits.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean  getEntityManager() {
		LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("emsPersitenceUnit");
		
		return factoryBean;
		
	}// End of getEntityManager()
	

}//End of class
