package com.akash.maharana.ui;

import com.akash.maharana.bean.Employee;
import com.akash.maharana.dao.EmployeeDAO;
import com.akash.maharana.resources.AppConfig;
import com.akash.maharana.resources.HibernateUtility;

public class UserInterface {
	
	public static void main(String[] args) {
		try{
			addEmployee();
		}
		finally {
			HibernateUtility.closeSessionFactory();
		}
	}
	
	public static void addEmployee(){
		try{
			Employee employee=new Employee();
			employee.setEmployeeName("Akash");
			employee.setBasicSalary(5000.00);
			employee.setAllowances(2000.00);
			Integer empId=new EmployeeDAO().addEmployee(employee);
			//String message=AppConfig.PROPERTIES.getProperty("UserInterface.NEW_EMPLOYEE_SUCCESS");
			System.out.println(empId);
		}
		catch (Exception e) {
			System.out.println(AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}

}
