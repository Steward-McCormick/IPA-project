package ru.mccormick.ipa.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import ru.mccormick.ipa.models.User;

public class HibernateSessionFactory {
	
	private static SessionFactory sessionFactory;

	public HibernateSessionFactory() {}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();
				configuration.addAnnotatedClass(User.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
				sessionFactory = configuration.buildSessionFactory(builder.build());
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		return sessionFactory;
	}
}
