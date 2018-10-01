package io.mctdlc.springbootstarter.directLaborCost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.mctdlc.springbootstarter.productRecord.ProductRecord;

@Entity
public class DirectLaborCost {

	
	@Id @GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	private String number;
	private String Revision;
	@ManyToOne
	private ProductRecord productRecord;
	
	
	public DirectLaborCost() {

	}

	public DirectLaborCost(Long id, String number, String revision, Long productRecordId) {
		super();
		this.id = id;
		this.number = number;
		Revision = revision;
		this.productRecord = new ProductRecord(productRecordId, "", "", "", "");
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRevision() {
		return Revision;
	}

	public void setRevision(String revision) {
		Revision = revision;
	}

	public ProductRecord getProductRecord() {
		return productRecord;
	}

	public void setProductRecord(ProductRecord productRecord) {
		this.productRecord = productRecord;
	}
	
	
}
