package io.mctdlc.springbootstarter.manufacturingProcedureRecord;

import java.util.List;

import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturingProcedureRecordRepository extends CrudRepository<ManufacturingProcedureRecord, Long> {
	
	public List<ManufacturingProcedureRecord> findByProductRecordId(Long id);
	
//	@Modifying
//	@Query("update ManufacturingProcedure mp set mp.name = ?1 mp.timeRequired = ?2 mp.employeeTypeId = ?3 mp.directLaborCostId = ?4 where mp.id = ?5")
//	void setManufacturingProcedureInfoById(String name, Double timeRequired, Long employeeTypeId, Long directLaborCostId, Long id);
	
	
}
