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
import com.akash.maharana.resources.HibernateUtility;

public class EmployeeCertificationDAO {
	
	public void addEmployeeCertification(EmployeeCertification employeeCertification) throws Exception{
		SessionFactory sessionFactory=HibernateUtility.createSessionFactory();
		Session session=null;
		try{
			session=sessionFactory.openSession();
			EmployeeEntity employeeEntity=session.get(EmployeeEntity.class, employeeCertification.getEmpId());
			CertificationEntity certificationEntity=session.get(CertificationEntity.class,employeeCertification.getCertificationCode());
			if(certificationEntity!=null && employeeEntity!=null){
				EmployeeCertificationEntity entity=new EmployeeCertificationEntity();
				entity.setEmpId(employeeEntity.getEmpId());
				entity.setCertificationCode(certificationEntity.getCertificationCode());
				entity.setMarks(employeeCertification.getMarks());
				session.getTransaction().begin();
				session.persist(entity);
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
	
	public EmployeeCertification getEmployeeCertification(Integer empId, String certificationCode) throws Exception{
		SessionFactory sessionFactory=HibernateUtility.createSessionFactory();
		Session session=sessionFactory.openSession();
		EmployeeCertification certification=new EmployeeCertification();
		try{
			EmployeeEntity entity=session.get(EmployeeEntity.class, empId);
			CertificationEntity entity2=session.get(CertificationEntity.class, certificationCode);
			if(entity!=null && entity2!=null){
				certification.setCertificationCode(entity2.getCertificationCode());
				certification.setCertifictionName(entity2.getCertificationName());
				certification.setCertifictionType(entity2.getCertificationType());
				certification.setEmpId(entity.getEmpId());
				certification.setEmployeeName(entity.getName());
			}
		}
		
		/*try{
			EmployeeEntity entity=session.get(EmployeeEntity.class, empId);
			CertificationEntity entity2=session.get(CertificationEntity.class, certificationCode);
			PrimaryKey primaryKey=new PrimaryKey();
			if(entity!=null && entity2!=null){
				primaryKey.setCertificationCode(certificationCode);
				primaryKey.setEmpId(empId);
			}
			
			EmployeeCertificationEntity entity3=session.get(EmployeeCertificationEntity.class, primaryKey);
			
			//Then we can set the values directly to the EmployeeCertification attributes.
		}*/
		
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
		return certification;
	}

}
