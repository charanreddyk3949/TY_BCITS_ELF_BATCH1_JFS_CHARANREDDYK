package com.bcits.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean  getEntityManager() {
		LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("emsPersitenceUnit");
		
		return factoryBean;
		
	}// End of getEntityManager()
	
	
//	@Bean
//	public LocalEntityManagerFactoryBean getEntityManager() {
//		LocalEntityManagerFactoryBean factoryBean= new LocalEntityManagerFactoryBean();
//		factoryBean.setPersistenceUnitName("emsPersitenceUnit");
//		
//		return factoryBean;
//
//	}//End of getEntityManager()
	

}//End of class
