package io.mctdlc.springbootstarter.employeeTypeRecord;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeTypeRecord {

	
	@Id @GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	private String title;
	private Double payrate;
	
	
	public EmployeeTypeRecord() {

	}

	public EmployeeTypeRecord(Long id, String title, Double payrate) {
		super();
		this.id = id;
		this.title = title;
		this.payrate = payrate;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPayrate() {
		return payrate;
	}

	public void setPayrate(Double payrate) {
		this.payrate = payrate;
	}
	
	
}
