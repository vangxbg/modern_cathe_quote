package io.mctdlc.springbootstarter.manufacturingProcedureRecord;

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
import io.mctdlc.springbootstarter.productRecord.ProductRecord;
import io.mctdlc.springbootstarter.productRecord.ProductRecordService;

@RestController
public class ManufacturingProcedureRecordController {
	
	
	@Autowired
	private ManufacturingProcedureRecordService mPRS;
	@Autowired
	private ProductRecordService pRS;
	
	@RequestMapping("/manufacturingProcedureRecords")
	public List<ManufacturingProcedureRecord> getAllManufacturingProcedureRecords() {
		return mPRS.getAllManufacturingProcedureRecords();
	}
	
	@RequestMapping("/manufacturingProcedureRecords/{id}")
	public Optional<ManufacturingProcedureRecord> getManufacturingProcedureRecord(@PathVariable Long id) {
		return mPRS.getManufacturingProcedureRecord(id);
	}
		@RequestMapping(method=RequestMethod.POST, value="/manufacturingProcedureRecords")
	public void addManufacturingProcedureRecord(@RequestBody Map<String, Object> payload) {
		ManufacturingProcedureRecord mPR = new ManufacturingProcedureRecord();
		mPR.setName(payload.get("name").toString());
		mPR.setTimeRequired(Double.parseDouble(payload.get("timeRequired").toString()));
		Long employeeTypeRecordId = Long.parseLong((payload.get("employeeTypeRecordId").toString()));
		mPR.setEmployeeTypeRecord(new EmployeeTypeRecord(employeeTypeRecordId, 
				"", null));
		Long productRecordId = Long.parseLong((payload.get("productRecordId").toString()));
		mPR.setProductRecordId(productRecordId);
//		mPR.setProductRecord(new ProductRecord(productRecordId, "", "", "", ""));
		mPRS.addManufacturingProcedureRecord(mPR);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/manufacturingProcedureRecords/{id}")
	public void updateManufacturingProcedure(@RequestBody Map<String, Object> payload, @PathVariable Long id) {
		ManufacturingProcedureRecord mPR = new ManufacturingProcedureRecord();
		mPR.setId(id);
		mPR.setName(payload.get("name").toString());
		mPR.setTimeRequired(Double.parseDouble(payload.get("timeRequired").toString()));
		Long employeeTypeRecordId = Long.parseLong((payload.get("employeeTypeRecordId").toString()));
		mPR.setEmployeeTypeRecord(new EmployeeTypeRecord(employeeTypeRecordId, 
				"", null));
		Long productRecordId = Long.parseLong((payload.get("productRecordId").toString()));
		mPR.setProductRecordId(productRecordId);
//		mPR.setProductRecord(new ProductRecord(productRecordId, "", "", "", ""));
		mPRS.updateManufacturingProcedureRecord(mPR, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/manufacturingProcedureRecords/{id}")
	public void deleteManufacturingProcedureRecord(@PathVariable Long id) {
		mPRS.deleteManufacturingProcedureRecord(id);
	}

}