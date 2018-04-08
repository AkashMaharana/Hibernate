package com.akash.maharana.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="employeeCertification")
@IdClass(PrimaryKey.class)
public class EmployeeCertificationEntity {
	
	@Id
	private String certificationCode;
	@Id
	private Integer empId;
	private Integer marks;
	public String getCertificationCode() {
		return certificationCode;
	}
	public void setCertificationCode(String certificationCode) {
		this.certificationCode = certificationCode;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}

}
