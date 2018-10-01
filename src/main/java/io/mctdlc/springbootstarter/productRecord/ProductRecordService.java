package io.mctdlc.springbootstarter.productRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductRecordService {
	
	@Autowired
	private ProductRecordRepository pR;
	
	public List<ProductRecord> getAllProductRecords() {
		List<ProductRecord> pL = new ArrayList<>();
		pR.findAll()
		.forEach(pL::add);
		return pL;
	}
	
	public Optional<ProductRecord> getProductRecord(Long id) {
		return pR.findById(id);
	}

	public void addProductRecord(ProductRecord p) {
		pR.save(p);
	}

	public void updateProductRecord(ProductRecord p, Long id) {
		pR.save(p);
	}

	public void deleteProductRecord(Long id) {
		pR.deleteById(id);
	}

}
