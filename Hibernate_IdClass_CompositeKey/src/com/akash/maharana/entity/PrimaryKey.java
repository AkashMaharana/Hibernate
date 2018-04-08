package com.akash.maharana.entity;

import java.io.Serializable;

public class PrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String certificationCode;
	private Integer empId;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
