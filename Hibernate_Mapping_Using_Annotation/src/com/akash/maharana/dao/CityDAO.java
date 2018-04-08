package com.akash.maharana.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.akash.maharana.bean.City;
import com.akash.maharana.entity.CityEntity;
import com.akash.maharana.resources.HibernateUtility;

public class CityDAO {
	
	public Integer addCity(City city) throws Exception{
		SessionFactory sessionFactory=HibernateUtility.createSessionFactory();
		Session session =null;
		try{
			session=sessionFactory.openSession();
			CityEntity cityEntity=new CityEntity();
			cityEntity.setId(city.getId());
			cityEntity.setName(city.getName());
			cityEntity.setDistrict(city.getDistrict());
			cityEntity.setCountryCode(city.getCountryCode());
			cityEntity.setPopulation(city.getPopulation());
			session.getTransaction().begin();
			session.persist(cityEntity);
			session.getTransaction().commit();
		}
		catch (HibernateException exception) {
			exception.printStackTrace();
			throw exception;
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			if(session.isOpen() || session!=null){
				session.close();
			}
		}
		return city.getId();
	}

}
