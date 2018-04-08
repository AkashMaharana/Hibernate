package com.akash.maharana.bean;

public class EmployeeCertification {
	
	private String certificationCode;
	private Integer marks;
	private Integer empId;
	private String employeeName;
	private String certifictionName;
	private String certifictionType;
	
	public String getCertificationCode() {
		return certificationCode;
	}
	public void setCertificationCode(String certificationCode) {
		this.certificationCode = certificationCode;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCertifictionName() {
		return certifictionName;
	}
	public void setCertifictionName(String certifictionName) {
		this.certifictionName = certifictionName;
	}
	public String getCertifictionType() {
		return certifictionType;
	}
	public void setCertifictionType(String certifictionType) {
		this.certifictionType = certifictionType;
	}
	
}
