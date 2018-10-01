package io.mctdlc.springbootstarter.directLaborCost;

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

@RestController
public class DirectLaborCostController {
	
	
	@Autowired
	private DirectLaborCostService dLCS;
	
	@RequestMapping(method=RequestMethod.GET, value="/directLaborCosts")
	public List<DirectLaborCost> getAllDirectLaborCosts() {
		return dLCS.getAllDirectLaborCosts();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/directLaborCosts/{id}")
	public Optional<DirectLaborCost> getDirectLaborCost(@PathVariable Long id) {
		return dLCS.getDirectLaborCost(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/directLaborCosts")
	public void addDirectLaborCost(@RequestBody Map<String, Object> payload) {
		DirectLaborCost dLC = new DirectLaborCost();
		String number = payload.get("number").toString();
		dLC.setNumber(number);
		String revision = payload.get("revision").toString();
		dLC.setRevision(revision);
		Long productRecordId = Long.parseLong((payload.get("productRecordId").toString()));
		dLC.setProductRecord(new ProductRecord(productRecordId, "", "", "", ""));
		dLCS.addDirectLaborCost(dLC);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/directLaborCosts/{id}")
	public void updateDirectLaborCost(@RequestBody Map<String, Object> payload, @PathVariable Long id) {
		DirectLaborCost dLC = new DirectLaborCost();
		dLC.setId(id);
		String number = payload.get("number").toString();
		dLC.setNumber(number);
		String revision = payload.get("revision").toString();
		dLC.setRevision(revision);
		Long productRecordId = Long.parseLong((payload.get("productRecordId").toString()));
		dLC.setProductRecord(new ProductRecord(productRecordId, "", "", "", ""));
		dLCS.updateDirectLaborCost(dLC);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/directLaborCosts/{id}")
	public void deleteDirectLaborCost(@PathVariable Long id) {
		dLCS.deleteDirectLaborCost(id);
	}

	
}