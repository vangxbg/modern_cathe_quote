package io.mctdlc.springbootstarter.employeeTypeRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTypeRecordService {
	
	
	@Autowired
	private EmployeeTypeRecordRepository eTRR;
	
	public List<EmployeeTypeRecord> getAllEmployeeTypeRecords() {
		List<EmployeeTypeRecord> eTRL = new ArrayList<>();
		eTRR.findAll()
		.forEach(eTRL::add);
		return eTRL;
	}
	
	public Optional<EmployeeTypeRecord> getEmployeeTypeRecord(Long id) {
		return eTRR.findById(id);
	}

	public void addEmployeeTypeRecord(EmployeeTypeRecord eTR) {
		eTRR.save(eTR);
	}

	public void updateEmployeeTypeRecord(EmployeeTypeRecord eTR) {
		eTRR.save(eTR);
	}

	public void deleteEmployeeTypeRecord(Long id) {
		eTRR.deleteById(id);
	}

}
