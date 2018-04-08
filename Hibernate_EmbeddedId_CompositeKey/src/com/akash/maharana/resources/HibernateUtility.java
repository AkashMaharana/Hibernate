package com.akash.maharana.resources;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private static final String CONFIGURATION_LOCATION="com/akash/maharana/resources/hibernate.cfg.xml";
	private static SessionFactory sessionFactory=getSessionFactory();
	
	private static SessionFactory getSessionFactory(){
		try{
			if(sessionFactory==null){
				Configuration configuration=new Configuration().configure(CONFIGURATION_LOCATION);
				sessionFactory=configuration.buildSessionFactory();
			}
		}
		catch(Exception e){
			System.err.println("ERROR : HibernateUtility :"+e.getMessage());
			throw e;
		}
		return sessionFactory;
	}
	
	public static SessionFactory createSessionFactory(){
		return  getSessionFactory();
	}
	
	public static void closeSessionFactory(){
		try{
			if(!sessionFactory.isClosed() || sessionFactory!=null){
				sessionFactory.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}