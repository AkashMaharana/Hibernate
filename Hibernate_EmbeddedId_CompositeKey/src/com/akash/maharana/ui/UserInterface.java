package com.akash.maharana.ui;

import com.akash.maharana.bean.EmployeeCertification;
import com.akash.maharana.dao.EmployeeCetificationDAO;

public class UserInterface {
	public static void main(String[] args) throws Exception {
		//addEmployeeCertification();
		getEmployeeCertificationDetails();
	}
	
	public static void getEmployeeCertificationDetails() throws Exception {
		EmployeeCertification employeeCertification=new EmployeeCetificationDAO().getEmployeeCertificationDetails(101, "IZO-805");
		System.out.println(employeeCertification.getEmpId());
		System.out.println(employeeCertification.getEmployeeName());
		System.out.println(employeeCertification.getCertificationCode());
		System.out.println(employeeCertification.getCertifictionName());
		System.out.println(employeeCertification.getCertifictionType());
		System.out.println(employeeCertification.getMarks());
	}

	public static void addEmployeeCertification() throws Exception{
		EmployeeCertification employeeCertification=new EmployeeCertification();
		employeeCertification.setEmpId(102);
		employeeCertification.setCertificationCode("IZO-809");
		employeeCertification.setMarks(100);
		EmployeeCetificationDAO dao=new EmployeeCetificationDAO();
		dao.addEmployeeCertification(employeeCertification);
		System.out.println("Hi");
	}
}
