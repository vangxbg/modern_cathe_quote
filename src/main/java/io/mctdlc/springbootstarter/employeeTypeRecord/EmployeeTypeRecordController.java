package io.mctdlc.springbootstarter.employeeTypeRecord;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeTypeRecordController {
	
	
	@Autowired
	private EmployeeTypeRecordService eTRS;
	
	@RequestMapping(method=RequestMethod.GET, value="/employeeTypeRecords")
	public List<EmployeeTypeRecord> getAllEmployeeTypes() {
		return eTRS.getAllEmployeeTypeRecords();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employeeTypeRecords/{id}")
	public Optional<EmployeeTypeRecord> getEmployeeTypeRecord(@PathVariable Long id) {
		return eTRS.getEmployeeTypeRecord(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employeeTypeRecords")
	public void addEmployeeTypeRecord(@RequestBody EmployeeTypeRecord eTR) {
		eTRS.addEmployeeTypeRecord(eTR);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employeeTypeRecords/{id}")
	public void updateEmployeeTypeRecord(@RequestBody Map<String, Object> payload, @PathVariable Long id) {
		EmployeeTypeRecord eTR = new EmployeeTypeRecord();
		eTR.setId(id);
		Double payrate = Double.parseDouble(payload.get("payrate").toString());
		eTR.setPayrate(payrate);
		String title = payload.get("title").toString();
		eTR.setTitle(title);
		eTRS.updateEmployeeTypeRecord(eTR);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employeeTypeRecords/{id}")
	public void deleteEmployeeType(@PathVariable Long id) {
		eTRS.deleteEmployeeTypeRecord(id);
	}

	
}