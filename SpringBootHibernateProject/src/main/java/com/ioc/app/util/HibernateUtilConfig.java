package com.ioc.app.util;


import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateUtilConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SessionFactory getSessionFactory(){
		if(entityManagerFactory.unwrap(SessionFactory.class)==null) {
			throw new NullPointerException("Factory is not a hibernate facotry.");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}
