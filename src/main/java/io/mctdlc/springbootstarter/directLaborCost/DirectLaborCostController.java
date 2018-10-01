package io.mctdlc.springbootstarter.directLaborCost;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.mctdlc.springbootstarter.employeeTypeRecord.EmployeeTypeRecord;
import io.mctdlc.springbootstarter.employeeTypeRecord.EmployeeTypeRecordService;
import io.mctdlc.springbootstarter.manufacturingProcedureRecord.ManufacturingProcedureRecord;
import io.mctdlc.springbootstarter.manufacturingProcedureRecord.ManufacturingProcedureRecordService;
import io.mctdlc.springbootstarter.productRecord.ProductRecord;
import io.mctdlc.springbootstarter.productRecord.ProductRecordService;

@RestController
public class DirectLaborCostController {


	@Autowired
	private DirectLaborCostService dLCS;
	@Autowired
	private ProductRecordService pRS;
	@Autowired
	private ManufacturingProcedureRecordService mPRS;
	@Autowired
	private EmployeeTypeRecordService eTRS;

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

	@RequestMapping(method=RequestMethod.POST, value="/createDirectLaborCost")
	public void createDirectLaborCost(@RequestParam Map<String, Object> payload) {

		// set up the product Record
		ProductRecord pR = new ProductRecord();
		String pDescription = payload.get("pDescription").toString();
		String pName = payload.get("pName").toString();
		String pNumber = payload.get("pNumber").toString();
		String pRevision = payload.get("pRevision").toString();
		pR.setDescription(pDescription);
		pR.setName(pName);
		pR.setNumber(pNumber);
		pR.setRevision(pRevision);
		pRS.addProductRecord(pR);

		// loop through the number of manufacturing procedures
		// get the number of manufacturing procedures/employee types
		Integer mPCount = Integer.parseInt(payload.get("mpCount").toString());
		for(int i = 0; i < mPCount; i++) {
			// set up the employee Type Records
			EmployeeTypeRecord eT = new EmployeeTypeRecord();
			String eTTitle = payload.get("etTitle" + String.valueOf(i+1)).toString();
			Double eTPayRate = Double.parseDouble(payload.get("etPayRate" + String.valueOf(i+1)).toString());
			eT.setTitle(eTTitle);
			eT.setPayrate(eTPayRate);
			eTRS.addEmployeeTypeRecord(eT);

			// set up the manufacturing procedure records
			ManufacturingProcedureRecord mP = new ManufacturingProcedureRecord();
			String mPName = payload.get("mpName" + String.valueOf(i+1)).toString();
			Double mPTimeRequired = Double.parseDouble(payload.get("mpTimeRequired" + String.valueOf(i+1)).toString());
			mP.setName(mPName);
			mP.setTimeRequired(mPTimeRequired);
			mP.setProductRecordId(pR.getId());
			mP.setEmployeeTypeRecord(eT);
			mPRS.addManufacturingProcedureRecord(mP);
		}

		// set up the direct labor cost record
		DirectLaborCost dLC = new DirectLaborCost();
		String dlcNumber = payload.get("dlcNumber").toString();
		String dlcRevision = payload.get("dlcRevision").toString();
		dLC.setNumber(dlcNumber);
		dLC.setRevision(dlcRevision);
		dLC.setProductRecord(pR);
		dLCS.addDirectLaborCost(dLC);
	}

//	@RequestMapping(value="/createDirectLaborCost", method=RequestMethod.POST)
//	public ModelAndView showCreateDirectLaborCost(@RequestParam Map<String, Object> payload) {
//		ModelAndView mv = new ModelAndView();
//		String dlcNumber = payload.get("dlcNumber").toString();
//		String dlcRevision = payload.get("dlcRevision").toString();
//		String pDescription = payload.get("pDescription").toString();
//		String pName = payload.get("pName").toString();
//		String pNumber = payload.get("pNumber").toString();
//		String pRevision = payload.get("pRevision").toString();
//		String mpCount = payload.get("mpCount").toString();
//		String mp1Name = payload.get("mp1Name").toString();
//		mv.addObject("dlcNumber", dlcNumber);
//		mv.addObject("dlcRevision", dlcRevision);
//		mv.addObject("pDescription", pDescription);
//		mv.addObject("pName", pName);
//		mv.addObject("pNumber", pNumber);
//		mv.addObject("pRevision", pRevision);
//		mv.addObject("mpCount", mpCount);
//		mv.addObject("payload", payload);
//		mv.addObject("mp1Name", mp1Name);
//		mv.setViewName("created");
//		return mv;
//	}

	@GetMapping("/createDirectLaborCost")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}


	@RequestMapping("/test")
	public ModelAndView test(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.setViewName("test");
		return mv;
	}


}
