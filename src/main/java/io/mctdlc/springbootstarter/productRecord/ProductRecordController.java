package io.mctdlc.springbootstarter.productRecord;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mctdlc.springbootstarter.employeeTypeRecord.EmployeeTypeRecord;
import io.mctdlc.springbootstarter.manufacturingProcedureRecord.ManufacturingProcedureRecord;
import io.mctdlc.springbootstarter.manufacturingProcedureRecord.ManufacturingProcedureRecordService;

@RestController
public class ProductRecordController {
	
	
	@Autowired
	private ProductRecordService pRS;
	@Autowired
	private ManufacturingProcedureRecordService mPRS;
	
	@RequestMapping("/productRecords")
	public List<ProductRecord> getAllproductRecords() {
		return pRS.getAllProductRecords();
	}
	
	@RequestMapping("/productRecords/{id}")
	public Optional<ProductRecord> getProductRecord(@PathVariable Long id) {
//		List<ManufacturingProcedureRecord> mPRL = mPRS.getAllManufacturingProcedureRecordsById(id);
//		ProductRecord pR = new ProductRecord();
//		pR.setManufacturingProcedureRecords(mPRL);
//		return pR;
		return pRS.getProductRecord(id);
	}
	
//	@RequestMapping("/productRecordsManufactuingList/{id}")
//	public List<ManufacturingProcedureRecord> getProductRecordRecord(@PathVariable Long id) {
//		List<ManufacturingProcedureRecord> mPRL = mPRS.getAllManufacturingProcedureRecordsById(id);
//		return mPRL;
//	}
	
		@RequestMapping(method=RequestMethod.POST, value="/productRecords")
	public void addProductRecord(@RequestBody ProductRecord pR) {
		pRS.addProductRecord(pR);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/productRecords/{id}")
	public void updateProductRecord(@RequestBody Map<String, Object> payload, @PathVariable Long id) {
		ProductRecord pR = new ProductRecord();
		pR.setId(id);
		String description = payload.get("description").toString();
		pR.setDescription(description);
		String name = payload.get("name").toString();
		pR.setName(name);
		String number = payload.get("number").toString();
		pR.setNumber(number);
		String revision = payload.get("revision").toString();
		pR.setRevision(revision);
		pRS.updateProductRecord(pR, id);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/productRecords/{id}")
	public void deleteProductRecord(@PathVariable Long id) {
		pRS.deleteProductRecord(id);
	}

}