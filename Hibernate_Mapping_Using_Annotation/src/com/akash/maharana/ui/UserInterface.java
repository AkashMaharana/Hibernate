package com.akash.maharana.ui;

import java.util.Calendar;

import com.akash.maharana.bean.City;
import com.akash.maharana.bean.Customer;
import com.akash.maharana.dao.CityDAO;
import com.akash.maharana.dao.CustomerDAO;
import com.akash.maharana.resources.HibernateUtility;

public class UserInterface {
	
	public static void main(String[] args) {
		try{
			addCustomer();
			//addCity();
		}
		finally{
			HibernateUtility.closeSessionFactory();
		}
	}
	
	public static void addCustomer(){
		try{
			Customer customer=new Customer();
			customer.setCustomerId(1003);
			customer.setCustomerName("Akash Maharana");
			customer.setCity("Pune");
			customer.setEmail("akashmaharana93@gmail.com");
			Calendar dateOfBirth=Calendar.getInstance();
			dateOfBirth.set(1993, 05, 20);
			customer.setDateOfBirth(dateOfBirth);
			customer.setCity("Rourkela");
			String name=new CustomerDAO().addCustomer(customer);
			System.out.println("Customer added successfully with name : "+name);
		}
		catch(Exception e){
			System.err.println("\nERROr: "+e.getMessage());
		}
	}
	
	public static void addCity(){
		try{
			City city=new City();
			city.setId(100003);
			city.setName("Rourkela");
			city.setDistrict("Sundargadh");
			city.setCountryCode("ABW");
			city.setPopulation(100000);
			Integer id=new CityDAO().addCity(city);
			System.out.println("City added successfully with id : "+id);
		}
		catch(Exception e){
			System.err.println("\nERROr: "+e.getMessage());
		}
	}
}
