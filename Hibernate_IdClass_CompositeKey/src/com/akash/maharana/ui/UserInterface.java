package com.akash.maharana.ui;

import com.akash.maharana.bean.EmployeeCertification;
import com.akash.maharana.dao.EmployeeCertificationDAO;
import com.akash.maharana.resources.AppConfig;

public class UserInterface {
	
	public static void addEmployeeCertification(){
		try{
			EmployeeCertification certification=new EmployeeCertification();
			certification.setCertificationCode("IZO-804");
			certification.setEmpId(101);
			certification.setMarks(93);
			EmployeeCertificationDAO dao=new EmployeeCertificationDAO();
			dao.addEmployeeCertification(certification);
			String message=AppConfig.PROPERTIES.getProperty("UserInterface.NEW_EMPLOYEE_SUCCESS");
			System.out.println(message);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void getEmployeeCertification() throws Exception{
		EmployeeCertificationDAO dao=new EmployeeCertificationDAO();
		EmployeeCertification certification=dao.getEmployeeCertification(102, "IZO-805");
		System.out.println(certification.getEmployeeName());
		System.out.println(certification.getCertificationCode());
		System.out.println(certification.getCertifictionType());
		System.out.println(certification.getCertifictionName());
		System.out.println(certification.getEmpId());
	}
	
	public static void main(String[] args) throws Exception {
		//addEmployeeCertification();
		getEmployeeCertification();
	}

}
