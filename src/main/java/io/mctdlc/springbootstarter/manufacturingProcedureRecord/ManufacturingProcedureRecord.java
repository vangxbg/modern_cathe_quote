package io.mctdlc.springbootstarter.manufacturingProcedureRecord;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import io.mctdlc.springbootstarter.employeeTypeRecord.EmployeeTypeRecord;
import io.mctdlc.springbootstarter.productRecord.ProductRecord;

@Entity 
public class ManufacturingProcedureRecord {
	

	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Double timeRequired;
	@OneToOne
	private EmployeeTypeRecord employeeTypeRecord;
	@Column(name = "product_record_id")
	private Long productRecordId;
//	private ProductRecord productRecord;
	
	
	public ManufacturingProcedureRecord() {
		
	}
	
	public ManufacturingProcedureRecord(Long id, String name, Double timeRequired, Long employeeTypeRecordId, Long productRecordId) {
		super();
		this.id = id;
		this.name = name;
		this.timeRequired = timeRequired;
		this.employeeTypeRecord = new EmployeeTypeRecord(employeeTypeRecordId, "", null);
		this.productRecordId = productRecordId;
//		this.productRecord = new ProductRecord(productRecordId, "", "", "", "");
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(Double timeRequired) {
		this.timeRequired = timeRequired;
	}
	
	public Long getProductRecordId() {
		return productRecordId;
	}

	public void setProductRecordId(Long productRecordId) {
		this.productRecordId = productRecordId;
	}

//	public ProductRecord getProductRecord() {
//		return productRecord;
//	}
//
//	public void setProductRecord(ProductRecord productRecord) {
//		this.productRecord = productRecord;
//	}
	
	public EmployeeTypeRecord getEmployeeTypeRecord() {
		return employeeTypeRecord;
	}
	
	public void setEmployeeTypeRecord(EmployeeTypeRecord employeeTypeRecord) {
		this.employeeTypeRecord = employeeTypeRecord;
	}
	
	
}
