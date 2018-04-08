package com.akash.maharana.dao;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.akash.maharana.bean.EmployeeCertification;
import com.akash.maharana.entity.CertificationEntity;
import com.akash.maharana.entity.EmployeeCertificationEntity;
import com.akash.maharana.entity.EmployeeEntity;
import com.akash.maharana.entity.PrimaryKey;
import com.akash.maharana.resources.HibernateUtility;

public class EmployeeCetificationDAO {
	
	public void addEmployeeCertification(EmployeeCertification employeeCertification) throws Exception{
		SessionFactory sessionFactory=HibernateUtility.createSessionFactory();
		Session session=sessionFactory.openSession();
		try{
			EmployeeEntity employeeEntity=session.get(EmployeeEntity.class, employeeCertification.getEmpId());
			CertificationEntity certificationEntity=session.get(CertificationEntity.class, employeeCertification.getCertificationCode());
			if(employeeEntity!=null && certificationEntity!=null){
				PrimaryKey primaryKey=new PrimaryKey();
				primaryKey.setEmpId(employeeCertification.getEmpId());
				primaryKey.setCertificationCode(employeeCertification.getCertificationCode());
				
				EmployeeCertificationEntity employeeCertificationEntity=new EmployeeCertificationEntity();
				employeeCertificationEntity.setMarks(employeeCertification.getMarks());
				employeeCertificationEntity.setPrimaryKey(primaryKey);
				session.getTransaction().begin();
				session.persist(employeeCertificationEntity);
				session.getTransaction().commit();
			}
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
	}
	
	public EmployeeCertification getEmployeeCertificationDetails(Integer empId,String certificationCode) throws Exception{
		SessionFactory sessionFactory=HibernateUtility.createSessionFactory();
		Session session=sessionFactory.openSession();
		EmployeeCertification employeeCertification=new EmployeeCertification();
		try{
			EmployeeEntity employeeEntity=session.get(EmployeeEntity.class, empId);
			CertificationEntity certificationEntity=session.get(CertificationEntity.class, certificationCode);
			PrimaryKey primaryKey=null;
			if(employeeEntity!=null && certificationEntity!=null){
				primaryKey=new PrimaryKey();
				primaryKey.setEmpId(empId);
				primaryKey.setCertificationCode(certificationCode);
			}
			EmployeeCertificationEntity employeeCertificationEntity=session.get(EmployeeCertificationEntity.class, primaryKey);
			if(employeeCertificationEntity!=null){
				employeeCertification.setMarks(employeeCertificationEntity.getMarks());
				employeeCertification.setEmpId(employeeEntity.getEmpId());
				employeeCertification.setCertificationCode(certificationEntity.getCertificationCode());
				employeeCertification.setCertifictionName(certificationEntity.getCertificationName());
				employeeCertification.setCertifictionType(certificationEntity.getCertificationType());
				employeeCertification.setEmployeeName(employeeEntity.getName());
			}
			
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
		return employeeCertification;
	}

}
