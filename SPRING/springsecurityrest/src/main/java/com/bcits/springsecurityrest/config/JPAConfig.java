package com.bcits.springsecurityrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JPAConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean getLocalEntityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean=new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("emsPersitenceUnit");
		return factoryBean;
	}

}//End of Class
