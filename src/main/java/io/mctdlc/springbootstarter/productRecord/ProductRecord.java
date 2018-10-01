package io.mctdlc.springbootstarter.productRecord;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.mctdlc.springbootstarter.manufacturingProcedureRecord.ManufacturingProcedureRecord;

@Entity 
public class ProductRecord {
	

	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private String number;
	private String revision;
	@OneToMany
	@JoinColumn(name = "product_record_id", referencedColumnName = "id")
	private List<ManufacturingProcedureRecord> manufacturingProcedureRecords;
	
	
	public ProductRecord() {
		
	}

	public ProductRecord(Long id, String name, String description, String number, String revision) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.number = number;
		this.revision = revision;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public List<ManufacturingProcedureRecord> getManufacturingProcedureRecords() {
		return manufacturingProcedureRecords;
	}
	
//	public List<ManufacturingProcedureRecord> getManufacturingProcedureRecordsById() {
//		return manufacturingProcedureRecords;
//	}

	public void setManufacturingProcedureRecords(List<ManufacturingProcedureRecord> manufacturingProcedureRecords) {
		this.manufacturingProcedureRecords = manufacturingProcedureRecords;
	}
	
	
}
