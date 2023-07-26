/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultorach;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 *
 * @author Zapa
 */
public class HibernateManager {
    public static SessionFactory Configure(){
        SessionFactory sessionFactory = null;
        
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return sessionFactory;
    }

	/*private static Session session;
	
	public synchronized static Session getSession() {
		if(session == null)
			session = getSessionFactory().openSession();
		return session;
	}
	
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure()	//configure settings from hibernate.cfg.xml
					.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch(Exception e){
			StandardServiceRegistryBuilder.destroy(registry);
		}

		return sessionFactory;
	}

	public static void closeSession() {
		session.close();
	}*/
}