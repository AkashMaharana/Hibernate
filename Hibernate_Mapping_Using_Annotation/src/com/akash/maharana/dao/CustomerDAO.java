package com.akash.maharana.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.akash.maharana.bean.Customer;
import com.akash.maharana.entity.CustomerEntity;
import com.akash.maharana.resources.HibernateUtility;

public class CustomerDAO {
	
	public String addCustomer(Customer customer) throws Exception{
		SessionFactory sessionFactory=HibernateUtility.createSessionFactory();
		Session session =null;
		try{
			session=sessionFactory.openSession();
			CustomerEntity customerEntity=new CustomerEntity();
			customerEntity.setCustomerId(customer.getCustomerId());
			customerEntity.setCustomerName(customer.getCustomerName());
			customerEntity.setCity(customer.getCity());
			customerEntity.setEmail(customer.getEmail());
			customerEntity.setDateOfBirth(customer.getDateOfBirth());
			customerEntity.setCity(customer.getCity());
			session.getTransaction().begin();
			session.persist(customerEntity);
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
		return customer.getCustomerName();
	}

}
