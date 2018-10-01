package io.mctdlc.springbootstarter.manufacturingProcedureRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mctdlc.springbootstarter.productRecord.ProductRecordRepository;


@Service
public class ManufacturingProcedureRecordService {
	
	@Autowired
	private ManufacturingProcedureRecordRepository mPRR;
	@Autowired
	private ProductRecordRepository pRR;
	
	public List<ManufacturingProcedureRecord> getAllManufacturingProcedureRecords() {
		List<ManufacturingProcedureRecord> mPRL = new ArrayList<>();
		mPRR.findAll()
		.forEach(mPRL::add);
		return mPRL;
	}
	
	public List<ManufacturingProcedureRecord> getAllManufacturingProcedureRecordsById(Long id) {
		List<ManufacturingProcedureRecord> mPRL = new ArrayList<>();
		mPRR.findByProductRecordId(id)
		.forEach(mPRL::add);
		return mPRL;
	}
	
	public Optional<ManufacturingProcedureRecord> getManufacturingProcedureRecord(Long id) {
		return mPRR.findById(id);
	}

	public void addManufacturingProcedureRecord(ManufacturingProcedureRecord mPR) {
		mPRR.save(mPR);
	}

	public void updateManufacturingProcedureRecord(ManufacturingProcedureRecord mPR, Long id) {
		mPRR.save(mPR);
	}

	public void deleteManufacturingProcedureRecord(Long id) {
		mPRR.deleteById(id);
	}

}
