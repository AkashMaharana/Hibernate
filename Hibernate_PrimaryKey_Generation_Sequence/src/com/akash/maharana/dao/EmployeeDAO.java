package com.akash.maharana.dao;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.akash.maharana.bean.Employee;
import com.akash.maharana.entity.EmployeeEntity;
import com.akash.maharana.resources.HibernateUtility;

public class EmployeeDAO {
	
	public Integer addEmployee(Employee employee) throws Exception{
		SessionFactory sessionFactory=HibernateUtility.createSessionFactory();
		Session session =sessionFactory.openSession();
		Integer empId=null;
		try{
			EmployeeEntity employeeEntity=new EmployeeEntity();
			employeeEntity.setEmployeeName(employee.getEmployeeName());
			employeeEntity.setBasicSalary(employee.getBasicSalary());
			employeeEntity.setAllowances(employee.getAllowances());
			session.getTransaction().begin();
			empId=(Integer) session.save(employeeEntity);
			session.getTransaction().commit();
		}
		catch (HibernateException exception) {
			DOMConfigurator.configure("src/com/akash/maharana/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(),exception);
			throw new Exception("DAO.TECHNICAL_ERROR");
 		}
		catch(Exception exception){
			DOMConfigurator.configure("src/com/akash/maharana/resources/log4j.xml");
			Logger logger=Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(),exception);
			throw exception;
		}
		finally{
			if(session.isOpen() || session!=null){
				session.close();
			}
		}
		return empId;
		
	}

}
